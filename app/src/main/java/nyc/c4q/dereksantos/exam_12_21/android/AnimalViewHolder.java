package nyc.c4q.dereksantos.exam_12_21.android;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.dereksantos.exam_12_21.R;
import nyc.c4q.dereksantos.exam_12_21.backend.Animal;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private final View mView;
    private final TextView nameTextView;

    public AnimalViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        nameTextView = (TextView) mView.findViewById(R.id.animal_name);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.animal_viewholder, parent, false);
    }


    public void bind(final Animal animal) {
        nameTextView.setText(animal.getName());

        // Sets default TextColor for null cases, if any
        String animalTextColor = animal.getTextColor();
        if (animalTextColor == null) {
            nameTextView.setTextColor(Color.parseColor("black"));
        }
        nameTextView.setTextColor(Color.parseColor(animal.getTextColor()));


        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View fragmentView = mView.getRootView();
                fragmentView.setBackgroundColor(Color.parseColor(animal.getBackground()));
            }
        });
    }
}
