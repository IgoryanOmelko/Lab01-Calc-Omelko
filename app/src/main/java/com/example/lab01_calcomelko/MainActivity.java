package com.example.lab01_calcomelko;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { //Выполнил Омелько Игорь группа 393

    EditText etA,etB;
    TextView tvRV;
    Toast toast;
    CheckBox check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etA=findViewById(R.id.editTextA);
        etB=findViewById(R.id.editTextB);
        tvRV=findViewById(R.id.textViewResultView);
        check=findViewById(R.id.checkBox);
    }
    public void AddSubDivMulPow (View v)
    {
        if (!InputCheckFloat(etA.getText().toString())||!InputCheckFloat(etB.getText().toString()))
        {
            toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
            toast.show();
            tvRV.setText("");
            return;
        }
        switch (v.getId())
        {
            case R.id.buttonAdd:tvRV.setText(String.valueOf(Float.parseFloat(etA.getText().toString())+Float.parseFloat(etB.getText().toString())));break;
            case R.id.buttonMultiply:tvRV.setText(String.valueOf(Float.parseFloat(etA.getText().toString())*Float.parseFloat(etB.getText().toString())));break;
            case R.id.buttonSubtract:tvRV.setText(String.valueOf(Float.parseFloat(etA.getText().toString())-Float.parseFloat(etB.getText().toString())));break;
            case R.id.buttonDivide:
                                if (Float.parseFloat(etB.getText().toString())==0)
                                {
                                    toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
                                    toast.show();
                                    tvRV.setText("");
                                    return;
                                }
                                tvRV.setText(String.valueOf(Float.parseFloat(etA.getText().toString())/Float.parseFloat(etB.getText().toString())));break;
            case R.id.buttonPower:tvRV.setText(String.valueOf(Math.pow(Float.parseFloat(etA.getText().toString()),Float.parseFloat(etB.getText().toString()))));break;
        }
    }
    public void SinCos(View v)
    {
        if (!InputCheckFloat(etA.getText().toString()))
        {
            toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
            toast.show();
            tvRV.setText("");
            return;
        }
        switch (v.getId())
        {
            case R.id.buttonSinA:if(check.isChecked())
                                {
                                    tvRV.setText(String.valueOf(Math.sin(Math.toRadians((Float.parseFloat(etA.getText().toString()))))));
                                }
                                else
                                {
                                    tvRV.setText(String.valueOf(Math.sin((Float.parseFloat(etA.getText().toString())))));
                                }break;
            case R.id.buttonCosA:if(check.isChecked())
                                {
                                    tvRV.setText(String.valueOf(Math.cos(Math.toRadians((Float.parseFloat(etA.getText().toString()))))));
                                }
                                else
                                {
                                    tvRV.setText(String.valueOf(Math.cos((Float.parseFloat(etA.getText().toString())))));
                                }break;
        }
    }
    public void Sqrt (View v)
    {
        if (!InputCheckFloat(etA.getText().toString()))
        {
            toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
            toast.show();
            tvRV.setText("");
            return;
        }
        if (Float.parseFloat(etA.getText().toString())<0)
        {
            toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
            toast.show();
            tvRV.setText("");
            return;
        }
        tvRV.setText(String.valueOf(Math.sqrt(Float.parseFloat(etA.getText().toString()))));
    }
    public void Ctg(View v)
    {
        if (!InputCheckFloat(etA.getText().toString()))
        {
            toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
            toast.show();
            tvRV.setText("");
            return;
        }
        if(check.isChecked())
        {
            if ((Float.parseFloat(etA.getText().toString()))==0||(Float.parseFloat(etA.getText().toString()))%180==0)
            {
                toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
                toast.show();
                tvRV.setText("");
                return;
            }
            tvRV.setText(String.valueOf(1/Math.tan(Math.toRadians((Float.parseFloat(etA.getText().toString()))))));
        }
        else
        {
            if ((Float.parseFloat(etA.getText().toString()))%Math.PI==0||(Float.parseFloat(etA.getText().toString()))==0)
            {
                toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
                toast.show();
                tvRV.setText("");
                return;
            }
            tvRV.setText(String.valueOf(1/Math.tan((Float.parseFloat(etA.getText().toString())))));
        }
    }
    public void Tg(View v)
    {
        if (!InputCheckFloat(etA.getText().toString()))
        {
            toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
            toast.show();
            tvRV.setText("");
            return;
        }
        if(check.isChecked())
        {//a==90||(((a%90)==0)&&(a/90)%2!=0)
            if ((Float.parseFloat(etA.getText().toString()))==90||((((Float.parseFloat(etA.getText().toString()))%90)==0)&&(((Float.parseFloat(etA.getText().toString()))/90)%2!=0)))
            {
                toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
                toast.show();
                tvRV.setText("");
                return;
            }
            tvRV.setText(String.valueOf(Math.tan(Math.toRadians((Float.parseFloat(etA.getText().toString()))))));
        }
        else
        {
            if ((Float.parseFloat(etA.getText().toString()))==Math.PI/2||(((Float.parseFloat(etA.getText().toString()))%Math.PI==0)&&(((Float.parseFloat(etA.getText().toString()))/Math.PI)%2!=0)))
            {
                toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.textError), Toast.LENGTH_SHORT);
                toast.show();
                tvRV.setText("");
                return;
            }
            tvRV.setText(String.valueOf(Math.tan((Float.parseFloat(etA.getText().toString())))));
        }
    }
    public boolean InputCheckFloat(String value)
    {
        try
        {
            Float.parseFloat(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}