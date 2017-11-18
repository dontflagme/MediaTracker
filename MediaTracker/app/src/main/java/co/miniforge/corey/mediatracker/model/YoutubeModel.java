package co.miniforge.corey.mediatracker.model;

import org.json.JSONObject;

/**
 * Created by KevinNguyen on 11/18/2017.
 */

public class YoutubeModel extends MediaItem {

    public int clipLength;
    public String title;

    public YoutubeModel(JSONObject jsonObject) {
        super(jsonObject);
    }
}
