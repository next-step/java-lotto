package lotto.domain.winning;

import lotto.domain.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("WinningNumbers 클래스 테스트")
public class WinningNumbersTest {

    @DisplayName("WinningNumbers 객체 생성 시 지난 주 당첨 LottoNumbers를 갖는다.")
    @Test
    void createWinningNumber() {
        String winningNumberString = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberString);

        assertThat(winningNumbers.getWinningLottoNumbers().getNumbers()).hasSize(LottoNumbers.LOTTO_SIZE);
    }
}
