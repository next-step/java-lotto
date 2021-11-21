package lotto.model;

import common.model.Number;
import common.view.OutputView;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @RepeatedTest(20)
    @DisplayName("로또 번호 자동생성")
    void autoCreate() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGenerator());
        assertThat(lottoNumbers.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 당첨 확인")
    void matchRank() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGenerator());
        lottoNumbers.matchRank(new Number(6));
        assertThat(lottoNumbers.getLottoRank()).isEqualTo(LottoRank.FIRST);
    }
}