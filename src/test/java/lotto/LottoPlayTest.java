package lotto;

import lotto.domain.LottoPlay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;


import static org.assertj.core.api.Assertions.*;

class LottoPlayTest {

    @Test
    @DisplayName("수동으로 로또를 구매할 수 있다.")
    void canBuyLottoByManual() {
        LottoPlay lottoPlay = new LottoPlay();
        lottoPlay.createLottoByManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoPlay.getLottoNumbers().size()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"14000, 14"})
    @DisplayName("입력된 금액만큼의 해당하는 로또를 발급한다.")
    void generateLotto(int input, int countLotto) {
        LottoPlay lottoPlay = new LottoPlay();
        lottoPlay.createLotto(input);
        assertThat(lottoPlay.getLottoNumbers().size()).isEqualTo(countLotto);
    }
}
