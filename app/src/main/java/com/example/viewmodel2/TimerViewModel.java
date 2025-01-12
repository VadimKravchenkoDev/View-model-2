package com.example.viewmodel2;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimerViewModel extends ViewModel {
    private final Context context;
    private CountDownTimer timer;
    private final MutableLiveData<String> liveData = new MutableLiveData<>();

    public TimerViewModel(Context context) {
        this.context = context.getApplicationContext();
    }

    public LiveData<String> getLiveData(){
        return liveData;
    }

    public void startTimer(){
        if(liveData.getValue() == null){
            timer = new CountDownTimer(10000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    liveData.setValue(millisUntilFinished/1000+"");
                }

                @Override
                public void onFinish() {
                    Toast.makeText(context,"Time's up!!!",Toast.LENGTH_LONG).show();
                }
            };
            timer.start();
        }
    }
}
