package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    @DisplayName("로또 1~45 숫자 리스트의 크기를 검증한다.")
    void 로또_숫자_리스트_테스트() {
        assertThat(LottoNumbers.getDefaultLottoNumbers()).hasSize(LottoNumber.LOTTO_NUMBER_MAX);
    }
}
