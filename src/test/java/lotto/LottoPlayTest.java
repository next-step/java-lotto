package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class LottoPlayTest {

    @ParameterizedTest
    @CsvSource({"14000, 14"})
    @DisplayName("입력된 금액만큼의 해당하는 로또를 발급한다.")
    void generateLotto(int input, int countLotto) {
        LottoPlay lottoPlay = new LottoPlay();
        lottoPlay.createLotto(input);
        assertThat(lottoPlay.getLottoNumbers().size()).isEqualTo(countLotto);
    }
}
