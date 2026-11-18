package com.example.assignmentone;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        showClickMessage(R.string.facilities);
    }

    public void onEventsClick(View view) {
        showClickMessage(R.string.events);
    }

    public void onClubsClick(View view) {
        showClickMessage(R.string.clubs);
    }

    public void onSupportClick(View view) {
        showClickMessage(R.string.support);
    }

    private void showClickMessage(int labelResource) {
        String label = getString(labelResource);
        String message = getString(R.string.topic_clicked, label);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}