package com.daud.retrogetpostidobject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private EditText postIdEt;
    private Button enterBtn;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ApiInterface apiInterface;
    List<AdapterMc> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postIdEt = findViewById(R.id.postIdEt);
        enterBtn = findViewById(R.id.enterBtn);
        progressBar = findViewById(R.id.progressBar);
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        apiInterface = RetrofitInit.getRetro().create(ApiInterface.class);

        enterBtn.setOnClickListener(view -> {

            String input = postIdEt.getText().toString();

            if (input.isEmpty()){
                Toast.makeText(MainActivity.this, "Enter postId", Toast.LENGTH_SHORT).show();
            }else{
                progressBar.setVisibility(View.VISIBLE);
                int inId = Integer.parseInt(input);
                apiInterface.getData(inId).enqueue(new Callback<ModelClass>() {
                    @Override
                    public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                        if (response.isSuccessful()){
                            postIdEt.setText("");
                            int userId = response.body().getUserId();
                            int id = response.body().getId();
                            String title = response.body().getTitle();
                            String body = response.body().getBody();
                            AdapterMc adapterMc = new AdapterMc(userId,id,title,body);

                            if (list.size() > 0){
                                progressBar.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                                recyclerView.setAdapter(new MyAdapter(MainActivity.this,list));
                                postIdEt.setHint("Now postId is: "+ id);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelClass> call, Throwable t) {

                    }
                });
            }
        });
    }
}