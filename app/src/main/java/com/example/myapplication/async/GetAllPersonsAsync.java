package com.example.myapplication.async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.PersonActivity;
import com.example.myapplication.database.LabDataBase;
import com.example.myapplication.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class GetAllPersonsAsync extends AsyncTask<Void, Void, List<Person>>{
    private ArrayList personArrayList;
    private LabDataBase dataBase;
    private Context context;

    public GetAllPersonsAsync(LabDataBase labDataBase, Context context) {
        this.dataBase = labDataBase;
        this.context = context;
    }

    @Override
    protected List<Person> doInBackground(Void... voids) {
        ArrayList<String> personNames = new ArrayList<>();
        personArrayList = (ArrayList)dataBase.personDao().getAllPersons();
        for (int i = 0; i < personArrayList.size(); ){
            personNames.add(personArrayList.get(i).getName());
        }

        Intent i = new Intent(context, PersonActivity.class);
        i.putExtra("Persons", personNames);
        return null;
    }
}
