package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.LottoNumbers;
import study.lotto.util.LottoNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @DisplayName("자동으로 랜덤한 6개의 로또 번호를 가진 로또종이가 생성")
    @Test
    public void randomNumberLottoPaperTest() {
        LottoNumbers lottoNumbers = LottoNumbers.randomNumbers();
        assertThat(lottoNumbers.lottoNumbers().size()).isEqualTo(6);
        assertThat(lottoNumbers.lottoNumbers().get(0)).isNotEqualByComparingTo(lottoNumbers.lottoNumbers().get(1));
    }

    @DisplayName("당첨 번호와 일치 개수 확인")
    @Test
    public void randomNumberLottoPaperTest2() {
        LottoNumbers lottoNumbers = new LottoNumbers(LottoNumberGenerator.markedNumbers("1,2,3,4,5,6"));
        LottoNumbers winningNumbers = new LottoNumbers(LottoNumberGenerator.markedNumbers("1,2,3,4,5,6"));
        int matchCount = lottoNumbers.matchWinningNumberCount(winningNumbers);

        assertThat(matchCount).isEqualTo(6);
    }


}
