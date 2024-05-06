package it.thomas.weightcalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import it.thomas.weightcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListeners();
    }

    private void initListeners() {
        binding.rgWeight.setOnCheckedChangeListener(this);
        binding.btConvert.setOnClickListener(v -> {
            String input = binding.etInput.getText().toString();
            double weight = Double.parseDouble(input);
            if(binding.rbKg2Lb.isChecked()) {
                double kg2Lb = weight * 2.20462;
                binding.etResult.setText(kg2Lb + "lb");
                binding.tvThank.setText("Thanks For Using My App");
            } else {
                double lb2Kg = weight * 0.454;
                binding.etResult.setText(lb2Kg + "kg");
                binding.tvThank.setText("Thanks For Using My App");
            }
        });

        binding.btClear.setOnClickListener(v -> {
            binding.etInput.getText().clear();
            binding.etResult.getText().clear();
        });
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.rbKg2Lb) {
            //Kg To Lb
            Log.d("Myat" , "Convert Kg to Lb");
        } else {
            Log.d("Myat", "Convert Lb to Kg");
        }
    }
}