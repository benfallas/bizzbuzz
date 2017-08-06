package firstandroid.com.bizzbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.util.Random;

import static android.R.attr.onClick;


public class PlayActivity extends AppCompatActivity {

    @BindView(R.id.number_display) TextView number_display;
    @BindView(R.id.buzz_button) Button buzz_button;
    @BindView(R.id.bizz_button) Button bizz_button;
    @BindView(R.id.bizz_buzz_button) Button bizz_buzz_botton;
    @BindView(R.id.next_button) Button next_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        generateRandomNum();
    }


    public void generateRandomNum(){
        Random rand = new Random();
        int pickedNumber = rand.nextInt(100) + 1;
        number_display.setText(String.valueOf(pickedNumber));
    }


    @OnClick(R.id.buzz_button)
    public void onBuzzButtonClicked(){
        if(checkBuzz()) {
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            generateRandomNum();
        } else {
            Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
            launchGameOver();
        }
    }

    @OnClick(R.id.bizz_button)
    public void onBizzButtonClicked(){
        if(checkBizz()) {
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            generateRandomNum();
        } else {
            Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
            launchGameOver();
        }
    }
    @OnClick(R.id.bizz_buzz_button)
    public void onBizzBuzzButtonClicked(){
        if(checkBizzBuzz()) {
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            generateRandomNum();
        } else {
            Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
            launchGameOver();

        }
    }
    @OnClick(R.id.next_button)
    public void onNextButtonClicked(){
        if(checkNext()) {
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            generateRandomNum();
        } else {
            Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
            launchGameOver();
        }
    }

    private void launchGameOver() {
        Intent intent = new Intent(this, GameOverActivity.class);
        startActivity(intent);
        finish();
    }


    private boolean checkBuzz() {
        if (isDisibleBySeven()) {
            return true;
        } else if(isContainSeven()) {
            return true;
        }
        return false;
    }

    private boolean checkBizz() {
        if (isDisibleByFive()) {
            return true;
        } else if (isContainFive()) {
            return true;
        }
        return false;
    }
    private boolean checkBizzBuzz() {
        if (isDisibleBySeven() && isDisibleByFive()) {
            return true;
        } else if (isContainSeven() && isDisibleByFive()){
            return true;
        }
        return false;
    }
    private boolean checkNext() {
        if (!checkBuzz() && !checkBizz() &&!checkBizzBuzz()) {
            return true;
        }
        return false;
    }

    private boolean isDisibleBySeven() {
        if (Integer.parseInt(number_display.getText().toString()) % 7 == 0){
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
