package com.diuly.letscode.exercicioparte2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.diuly.letscode.exercicioparte2.adapter.TrooperAdapter;
import com.diuly.letscode.exercicioparte2.model.Trooper;
import com.diuly.letscode.exercicioparte2.repository.TrooperRepository;
import com.diuly.letscode.exercicioparte2.util.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TrooperAdapter.OnItemClickListener, View.OnLongClickListener {

    private RecyclerView rvTroopers;
    private ArrayList<Trooper> troopers;
    private TrooperAdapter trooperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTroopers = findViewById(R.id.rv_trooper);
        populateRecyclerView();
    }

    private void populateRecyclerView() {
        troopers = TrooperRepository.tryGettingFromSharedPreferences(getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));
        rvTroopers.setLayoutManager(new LinearLayoutManager((this)));

        trooperAdapter = new TrooperAdapter(troopers, this, this);
        rvTroopers.setAdapter(trooperAdapter);
    }

    @Override
    public void onItemClick(Trooper trooper) {
        Intent intent = new Intent(this, TrooperDetailActivity.class);
        intent.putExtra(Constants.TROOPER_EXTRA, trooper);
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(final View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.confirm_exclude_trooper)
                .setTitle(R.string.title_exclude_trooper)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int position = rvTroopers.getChildLayoutPosition(v);
                        troopers.remove(position);
                        trooperAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, R.string.trooper_excluido, Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(getString(R.string.nao), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        TrooperRepository.saveToSharedPreferences(troopers, getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));
    }

}
