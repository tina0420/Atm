package com.tina.atm;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends AppCompatActivity {

    int[] numbers = {19,20,21,22,23,24,25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AgeAdapter());
    }

    public void next(View view){
        int age = Integer.parseInt(((EditText)findViewById(R.id.ed_age)).getText().toString());
        getSharedPreferences("user",MODE_PRIVATE)
                .edit()
                .putInt("AGE",age)
                .apply();
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }
    public void back(View view){
        finish();
    }


    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeViewHolder>{

        @NonNull
        @Override
        public AgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.age_row,parent,false);
            return new AgeViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AgeViewHolder holder, int position) {
            holder.ageView.setText(numbers[position]+"");
            if(numbers[position] == 19){
                holder.ageView.setTextColor(Color.BLUE);
            }
        }



        @Override
        public int getItemCount() {
            return numbers.length;
        }

        class AgeViewHolder extends RecyclerView.ViewHolder{
            TextView ageView;
            public AgeViewHolder(View itemView) {
                super(itemView);
                ageView = itemView.findViewById(R.id.tv_age);
            }
        }
    }

}
