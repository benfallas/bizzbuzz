package firstandroid.com.bizzbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.rules_button) Button rulesButton;
    @BindView(R.id.play_button) Button play_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rules_button)
    protected void onRulesButtonClicked(){
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.play_button)
    public void onPlayButtonClicked() {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);


    }
}
