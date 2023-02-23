package IO.SampleWeek23SpringDataJPA.coffee.service;

import IO.SampleWeek23SpringDataJPA.coffee.entity.Coffee;
import IO.SampleWeek23SpringDataJPA.exception.BusinessLogicException;
import IO.SampleWeek23SpringDataJPA.exception.ExceptionCode;
import IO.SampleWeek23SpringDataJPA.order.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    public Coffee createCoffee(Coffee coffee) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Coffee updateCoffee(Coffee coffee) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Coffee findCoffee(long coffeeId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    // 주문에 해당하는 커피 정보 조회
    public List<Coffee> findOrderedCoffees(Order order) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Page<Coffee> findCoffees(int page, int size) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public void deleteCoffee(long coffeeId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Coffee findVerifiedCoffee(long coffeeId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    private void verifyExistCoffee(String coffeeCode) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    private Coffee findVerifiedCoffeeByQuery(long coffeeId) {
        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
}
