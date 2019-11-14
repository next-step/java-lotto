package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.LottoNumber;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoWinningNumbersTest {

    @BeforeEach
    void setUp() {
        System.out.println("로또 LottoWinningNumbers 테스트");
    }

    @DisplayName("당첨번호 입력받기 확인: 6자리 입력")
    @Test
    public void 입력받은_당첨번호_자릿수_확인() {
        String[] winningNumbers = "30, 2, 12, 22, 45, 5, 8".split(",");
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.checkWinningNumberLength(winningNumbers));
    }

    @DisplayName("당첨번호 범위 확인: 1 ~ 45")
    @Test
    public void 당첨번호_범위_확인() {
        String[] winningNumbers = "30, 2, 12, 22, 45, 1".split(",");
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.createLottoNumber(winningNumbers));
    }

    @DisplayName("당첨번호 중복 확인")
    @Test
    public void 당첨번호_중복_확인() {
        String[] winningNumbers = "30, 2, 22, 22, 45, 45".split(",");
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.checkOverlapWinningNumber(winningNumbers));
    }

    @DisplayName("보너스번호 중복/ 보너스번호 범위 확인")
    @Test
    public void 보너스번호_유효성_확인() {
        LottoNumber.lottoBonusNumber = 10;
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.checkOverlapBonusNumber(10));
    }
}
