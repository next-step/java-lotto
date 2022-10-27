package lotto.domain;

import lotto.exception.InvalidInputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 벨리데이션 테스트")
    void getNumber_fail() {
        // expected
        Assertions.assertThatThrownBy(() -> new LottoNumber(77))
                .isInstanceOf(InvalidInputException.class);
    }
}
