package nyc.c4q.dereksantos.exam_12_21.backend;

import java.util.List;

public class AnimalResponse {

    private boolean success;
    List<Animal> animals;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
