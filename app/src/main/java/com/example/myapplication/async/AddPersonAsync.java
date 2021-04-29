package com.example.myapplication.async;

import android.os.AsyncTask;

import com.example.myapplication.database.LabDataBase;
import com.example.myapplication.entity.Person;

public class AddPersonAsync extends AsyncTask<Person, Void, Void> {
    private LabDataBase dataBase;


    public AddPersonAsync(LabDataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    protected Void doInBackground(Person... people) {
        return null;
    }
}

