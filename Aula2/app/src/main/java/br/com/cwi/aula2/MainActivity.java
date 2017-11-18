package br.com.cwi.aula2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import br.com.cwi.aula2.RecyclerView.LineAdapter;
import br.com.cwi.aula2.RecyclerView.Menu;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Menu> listMenu = new ArrayList<Menu>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        populateList();
        setUpRecylerView();
    }

    private void setUpRecylerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        LineAdapter adapter = new LineAdapter(this.listMenu);
        recyclerView.setAdapter(adapter);
    }

    private void populateList() {
        listMenu.add(new Menu("People", R.drawable.man_user));
        listMenu.add(new Menu("Starship", R.drawable.starship));
        listMenu.add(new Menu("Film", R.drawable.movie));
        listMenu.add(new Menu("Planets", R.drawable.earth_globe));
    }
}
















