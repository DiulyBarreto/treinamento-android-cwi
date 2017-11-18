package br.com.cwi.aula2.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.cwi.aula2.R;


public class LineHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public ImageView imageView;

    public LineHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.name_text_view);
        imageView = itemView.findViewById(R.id.image_menu_view);
    }
}
