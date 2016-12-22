package nyc.c4q.dereksantos.exam_12_21.android;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.dereksantos.exam_12_21.backend.Animal;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    List<Animal> animalList;

    public AnimalAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimalViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.bind(animal);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}
