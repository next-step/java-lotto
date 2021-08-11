package lotto.step2;

import lotto.step2.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호는 1부터 45사이 숫자만 가능하다.")
    @ValueSource(ints = {0,-1,46,58})
    void isValidLottoNumber(int number) {
        Assertions.assertThatThrownBy(()-> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }
}