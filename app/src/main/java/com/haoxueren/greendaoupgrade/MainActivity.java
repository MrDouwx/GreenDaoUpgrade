package com.haoxueren.greendaoupgrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 插入一条数据
        // insertPerson();

        DaoSession daoSession = MyApplication.daoSession;
        Person person1 = new Person();
        person1.setName("小红");
        person1.setAge(18);
        daoSession.insert(person1);

        List<Person> personList = daoSession.loadAll(Person.class);
        for (Person person : personList) {
            System.out.println(person.getName() + person.getAge());
        }
    }

    private void insertPerson() {
        DaoSession daoSession = MyApplication.daoSession;
        Person person = new Person();
        person.setName("小明");
        daoSession.insert(person);
    }
}
