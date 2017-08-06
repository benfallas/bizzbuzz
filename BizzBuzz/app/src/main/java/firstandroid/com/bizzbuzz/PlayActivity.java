package firstandroid.com.bizzbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PlayActivity extends AppCompatActivity {

    @BindView(R.id.bizz_button) Button bizz_button;
    @BindView(R.id.bizz_buzz_button) Button bizz_buzz_botton;
    @BindView(R.id.buzz_button) Button buzz_button;
    @BindView(R.id.cool_emoji) ImageView cool_emoji;
    @BindView(R.id.next_button) Button next_button;
    @BindView(R.id.number_display) TextView number_display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        generateRandomNum();
        cool_emoji.setVisibility(View.GONE);
    }


    public void generateRandomNum(){
        Random rand = new Random();
        int pickedNumber = rand.nextInt(100) + 1;
        number_display.setText(String.valueOf(pickedNumber));
    }


    @OnClick(R.id.buzz_button)
    public void onBuzzButtonClicked(){
        if(checkBuzz()) {
            generateRandomNum();
            showEmoji();
        } else { launchGameOver(); }
    }

    @OnClick(R.id.bizz_button)
    public void onBizzButtonClicked(){
        if(checkBizz()) {
            generateRandomNum();
            showEmoji();
        } else { launchGameOver(); }
    }
    @OnClick(R.id.bizz_buzz_button)
    public void onBizzBuzzButtonClicked(){
        if(checkBizzBuzz()) {
            generateRandomNum();
            showEmoji();
        } else { launchGameOver(); }
    }
    @OnClick(R.id.next_button)
    public void onNextButtonClicked(){
        if(checkNext()) {
            generateRandomNum();
            showEmoji();
        } else { launchGameOver(); }
    }
    private void showEmoji() {
        if (!cool_emoji.isShown()) { cool_emoji.setVisibility(View.VISIBLE); }
    }

    private void launchGameOver() {
        Intent intent = new Intent(this, GameOverActivity.class);
        startActivity(intent);
        finish();
    }


    private boolean checkBuzz() {
        if (isDisibleBySeven()) { return true; }
        else if(isContainSeven()) { return true; }
        return false;
    }

    private boolean checkBizz() {
        if (isDisibleByFive()) { return true; }
        else if (isContainFive()) { return true; }
        return false;
    }
    private boolean checkBizzBuzz() {
        if (isDisibleBySeven() && isDisibleByFive()) { return true; }
        else if (isContainSeven() && isDisibleByFive()){ return true; }
        return false;
    }
    private boolean checkNext() {
        if (!checkBuzz() && !checkBizz() &&!checkBizzBuzz()) { return true; }
        return false;
    }

    private boolean isDisibleBySeven() {
        if (Integer.parseInt(number_display.getText().toString()) % 7 == 0) {
            return true;
        }
        return false;
    }

    private boolean isDisibleByFive() {
        if (Integer.parseInt(number_display.getText().toString()) % 5 == 0){
            return true;
        }
        return false;
    }

    private boolean isContainSeven() {
        if (number_display.getText().toString().contains("7")){
            return true;
        }
        return false;
    }

    private boolean isContainFive() {
        if (number_display.getText().toString().contains("5")) {
            return true;
        }
        return false;
    }
}
