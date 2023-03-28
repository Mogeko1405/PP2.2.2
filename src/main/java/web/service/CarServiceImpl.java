package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CarServiceImpl implements CarService {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1L, "MONJARO", "111-111"));
        cars.add(new Car(2L, "COOLRAY", "222-222"));
        cars.add(new Car(3L, "OKAVANGO", "333-333"));
        cars.add(new Car(4L, "ATLAS", "444-444"));
        cars.add(new Car(5L, "TUGELLA", "555-555"));
    }

    @Override
    public List<Car> index(Long count) {
        return cars.stream().limit(Objects.requireNonNullElse(count, 5L)).toList();
    }
}
