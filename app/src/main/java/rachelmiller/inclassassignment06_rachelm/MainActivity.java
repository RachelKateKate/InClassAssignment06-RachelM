package rachelmiller.inclassassignment06_rachelm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView displayText;
    String textAlreadyThere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Planet List");

        displayText = (TextView) findViewById(R.id.display_text);
        textAlreadyThere = displayText.getText().toString();
    }

    public void addPlanet(View view) {
        Intent msIntent = new Intent(this, SecondActivity.class);
        startActivityForResult(msIntent, Keys.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Keys.REQUEST_CODE & resultCode == RESULT_OK){
            Planet planet = (Planet) data.getSerializableExtra(Keys.PLANET);
            textAlreadyThere += planet.toString();
            displayText.setText(textAlreadyThere);
        }


    }



}