package test.dagger.com.daggertesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject UserService userService;
    Button login;
    Button logout;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getUserComponent().inject(this);

        login = (Button) this.findViewById(R.id.login_button);
        login.setOnClickListener(this);
        logout = (Button) this.findViewById(R.id.logout_button);
        logout.setOnClickListener(this);
        status = (TextView) this.findViewById(R.id.status_text);
    }

    @Override
    public void onClick(View v) {
        if(v == login)
            status.setText(userService.login());
        else
            status.setText(userService.logout());
    }
}
