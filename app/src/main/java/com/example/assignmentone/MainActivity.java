package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TOPIC_INDEX = "topic_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
                (view, windowInsets) -> {
                    Insets bars = windowInsets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                                    | WindowInsetsCompat.Type.displayCutout());
                    view.setPadding(bars.left, bars.top, bars.right, bars.bottom);
                    return windowInsets;
                });
    }

    public void onFacilitiesClick(View view) {
        openTopic(0, R.string.facilities);
    }

    public void onEventsClick(View view) {
        openTopic(1, R.string.events);
    }

    public void onClubsClick(View view) {
        openTopic(2, R.string.clubs);
    }

    public void onSupportClick(View view) {
        openTopic(3, R.string.support);
    }

    private void openTopic(int topicIndex, int labelResource) {
        String label = getString(labelResource);
        String message = getString(R.string.topic_clicked, label);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, topicIndex);
        startActivity(intent);
    }
}