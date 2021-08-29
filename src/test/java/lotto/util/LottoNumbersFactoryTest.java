package lotto.util;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersFactoryTest {

    @DisplayName("자동 생성")
    @Test
    void makeAutoLottoNumbers_ReturnRandomSixLottoNumbers() {
        LottoNumbers lottoNumbers1 = LottoNumbersFactory.makeAutoLottoNumbers();
        LottoNumbers lottoNumbers2 = LottoNumbersFactory.makeAutoLottoNumbers();
        assertThat(lottoNumbers1).isNotEqualTo(lottoNumbers2);
    }
}
