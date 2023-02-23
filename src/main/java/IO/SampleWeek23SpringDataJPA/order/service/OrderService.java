package IO.SampleWeek23SpringDataJPA.order.service;

import IO.SampleWeek23SpringDataJPA.exception.BusinessLogicException;
import IO.SampleWeek23SpringDataJPA.exception.ExceptionCode;
import IO.SampleWeek23SpringDataJPA.order.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public Order createOrder(Order order) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Order findOrder(long orderId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Page<Order> findOrders(int page, int size) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public void cancelOrder(long orderId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    private Order findVerifiedOrder(long orderId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
}
