import dto.string_calculator.Number;
import dto.string_calculator.TotalNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalNumberTest {

    private TotalNumber totalNumber;

    @BeforeEach
    public void init() {
        totalNumber = new TotalNumber(new Number("1"));
    }

    @Test
    @Order(1)
    public void 덧셈() {
        long expected = 2L;
        totalNumber.add(new Number("1"));
        assertThat(totalNumber.getTotal()).isEqualTo(expected);
    }

    @Test
    @Order(2)
    public void 뺄셈() {
        long expected = 0L;
        totalNumber.subtract(new Number("1"));
        assertThat(totalNumber.getTotal()).isEqualTo(expected);
    }

    @Test
    @Order(3)
    public void 나눗셈() {
        long expected = 1L;
        totalNumber.divide(new Number("1"));
        assertThat(totalNumber.getTotal()).isEqualTo(expected);
    }

    @Test
    @Order(4)
    public void 곱셈() {
        long expected = 100L;
        totalNumber.multiply(new Number("100"));
        assertThat(totalNumber.getTotal()).isEqualTo(expected);
    }

}
