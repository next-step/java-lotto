package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriceTest {

    @DisplayName("입력받은 값을 가격 객체로 생성할 수 있다.")
    @Test
    void create() {
        Price expect = new Price(1000);

        Price actual = new Price(1000);

        assertThat(actual).isEqualTo(expect);
    }
}