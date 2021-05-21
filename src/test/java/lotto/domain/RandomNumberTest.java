package lotto.domain;

import lotto.exception.InvalidLottoNumber;
import lotto.util.MessageContainer;
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
        RandomNumber number2 = new RandomNumber(30);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,46})
    public void 랜덤번호_범위검증(int invalidNumber) {
        assertThatThrownBy(()->new RandomNumber(invalidNumber))
                .isInstanceOf(InvalidLottoNumber.class)
                .hasMessageContaining(MessageContainer.INVALID_LOTTO_NUMBER);
    }

    @Test
    public void equals체크() {
        RandomNumber number1 = new RandomNumber(30);
        RandomNumber number2 = new RandomNumber(30);
        assertThat(number1.equals(number2)).isTrue();

        RandomNumber number3 = new RandomNumber(31);
        assertThat(number1.equals(number3)).isFalse();
    }

    @Test
    public void 출력() {
        assertThat(new RandomNumber(11).toString()).isEqualTo("11");
    }

}
