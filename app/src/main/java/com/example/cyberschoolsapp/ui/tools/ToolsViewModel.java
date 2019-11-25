package com.example.cyberschoolsapp.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is where you will see your subjects and the homework that needs to be done");
    }

    public LiveData<String> getText() {
        return mText;
    }
}