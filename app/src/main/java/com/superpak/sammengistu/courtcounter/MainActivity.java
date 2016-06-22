package com.superpak.sammengistu.courtcounter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mLeftScoreTextView;
    private TextView mRightScoreTextView;
    private Button mResetButton;
    private Button mOnePointButton;
    private Button mTwoPointButton;
    private Button mThreePointButton;

    private boolean mIsLeftSelected;

    private View.OnClickListener mScoreTextViewListener =
        new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {

                v.setBackgroundColor(getResources().getColor(R.color.colorSide));

                switch (v.getId()){
                    case R.id.left_side_score_text_view:
                        mIsLeftSelected = true;
                        mRightScoreTextView.setBackgroundColor(Color.WHITE);
                        break;
                    case R.id.right_side_score_text_view:
                        mIsLeftSelected = false;
                        mLeftScoreTextView.setBackgroundColor(Color.WHITE);
                        break;
                }
            }
        };

    private View.OnClickListener mUpdatePointListener =
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button)v;

                switch (clickedButton.getId()) {
                    case R.id.reset_button:
                        upDateScore(0);
                        break;
                    case R.id.one_point_button:
                        upDateScore(1);
                        break;
                    case R.id.two_point_button:
                        upDateScore(2);
                        break;
                    case R.id.three_point_button:
                        upDateScore(3);
                        break;
                }
            }
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        mLeftScoreTextView.setOnClickListener(mScoreTextViewListener);
        mRightScoreTextView.setOnClickListener(mScoreTextViewListener);

        mResetButton.setOnClickListener(mUpdatePointListener);
        mOnePointButton.setOnClickListener(mUpdatePointListener);
        mTwoPointButton.setOnClickListener(mUpdatePointListener);
        mThreePointButton.setOnClickListener(mUpdatePointListener);
    }


    private void upDateScore(int amount){
        if (mIsLeftSelected) {
            if (amount == 0) {
                mLeftScoreTextView.setText("0");
            } else {
                int currentLeftScore = Integer.parseInt(mLeftScoreTextView.getText().toString())
                    + amount;
                mLeftScoreTextView.setText("" + currentLeftScore);
            }
        } else {
            if (amount == 0) {
                mRightScoreTextView.setText("0");
            } else {
                int currentRightScore = Integer.parseInt(mRightScoreTextView.getText().toString())
                    + amount;
                mRightScoreTextView.setText("" + currentRightScore);
            }
        }
    }

    private void initializeViews() {
        mLeftScoreTextView = (TextView) findViewById(R.id.left_side_score_text_view);
        mRightScoreTextView = (TextView) findViewById(R.id.right_side_score_text_view);
        mResetButton = (Button) findViewById(R.id.reset_button);
        mOnePointButton = (Button) findViewById(R.id.one_point_button);
        mTwoPointButton = (Button) findViewById(R.id.two_point_button);
        mThreePointButton = (Button) findViewById(R.id.three_point_button);
    }
}
