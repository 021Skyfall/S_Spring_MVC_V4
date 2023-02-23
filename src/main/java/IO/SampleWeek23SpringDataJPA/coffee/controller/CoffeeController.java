package IO.SampleWeek23SpringDataJPA.coffee.controller;

import IO.SampleWeek23SpringDataJPA.coffee.dto.CoffeePatchDto;
import IO.SampleWeek23SpringDataJPA.coffee.dto.CoffeePostDto;
import IO.SampleWeek23SpringDataJPA.coffee.entity.Coffee;
import IO.SampleWeek23SpringDataJPA.coffee.mapper.CoffeeMapper;
import IO.SampleWeek23SpringDataJPA.coffee.service.CoffeeService;
import IO.SampleWeek23SpringDataJPA.response.PageResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/coffees")
@AllArgsConstructor
@Validated
@Slf4j
public class CoffeeController {
    private CoffeeService service;
    private CoffeeMapper mapper;

    @PostMapping
    public ResponseEntity postCoffee(@Validated @RequestBody CoffeePostDto coffeePostDto) {
        Coffee response = service.createCoffee(mapper.coffeePostDtoToCoffee(coffeePostDto));
        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Validated @RequestBody CoffeePatchDto coffeePatchDto) {
        coffeePatchDto.setCoffeeId(coffeeId);
        Coffee response = service.updateCoffee(mapper.coffeePatchDtoToCoffee(coffeePatchDto));
        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response),HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") @Positive long coffeeId) {
        Coffee response = service.findCoffee(coffeeId);
        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees(@RequestParam int page,
                                     @RequestParam int size) {
        Page<Coffee> coffeePage = service.findCoffees(page -1, size);
        List<Coffee> coffees = coffeePage.getContent();

        return new ResponseEntity(new PageResponseDto<>(
                mapper.coffeesToCoffeeResponseDtos(coffees),coffeePage),HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        service.deleteCoffee(coffeeId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
