package com.example.week6day1homework.model.dagger;

import com.example.week6day1homework.model.dagger.modules.InfoModule;
import com.example.week6day1homework.view.adapter.PictureRecyclerViewAdapter;

import dagger.Component;

@Component (modules = InfoModule.class)
public interface Components {

void inject(PictureRecyclerViewAdapter pictureRecyclerViewAdapter);

}
