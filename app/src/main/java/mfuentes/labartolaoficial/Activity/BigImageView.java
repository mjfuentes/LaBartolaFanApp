package mfuentes.labartolaoficial.Activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import mfuentes.labartolaoficial.R;

public class BigImageView extends Activity {

    String currentImage;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        this.currentImage = this.getIntent().getStringExtra("currentImage");
        this.imageName = this.getIntent().getStringExtra("imageName");
        final ImageView currentImageView = (ImageView) this.findViewById(R.id.currentImage);
        final ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        final TextView name = (TextView) findViewById(R.id.name);
        ImageLoader.getInstance().loadImage(currentImage, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                currentImageView.setImageBitmap(loadedImage);
                name.setText(imageName);
                bar.setVisibility(View.INVISIBLE);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.image_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}