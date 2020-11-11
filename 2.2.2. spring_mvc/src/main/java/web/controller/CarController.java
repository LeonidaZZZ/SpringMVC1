package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Controller
public class CarController {
    @GetMapping("/car")
    public String car(Model model, @RequestParam(value = "count",defaultValue = "5", required = false) int count){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford", "Mustang", 1979));
        cars.add(new Car("Plymouth", "Cuda", 1981));
        cars.add(new Car("Dodge", "Charger", 1969));
        cars.add(new Car("Pontiac", "GTO", 1972));
        cars.add(new Car("Chevrolet", "Camaro", 1988));
        cars = cars.stream().limit(count).collect(Collectors.toList());
        model.addAttribute("carmesage",cars);
        return "car/car";
    }
}
