package com.diuly.letscode.exercicioparte2;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.diuly.letscode.exercicioparte2.model.Trooper;
import com.diuly.letscode.exercicioparte2.util.Constants;
import com.diuly.letscode.exercicioparte2.util.ResourceUtil;
import com.squareup.picasso.Picasso;

import java.net.URI;

/**
 * Created by letscode on 18/11/2017.
 */

public class TrooperDetailActivity extends AppCompatActivity {
    private TextView tvTrooperDescription, tvTrooperName;
    private ImageView imvTrooperImage, imvTrooperAffiliation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.description_item_trooper);
        initializeComponents();
        Trooper trooper = (Trooper) getIntent().getSerializableExtra(Constants.TROOPER_EXTRA);
        setUpDetails(trooper);
    }

    private void setUpDetails(Trooper trooper) {
        tvTrooperDescription.setText(trooper.getDescription());
        imvTrooperAffiliation.setImageResource(ResourceUtil.getResourceBasedOnAffiliation(trooper.getAffiliation()));
        tvTrooperName.setText(trooper.getName());

        Picasso.with(this)
                .load(trooper.getImageUrl())
                .into(imvTrooperImage);
    }

    private void initializeComponents() {
        tvTrooperDescription = findViewById(R.id.description_trooper);
        imvTrooperAffiliation = findViewById(R.id.affiliation_description);
        imvTrooperImage = findViewById(R.id.image_description);
        tvTrooperName = findViewById(R.id.description_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trooper_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.start_item:
                Toast.makeText(this, R.string.favoritar_trooper, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
