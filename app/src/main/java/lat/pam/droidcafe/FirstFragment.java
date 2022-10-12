package lat.pam.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class FirstFragment extends Fragment {


    int donutCounter = 0;
    int iceCreamCounter = 0;
    int froyoCounter = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.donut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donutCounter++;
                displayToast(getString(R.string.donut_order_message) + " " + donutCounter + "x");
            }
        });

        view.findViewById(R.id.ice_cream).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iceCreamCounter++;
                displayToast(getString(R.string.ice_cream_order_message) + " " + iceCreamCounter + "x");
            }
        });

        view.findViewById(R.id.froyo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                froyoCounter++;
                displayToast(getString(R.string.froyo_order_message) + " " + froyoCounter + "x");
            }
        });



        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), OrderActivity.class);
                if (donutCounter == 0 && iceCreamCounter == 0 && froyoCounter == 0) {
                    displayToast(getString(R.string.no_order_message));
                } else {
                    intent.putExtra("donut", donutCounter);
                    intent.putExtra("iceCream", iceCreamCounter);
                    intent.putExtra("froyo", froyoCounter);
                    startActivity(intent);
                }

            }
        });

    }

    public void displayToast(String message) {
        Toast.makeText(getActivity(), message,
                Toast.LENGTH_SHORT).show();
    }

    public interface OnDataPass {
        public void onDataPass(int donutCounter, int iceCreamCounter, int froyoCounter);
    }

    public void passData(int donutCounter, int iceCreamCounter, int froyoCounter) {
        this.donutCounter = donutCounter;
        this.iceCreamCounter = iceCreamCounter;
        this.froyoCounter = froyoCounter;
    }



}
