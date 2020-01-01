package lotto.domain;

import lotto.exception.LottoServiceException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 사이즈가_6이_아니면_오류를_내보낸다() {
        assertThatThrownBy(() -> Lotto.of("1,2,3,4,5,6,7")).isInstanceOf(LottoServiceException.class)
                .hasMessage(LottoError.WRONG_LOTTO_NUMBER_SIZE.getDescription());
    }

    @Test
    void 로또넘버를_스트링으로_잘_조회하는지_확인() {
        Lotto lotto = Lotto.of("1,2,3,4,5,6");
        assertThat(lotto.getNumbersAsString()).isEqualTo("1,2,3,4,5,6");
    }
}
