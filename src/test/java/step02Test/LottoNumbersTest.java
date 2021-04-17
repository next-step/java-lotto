package step02Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.model.numberRule.InputNumberRule;
import step02.model.lotto.LottoNumber;
import step02.model.lotto.LottoNumbers;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    LottoNumbers lottoNumbers;

    @BeforeEach
    void setLottoNumber() {
        lottoNumbers = new LottoNumbers(new InputNumberRule("7, 8, 10, 20, 40, 44"));
    }

    @Test
    @DisplayName("매징되는 숫자 카운트 테스트")
    void compareMathNumber() {
        assertThat(lottoNumbers.countCompareMatchNumber(new LottoNumbers(new InputNumberRule("7, 8, 10, 20, 40, 44")))).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 넘버 매칭 테스트")
    void matchBonusNumber() {
        assertThat(lottoNumbers.compareMatchBonusNumber(new LottoNumber(7))).isEqualTo(true);
        assertThat(lottoNumbers.compareMatchBonusNumber(new LottoNumber(1))).isEqualTo(false);
    }
}
