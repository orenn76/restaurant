package restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Soup implements Dish {

    private int preparationTime;

    @Override
    public int getPreparationTime() {
        return preparationTime;
    }

    @Override
    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
}
