package lotto.domain;

import lotto.exception.InvalidLottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberTest {
    @Test
    public void 랜덤번호_생성() {
        // random하게 생성
        RandomNumber number1 = new RandomNumber();
        // 특정 수로 생성
        CustomNumber number2 = new CustomNumber(30);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,46})
    public void 랜덤번호_범위검증(int invalidNumber) {
        assertThatThrownBy(()->new CustomNumber(invalidNumber))
                .isInstanceOf(InvalidLottoNumber.class)
                .hasMessageContaining(InvalidLottoNumber.INVALID_LOTTO_NUMBER);
    }

    @Test
    public void equals체크() {
        CustomNumber number1 = new CustomNumber(30);
        CustomNumber number2 = new CustomNumber(30);
        assertThat(number1.equals(number2)).isTrue();

        CustomNumber number3 = new CustomNumber(31);
        assertThat(number1.equals(number3)).isFalse();
    }

    @Test
    public void 출력() {
        assertThat(new CustomNumber(11).toString()).isEqualTo("11");
    }

}
