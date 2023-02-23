package IO.SampleWeek23SpringDataJPA.order.mapper;

import IO.SampleWeek23SpringDataJPA.coffee.entity.Coffee;
import IO.SampleWeek23SpringDataJPA.order.dto.OrderPostDto;
import IO.SampleWeek23SpringDataJPA.order.dto.OrderResponseDto;
import IO.SampleWeek23SpringDataJPA.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    Order orderPostDtoToOrder(OrderPostDto orderPostDto);
    OrderResponseDto orderToOrderResponseDto(Order order, List<Coffee> coffees);
    List<OrderResponseDto> ordersToOrderResponseDtos(List<Order> orders);
}
