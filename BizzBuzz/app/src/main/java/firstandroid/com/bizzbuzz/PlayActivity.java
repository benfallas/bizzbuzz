package firstandroid.com.bizzbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.Random;


public class PlayActivity extends AppCompatActivity {

    @BindView(R.id.number_display) TextView number_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        Random rand = new Random();
        int pickedNumber = rand.nextInt(100) + 1;
        number_display.setText(String.valueOf(pickedNumber));
    }


}
