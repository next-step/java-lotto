package lotto.model;

import common.model.Number;
import lotto.application.Constant;
import lotto.factory.LottoNumberFactory;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @RepeatedTest(20)
    @DisplayName("로또 번호 자동생성")
    void autoCreate() {
        LottoNumbers lottoNumbers = LottoNumberFactory.autoCreateNumbers(new LottoNumberGenerator());
        assertThat(lottoNumbers.getLottoNumbers()).hasSize(Constant.LOTTO_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("로또 당첨 확인")
    void matchRank() {
        LottoNumbers lottoNumbers = LottoNumberFactory.autoCreateNumbers(new LottoNumberGenerator());
        lottoNumbers.matchRank(new Number(6));
        assertThat(lottoNumbers.getLottoRank()).isEqualTo(LottoRank.FIRST);
    }
}