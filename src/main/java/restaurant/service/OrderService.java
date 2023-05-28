package restaurant.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import restaurant.model.Dish;
import restaurant.model.Order;
import restaurant.model.Soup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class OrderService {

    private final ExecutorService executor = Executors.newFixedThreadPool(3);
    private BlockingQueue<Order> preparedOrders = new LinkedBlockingQueue<>();

    public void placeOrder(Order order) {

        AtomicInteger sumPreparationTime = new AtomicInteger();

        if (order.getDishes() != null) {
            order.getDishes().forEach(dish -> {
                sumPreparationTime.addAndGet(dish.getPreparationTime());
            });

            executor.submit(() -> {
                log.info("Shef starting creating a new order");
                try {
                    TimeUnit.SECONDS.sleep(sumPreparationTime.get());
                    order.setReady(true);
                    preparedOrders.add(order);
                    log.info("Shef starting creating a new order");
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public BlockingQueue<Order> getPreparedOrders() {
        return preparedOrders;
    }

    public Order getPreparedOrder() {
        return preparedOrders.remove();
    }
}
