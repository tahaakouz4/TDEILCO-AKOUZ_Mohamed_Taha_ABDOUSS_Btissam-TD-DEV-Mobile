package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.td6.interfaceApi.GithubService;
import com.example.td6.model.Repo;
import com.example.td6.model.RepoItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    GithubService githubService;

    public MainActivity(){
        githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        githubService.listRepos("adrienbusin").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                afficherRepos(response.body());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            EditText editText = findViewById(R.id.edittext);
            String search = editText.getText().toString();
            githubService.searchRepos(search).enqueue(new Callback<RepoItem>() {
                @Override
                public void onResponse(Call<RepoItem> call, Response<RepoItem> response) {
                    afficherRepoTrouve(response.body());
                }

                @Override
                public void onFailure(Call<RepoItem> call, Throwable t) {
                    Log.e("my error",t.getMessage());
                }
            });
        });
    }

    public void afficherRepos(List<Repo> repos) {
        Toast.makeText(this,"nombre de dépots : "+repos.size(), Toast.LENGTH_SHORT).show();
    }

    public void afficherRepoTrouve(RepoItem repo){

        Intent intent = new Intent(MainActivity.this, ListRepoActivity.class);
        intent.putExtra("repo", repo);
        startActivity(intent);
    }
}