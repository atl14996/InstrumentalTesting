package com.example.week6day1homework.model.dagger.modules;


import com.example.week6day1homework.model.datasource.remote.Item;

import dagger.Module;
import dagger.Provides;

@Module
public class InfoModule {

    @Provides

    public String provideAuthor() {

        Item item = new Item();
        return item.getAuthor();

    }

    @Provides

    public String provideDescription(){

        Item item = new Item();
        return item.getDescription();

    }
}
