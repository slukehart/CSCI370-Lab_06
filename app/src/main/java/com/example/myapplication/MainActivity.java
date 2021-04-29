package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.async.AddPersonAsync;
import com.example.myapplication.async.GetAllPersonsAsync;
import com.example.myapplication.database.LabDataBase;
import com.example.myapplication.entity.Person;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity<labDB> extends AppCompatActivity {
    public static ArrayList<Person> person;

    private Text editText;
    private Button addPersonButton;
    private Button getAllPersonsButton;
    labDB = Room.databaseBuilder(this, LabDataBase.LabDatabase .class, DATABASE_NAME)
            .build();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);
        addPersonButton = findViewById(R.id.add_person_button);
        getAllPersonsButton = findViewById(R.id.get_all_persons_button);
        labDB = Room.databaseBuilder(this, LabDataBase.class, DATABASE_NAME)
                .build();

        addPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AddPersonAsync addPersonAsync = new AddPersonAsync(labDB);
                Person person = new Person();
                person.setName(editText.getText().toString());
                addPersonAsync.execute(person);
                editText.setText("");
            }
        });

        getAllPersonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final GetAllPersonsAsync getAllPersonsAsync = new GetAllPersonsAsync(labDB, getApplicationContext());
                getAllPersonsAsync.execute();
            }
        });





    }
}