package com.learning.craig.androidnumbershapesapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    class Number {
        int number;

        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }

            if(triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void testNumber(View view) {
        String message = "";
        EditText userNumber = (EditText) findViewById(R.id.userNumber);

        if (userNumber.getText().toString().isEmpty()) {
            message = "Please enter a number";
        } else {
            Number number = new Number();
            number.number = Integer.parseInt(userNumber.getText().toString());

            if (number.isSquare()) {
                if (number.isTriangular()) {
                    message = number.number + " is both triangular and square!";
                } else {
                    message = number.number + " is square, but not triangular.";
                }
            } else {
                if (number.isTriangular()) {
                    message = number.number + " is triangular but not square.";
                } else {
                    message = number.number + " is neither square nor triangular.";
                }
            }
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}