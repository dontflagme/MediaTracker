package co.miniforge.corey.mediatracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import co.miniforge.corey.mediatracker.media_recycler.MediaViewHolder;
import co.miniforge.corey.mediatracker.model.MediaItem;

/**
 * This activity will display the contents of a media item and allow the user to update the contents
 * of the item. When the user clicks the save button, the activity should create an intent that goes
 * back to MyListActivity and puts the MediaItem into the intent (If you are stuck on that, read through
 * the code in MyListActivity)
 */
public class MediaItemDetailActivity extends AppCompatActivity {

    EditText title;
    EditText desc;
    EditText url;
    JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_item_detail);

        TextView deadpoolQuotes = (TextView) findViewById(R.id.deadpoolQuotes);
        ImageView deadpool = (ImageView) findViewById(R.id.deadpool);
        title = (EditText) findViewById(R.id.editTitle);
        desc = (EditText) findViewById(R.id.editDesc);
        url = (EditText) findViewById(R.id.editUrl);
        Button save = (Button) findViewById(R.id.save);

        Intent intent = getIntent();

        try {
            jsonObject = new JSONObject(getIntent().getStringExtra(MyListActivity.mediaExtra));
            title.setText(jsonObject.getString("title"));
            desc.setText(jsonObject.getString("description"));
            url.setText(jsonObject.getString("url"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaItem mediaItem = new MediaItem(jsonObject);
                mediaItem.title = title.getText().toString();
                mediaItem.description = desc.getText().toString();
                mediaItem.url = url.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MyListActivity.class);
                intent.putExtra(MyListActivity.mediaExtra,  mediaItem.toJson().toString());
                startActivity(intent);
            }
        });

        //edit texts
        //save button
        //intent
    }
}
