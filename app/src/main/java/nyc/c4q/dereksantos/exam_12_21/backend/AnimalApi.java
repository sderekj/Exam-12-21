package nyc.c4q.dereksantos.exam_12_21.backend;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimalApi {

    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<AnimalResponse> getAnimalResponse();
}
