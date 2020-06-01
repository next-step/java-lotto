package lotto.domain.winning;

import lotto.domain.generator.FixedNumberGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("WinningNumbers 클래스 테스트")
public class WinningLottoTest {
    String winningNumberString = "1,2,3,4,5,6";
    WinningLotto winningLotto = new WinningLotto(winningNumberString);

    @DisplayName("WinningNumbers 객체 생성 시 지난 주 당첨 LottoNumbers를 갖는다.")
    @Test
    void createWinningNumber() {
        assertThat(winningLotto.getWinningLottoNumbers().getNumbers()).hasSize(LottoNumbers.LOTTO_SIZE);
    }

    @DisplayName("equals 메소드 테스트")
    @Test
    void equals() {
        assertThat(winningLotto.equals(new WinningLotto(winningNumberString))).isTrue();
    }

    @DisplayName("LottoNumbers 비교하여 존재하는 갯수를 리턴할 수 있다.")
    @Test
    void matchCount() {
        String winningNumberString = "1,2,3,4,5,6";
        WinningLotto winningLotto = new WinningLotto(winningNumberString);

        NumberGenerator<LottoNumber> fixedNumberGenerator = new FixedNumberGenerator();
        LottoNumbers lottoNumbers = LottoNumbers.newLottoNumbersWithNumberGenerator(fixedNumberGenerator);

        int matchCount = winningLotto.matchCount(lottoNumbers);

        assertThat(matchCount).isEqualTo(fixedNumberGenerator.getNumbers().size());
    }
}
