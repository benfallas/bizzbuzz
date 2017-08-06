package firstandroid.com.bizzbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameOverActivity extends AppCompatActivity {
    @BindView(R.id.home_button) Button home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.home_button)
    public void backToHome() { onBackPressed(); }
}
