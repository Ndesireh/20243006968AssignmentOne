package com.example.assignmentone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.detail_root), (view, windowInsets) -> {
                    Insets bars = windowInsets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                                    | WindowInsetsCompat.Type.displayCutout());
                    view.setPadding(bars.left, bars.top, bars.right, bars.bottom);
                    return windowInsets;
                });

        // The supplied arrays share the order Facilities, Events, Clubs, Support.
        int index = getIntent().getIntExtra(MainActivity.EXTRA_TOPIC_INDEX, 0);

        Resources resources = getResources();
        String[] titles = resources.getStringArray(R.array.string_array_titles);
        String[] contents = resources.getStringArray(R.array.string_array_content);
        String[] imageNames = resources.getStringArray(R.array.string_array_images);
        String[] labels = resources.getStringArray(R.array.topic_labels);

// The XML provides drawable names as text. Resolve the selected name to an ID.
        String drawablePackage = resources.getResourcePackageName(
                R.drawable.img_btn_facilities);
        int drawableId = resources.getIdentifier(
                imageNames[index].trim(), "drawable", drawablePackage);

        ImageView image = findViewById(R.id.detail_image);
        TextView category = findViewById(R.id.detail_category);
        TextView title = findViewById(R.id.detail_title);
        TextView content = findViewById(R.id.detail_content);

        image.setImageResource(drawableId);
        category.setText(labels[index]);
        title.setText(titles[index].trim());
        content.setText(contents[index].trim());
    }
}