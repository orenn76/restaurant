package restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private int id;

    private List<Dish> dishes;

    private int table;

    private boolean isReady;

    private String comment;

}