package IO.SampleWeek23SpringDataJPA.coffee.mapper;

import IO.SampleWeek23SpringDataJPA.coffee.dto.CoffeePatchDto;
import IO.SampleWeek23SpringDataJPA.coffee.dto.CoffeePostDto;
import IO.SampleWeek23SpringDataJPA.coffee.dto.CoffeeResponseDto;
import IO.SampleWeek23SpringDataJPA.coffee.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);
}
