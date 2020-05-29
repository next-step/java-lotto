package lotto.domain.winning;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("WinningNumbers 클래스 테스트")
public class WinningNumbersTest {
    String winningNumberString = "1,2,3,4,5,6";
    WinningNumbers winningNumbers = new WinningNumbers(winningNumberString);

    @DisplayName("WinningNumbers 객체 생성 시 지난 주 당첨 LottoNumbers를 갖는다.")
    @Test
    void createWinningNumber() {
        assertThat(winningNumbers.getWinningLottoNumbers().getNumbers()).hasSize(LottoNumbers.LOTTO_SIZE);
    }

    @DisplayName("로또 번호를 포함하는지 확인할 수 있다.")
    @Test
    void contains() {
        LottoNumber lottoNumber = new LottoNumber(1);

        boolean contains = winningNumbers.contains(lottoNumber);

        assertThat(contains).isTrue();
    }
}
