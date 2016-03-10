package com.mfpv.contadordepuntos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<Integer, ImageView> viewPointsMapTeamA = new HashMap<>();
    private Map<Integer, ImageView> viewPointsMapTeamB = new HashMap<>();
    private Map<Integer, Integer> imagePointsMap = new HashMap<>();
    private ImageView imageViewTeamA;
    private TextView textViewTeamA;
    private ImageView imageViewTeamB;
    private TextView textViewTeamB;

    Team teamA = new Team();
    Team teamB = new Team();

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPointsMapTeamA.put(0, (ImageView) findViewById(R.id.pointsTeamA1));
        viewPointsMapTeamA.put(1, (ImageView) findViewById(R.id.pointsTeamA2));
        viewPointsMapTeamA.put(2, (ImageView) findViewById(R.id.pointsTeamA3));
        viewPointsMapTeamA.put(3, (ImageView) findViewById(R.id.pointsTeamA4));
        viewPointsMapTeamA.put(4, (ImageView) findViewById(R.id.pointsTeamA5));
        viewPointsMapTeamA.put(5, (ImageView) findViewById(R.id.pointsTeamA6));

        viewPointsMapTeamB.put(0, (ImageView) findViewById(R.id.pointsTeamB1));
        viewPointsMapTeamB.put(1, (ImageView) findViewById(R.id.pointsTeamB2));
        viewPointsMapTeamB.put(2, (ImageView) findViewById(R.id.pointsTeamB3));
        viewPointsMapTeamB.put(3, (ImageView) findViewById(R.id.pointsTeamB4));
        viewPointsMapTeamB.put(4, (ImageView) findViewById(R.id.pointsTeamB5));
        viewPointsMapTeamB.put(5, (ImageView) findViewById(R.id.pointsTeamB6));

        imagePointsMap.put(0, R.drawable.points_0);
        imagePointsMap.put(1, R.drawable.points_1);
        imagePointsMap.put(2, R.drawable.points_2);
        imagePointsMap.put(3, R.drawable.points_3);
        imagePointsMap.put(4, R.drawable.points_4);
        imagePointsMap.put(5, R.drawable.points_5);

        imageViewTeamA = viewPointsMapTeamA.get(0);
        textViewTeamA = (TextView) findViewById(R.id.pointsTeamA);
        imageViewTeamB = viewPointsMapTeamB.get(0);
        textViewTeamB = (TextView) findViewById(R.id.pointsTeamB);
    }

    public void increaseImagePointsTeamA(){
        int points = teamA.calculatePoints();
        Integer pointsImage = imagePointsMap.get(points);
        int imageViewNumber = teamA.getImageView();
        imageViewTeamA = viewPointsMapTeamA.get(imageViewNumber);
        imageViewTeamA.setImageResource(pointsImage);
        textViewTeamA.setText(String.valueOf(teamA.getPoints()));
    }

    public void decreaseImagePointsTeamA(){
        int points = teamA.calculatePoints();
        Integer pointsImage = imagePointsMap.get(points);
        if (points == 5 || points == 10 || points == 15 || points == 20 || points == 25) {
            int imageViewNumber = teamA.getImageView() + 1;
            imageViewTeamA = viewPointsMapTeamA.get(imageViewNumber);
            imageViewTeamA.setImageResource(0);
        }else{
            int imageViewNumber = teamA.getImageView();
            imageViewTeamA = viewPointsMapTeamA.get(imageViewNumber);
            imageViewTeamA.setImageResource(pointsImage);
        }
        textViewTeamA.setText(String.valueOf(teamA.getPoints()));
    }

    public void increaseImagePointsTeamB(){
        int points = teamB.calculatePoints();
        Integer pointsImage = imagePointsMap.get(points);
        int imageViewNumber = teamB.getImageView();
        imageViewTeamB = viewPointsMapTeamB.get(imageViewNumber);
        imageViewTeamB.setImageResource(pointsImage);
        textViewTeamB.setText(String.valueOf(teamB.getPoints()));
    }

    public void decreaseImagePointsTeamB(){
        int points = teamB.calculatePoints();
        Integer pointsImage = imagePointsMap.get(points);
        if (points == 5 || points == 10 || points == 15 || points == 20 || points == 25) {
            int imageViewNumber = teamB.getImageView() + 1;
            imageViewTeamB = viewPointsMapTeamB.get(imageViewNumber);
            imageViewTeamB.setImageResource(0);
        }else{
            int imageViewNumber = teamB.getImageView();
            imageViewTeamB = viewPointsMapTeamB.get(imageViewNumber);
            imageViewTeamB.setImageResource(pointsImage);
        }
        textViewTeamB.setText(String.valueOf(teamB.getPoints()));
    }

    public void increasePointsTeamA(View view){
        teamA.increasePoints();
        increaseImagePointsTeamA();
    }

    public void increasePointsTeamB(View view){
        teamB.increasePoints();
        increaseImagePointsTeamB();
    }

    public void decreasePointsTeamA(View view){
        teamA.decreasePoints();
        decreaseImagePointsTeamA();
    }
    public void decreasePointsTeamB(View view){
        teamB.decreasePoints();
        decreaseImagePointsTeamB();
    }
}
