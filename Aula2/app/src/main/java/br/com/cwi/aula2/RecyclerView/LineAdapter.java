package br.com.cwi.aula2.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.cwi.aula2.R;


public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private ArrayList<Menu> listMenu;

    public LineAdapter(ArrayList nomes) {
        this.listMenu = nomes;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.textView.setText(listMenu.get(position).getNome());
        holder.imageView.setImageResource(listMenu.get(position).getIdImage());
    }

    @Override
    public int getItemCount() {
        return listMenu.size();
    }
}
