package lotto.domain;

import lotto.exception.InvalidLottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
                .isInstanceOf(InvalidLottoNumber.class);
    }

}
