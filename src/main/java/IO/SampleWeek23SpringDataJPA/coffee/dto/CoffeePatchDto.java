package IO.SampleWeek23SpringDataJPA.coffee.dto;

import IO.SampleWeek23SpringDataJPA.validator.NotSpace;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@Getter
public class CoffeePatchDto {
    private long coffeeId;

    @NotSpace(message = "커피명(한글)은 공백이 아니어야 합니다.")
    private String korName;

    @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$", message = "커피명(영문)은 영문이어야 합니다. 예) Cafe Latte")
    private String engName;

    @Range(min= 100, max= 50000)
    private Integer price;


    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public Integer getPrice() {
        return price;
    }
}
