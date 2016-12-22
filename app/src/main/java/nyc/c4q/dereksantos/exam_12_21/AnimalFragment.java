package nyc.c4q.dereksantos.exam_12_21;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.dereksantos.exam_12_21.backend.Animal;
import nyc.c4q.dereksantos.exam_12_21.backend.AnimalApi;
import nyc.c4q.dereksantos.exam_12_21.backend.AnimalResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimalFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private AnimalAdapter animalAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.animal_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchAnimalList();
        return view;
    }

    private void fetchAnimalList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimalApi api = retrofit.create(AnimalApi.class);

        Call<AnimalResponse> call = api.getAnimalResponse();

        call.enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {
                AnimalResponse animalResponse = response.body();
                List<Animal> animalList = animalResponse.getAnimals();

                animalAdapter = new AnimalAdapter(animalList);

                mRecyclerView.setAdapter(animalAdapter);
            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {

            }
        });
    }
}
