package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoShuffle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShuffleTest {
    @Test
    @DisplayName("로또 번호 생성 테스트")
    void makeLottoNumberTest() {
        LottoNumbers lottoNumbers = LottoShuffle.makeLottoNumbersInRange();
        lottoNumbers.getLottoNumbers()
                .forEach(number -> assertThat(number.getLottoNumber())
                        .isGreaterThanOrEqualTo(1)
                        .isLessThanOrEqualTo(45));
    }

}
