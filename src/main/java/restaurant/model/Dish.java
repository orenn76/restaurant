package restaurant.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Soup.class)
public interface Dish {

    int getPreparationTime();

    void setPreparationTime(int preparationTime);
}