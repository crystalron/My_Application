package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import android.
import java.util.prefs.*;

public class MainActivity extends AppCompatActivity {
    EditText username, password, repassword;
    Button singup, singin;
    DBHelper DB;
    String ConnectionResult = "";



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        singup = (Button) findViewById(R.id.regbutton);
        singin = (Button) findViewById(R.id.logbutton1);
        DB = new DBHelper(this);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean checkUser = DB.checkUsername(user);
                        if (checkUser == false) {
                            Boolean insert = DB.insertUsersData(user, pass);
                            if (insert == true) {
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                intent.putExtra("string", user);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "User already exists! Please, sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    /*public void main(View v) {
        TextView tx = (TextView) findViewById(R.id.textViewCool);
        try {
            String record = "";
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String password = "root";
            String username = "root";
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
            if (connection != null) {
                String query1 = "select * from users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query1);
            while(resultSet.next()) {
                tx.setText(resultSet.getString(1));
                }
            }
        }
        catch(Exception e)
        {
            Log.e("Error: ", e.getMessage());
        }

    }*/

    }
