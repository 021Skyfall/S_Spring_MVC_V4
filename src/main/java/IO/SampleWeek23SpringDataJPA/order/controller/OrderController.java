package IO.SampleWeek23SpringDataJPA.order.controller;

import IO.SampleWeek23SpringDataJPA.coffee.service.CoffeeService;
import IO.SampleWeek23SpringDataJPA.order.dto.OrderPostDto;
import IO.SampleWeek23SpringDataJPA.order.entity.Order;
import IO.SampleWeek23SpringDataJPA.order.mapper.OrderMapper;
import IO.SampleWeek23SpringDataJPA.order.service.OrderService;
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
@RequestMapping("/v1/orders")
@AllArgsConstructor
@Validated
@Slf4j
public class OrderController {
    private final OrderService service;
    private final OrderMapper mapper;
    private final CoffeeService coffeeService;

    @PostMapping
    public ResponseEntity postOrder(@Validated @RequestBody OrderPostDto orderPostDto) {
        Order order = service.createOrder(mapper.orderPostDtoToOrder(orderPostDto));
        return new ResponseEntity<>(
                mapper.orderToOrderResponseDto(order,null), HttpStatus.CREATED);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("/order-id") @Positive long orderId) {
        Order order = service.findOrder(orderId);
        return new ResponseEntity<>(mapper.orderToOrderResponseDto(order,null),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders(@Positive @RequestParam int page,
                                    @Positive @RequestParam int size) {
        Page<Order> orderPage = service.findOrders(page-1,size);
        List<Order> orders = orderPage.getContent();

        return new ResponseEntity(
                new PageResponseDto<>(mapper.ordersToOrderResponseDtos(orders),orderPage),
                HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity deleteOrder(@PathVariable("order-id") @Positive long orderId) {
        service.cancelOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
