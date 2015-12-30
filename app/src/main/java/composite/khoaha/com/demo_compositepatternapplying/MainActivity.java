package composite.khoaha.com.demo_compositepatternapplying;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container);

        Item itemRoot = new ItemParent("", 0, R.dimen.item_parent);
        Item itemDownload = new ItemParent("Download", R.drawable.circle_blue, R.dimen.item_parent);
        Item itemMusic = new ItemParent("Music", R.drawable.circle_gray, R.dimen.item_child);
        Item itemVideo = new ItemParent("Video", R.drawable.circle_gray, R.dimen.item_child);
        Item itemDocument = new ItemParent("Document", R.drawable.circle_blue, R.dimen.item_parent);
        Item itemWord = new ItemParent("Word", R.drawable.circle_gray, R.dimen.item_child);

        itemDownload.addChild(itemMusic);
        itemDownload.addChild(itemVideo);

        itemDocument.addChild(itemWord);

        itemRoot.addChild(itemDownload);
        itemRoot.addChild(itemDocument);

        itemRoot.setRootView(container);
        itemRoot.generateView();


    }
}
