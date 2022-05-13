package calculator.operation;

import calculator.domain.operation.Division;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivisionTest {

    @Test
    void 나눗셈_계산_딱_떨어지는_경우() {
        assertThat(new Division(4, 2).getResult()).isEqualTo(2);
    }
    @Test
    void 나눗셈_계산_나머지_남는_경우() {
        assertThat(new Division(4, 3).getResult()).isEqualTo(1);
    }

    @Test
    void 나눗셈_계산_더_큰수_나눌_경우() {
        assertThat(new Division(1, 3).getResult()).isEqualTo(0);
    }

}