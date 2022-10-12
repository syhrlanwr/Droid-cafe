package lat.pam.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] city = { "Jakarta", "Bandung", "Surabaya", "Semarang", "Yogyakarta"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Bundle extras = getIntent().getExtras();
        int donutCounter = extras.getInt("donut");
        int iceCreamCounter = extras.getInt("iceCream");
        int froyoCounter = extras.getInt("froyo");

        TextView donut = findViewById(R.id.donut);
        if (donutCounter > 0) {
            donut.setText(getString(R.string.donut_order) + donutCounter);
        } else {
            donut.setVisibility(View.GONE);
        }

        TextView iceCream = findViewById(R.id.ice_cream);
        if (iceCreamCounter > 0) {
            iceCream.setText(getString(R.string.ice_cream_order) + iceCreamCounter);
        } else {
            iceCream.setVisibility(View.GONE);
        }

        TextView froyo = findViewById(R.id.froyo);
        if (froyoCounter > 0) {
            froyo.setText(getString(R.string.froyo_order) + froyoCounter);
        } else {
            froyo.setVisibility(View.GONE);
        }

        Log.d("OrderActivity", "onCreate: " + donutCounter + iceCreamCounter + froyoCounter);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,city);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // Do nothing.
                break;
        }
    }


    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),city[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
    }