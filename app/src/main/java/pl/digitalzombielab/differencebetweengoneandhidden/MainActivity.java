package pl.digitalzombielab.differencebetweengoneandhidden;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3;
    private Spinner spinner1, spinner2, spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.possibilities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
    }

    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.applyBtn:
                applyChanges();
                break;
            case R.id.button1:
                Toast.makeText(getApplicationContext(), "Button 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(getApplicationContext(), "Button 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Toast.makeText(getApplicationContext(), "Button 3", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void applyChanges() {
        String selected1 = (String) spinner1.getSelectedItem();
        String selected2 = (String) spinner2.getSelectedItem();
        String selected3 = (String) spinner3.getSelectedItem();
        applyChangesToButton(button1, selected1);
        applyChangesToButton(button2, selected2);
        applyChangesToButton(button3, selected3);
    }

    private void applyChangesToButton(Button button, String selected) {
        button.setEnabled(enabledIsSelected(selected));
        //noinspection ResourceType
        button.setVisibility(visibilityIsSelected(selected));
        button.setAlpha(alphaIsSelected(selected));
    }

    private boolean enabledIsSelected(String selected) {
        return selected.contains("ena");
    }

    private int visibilityIsSelected(String selected) {
        if (selected.contains("vis"))
            return View.VISIBLE;
        else if (selected.contains("inv"))
            return View.INVISIBLE;
        else
            return View.GONE;
    }

    private int alphaIsSelected(String selected) {
        if (selected.contains("255"))
            return 255;
        else
            return 0;
    }
}
