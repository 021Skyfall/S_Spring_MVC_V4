package IO.SampleWeek23SpringDataJPA.order.dto;

import IO.SampleWeek23SpringDataJPA.coffee.dto.CoffeeResponseDto;
import IO.SampleWeek23SpringDataJPA.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private long orderId;
    private long memberId;
    private Order.OrderStatus orderStatus;
    private List<CoffeeResponseDto> orderCoffees;
    private LocalDateTime createdAt;
}
