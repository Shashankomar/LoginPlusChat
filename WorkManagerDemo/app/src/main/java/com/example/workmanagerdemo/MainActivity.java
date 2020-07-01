package com.example.workmanagerdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE_STATUS = "message_status";
    private WorkManager workManager;
    private OneTimeWorkRequest oneTimeWorkRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workManager = WorkManager.getInstance();

        oneTimeWorkRequest = new OneTimeWorkRequest.Builder(NotificationWorker.class).build();

        Button button = findViewById(R.id.button);
        final TextView tv = findViewById(R.id.textView);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               workManager.enqueue(oneTimeWorkRequest);
           }
       });
 workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.getId()).observe(this, new Observer<WorkInfo>() {
     @Override
     public void onChanged(WorkInfo workInfo) {
         if (workInfo!=null){
             WorkInfo.State state = workInfo.getState();
             tv.append(state.toString()+"/n");
         }
     }
 });
    }
}
