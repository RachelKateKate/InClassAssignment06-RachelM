package rachelmiller.inclassassignment06_rachelm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private CheckBox hasWater;
    private EditText nameLine;
    private EditText distanceLine;
    private EditText messageLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        hasWater = (CheckBox) findViewById(R.id.canWeLive);
        nameLine = (EditText) findViewById(R.id.planetName);
        distanceLine = (EditText) findViewById(R.id.planetDistance);
        messageLine = (EditText) findViewById(R.id.messageField);

        setTitle("Planet List");
    }

    public void submit(View view) {

        String name = nameLine.getText().toString();
        String distance = distanceLine.getText().toString();
        int distancenum = Integer.parseInt(distance);
        boolean canWeLive = hasWater.isChecked();
        String comments = messageLine.getText().toString();

        Planet planet = new Planet(name, distancenum, canWeLive, comments);

        Intent msIntent = new Intent(this, MainActivity.class);

        msIntent.putExtra(Keys.PLANET, planet);
        setResult(RESULT_OK, msIntent);
        finish();

    }


}


