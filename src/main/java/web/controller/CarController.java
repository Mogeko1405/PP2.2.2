package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;


@Controller
@RequestMapping(value = "/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String index(Model model, @RequestParam(value = "count", required = false) String count) {
        if (count != null) {
            model.addAttribute("cars", carService.index(Long.valueOf(count)));
        } else {
            model.addAttribute("cars", carService.index(5L));
        }
        return "cars";
    }
}
