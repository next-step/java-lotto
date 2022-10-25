package lotto.domain;

import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("보너스 번호 테스트 - 중복")
    void getNumber() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        // expected
        assertThatThrownBy(() -> new LottoNumber(lottoNumbers, 6))
                .isInstanceOf(InvalidInputException.class);
    }
}
