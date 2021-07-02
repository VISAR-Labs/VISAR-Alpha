package com.kumar.dipanshu.visar;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OptionActivity extends AppCompatActivity implements View.OnClickListener {

    Button horizontalReside, verticalReside, cornerReside;
    Intent intent;
    FloatingActionButton gitHubFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        horizontalReside = (Button) findViewById(R.id.horizontalResideButton);
        verticalReside = (Button) findViewById(R.id.verticalResideButton);
        cornerReside = (Button) findViewById(R.id.cornerResideButton);

        horizontalReside.setOnClickListener(this);
        verticalReside.setOnClickListener(this);
        cornerReside.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.horizontalResideButton:
                intent = new Intent(OptionActivity.this, MainActivity.class);
                intent.putExtra(Constant.OPTION, Constant.HORIZONTAL_RESIDE);
                startActivity(intent);
                break;
            case R.id.verticalResideButton:
                intent = new Intent(OptionActivity.this, MainActivity.class);
                intent.putExtra(Constant.OPTION, Constant.VERTICAL_RESIDE);
                startActivity(intent);
                break;
            case R.id.cornerResideButton:
                intent = new Intent(OptionActivity.this, MainActivity.class);
                intent.putExtra(Constant.OPTION, Constant.CORNER_RESIDE);
                startActivity(intent);
                break;
        }
    }

}
