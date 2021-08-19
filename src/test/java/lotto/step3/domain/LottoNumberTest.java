package lotto.step3.domain;

import lotto.step3.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호는 1~45 사이 숫자만 올 수 있다.")
    @ValueSource(ints = {-1, 0, 46})
    void checkValidLottoNumber(int number) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }
}
