package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputTest {

    private List<Integer> lottoWinningNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottoWinningNumbers.add(0, 2);
        lottoWinningNumbers.add(1, 6);
        lottoWinningNumbers.add(2, 10);
        lottoWinningNumbers.add(3, 27);
        lottoWinningNumbers.add(4, 31);
        lottoWinningNumbers.add(5, 42);

    }

    @DisplayName("구매금액 입력 확인: empty 불가")
    @Test
    public void 구매금액_입력() {

        assertThatIllegalArgumentException().isThrownBy(() -> InputValidationCheck.checkEmpty(""));
    }

    @DisplayName("구매금액 입력 확인: 1000원 미만 불가")
    @Test
    public void 구매액수_확인() {

        assertThatIllegalArgumentException().isThrownBy(() -> InputValidationCheck.checkCash("900"));
    }

    @DisplayName("당첨번호 입력받기 확인: 6자리 입력")
    @Test
    public void 입력받은_당첨번호_자릿수_확인() {
        String[] winningNumbers = "30, 2, 12, 22, 45, 100".split(",");
        assertThat(winningNumbers.length).isEqualTo(LottoGenerator.WINNING_NUMBERS_LENGTH);
    }

    @DisplayName("당첨번호 범위 확인: 1 ~ 45")
    @Test
    public void 당첨번호_범위_확인() {
        String[] winningNumbers = "30, 2, 12, 22, 45, 100".split(",");
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidationCheck.checkWinningNumberRange(winningNumbers));
    }

    @DisplayName("당첨번호 중복 확인")
    @Test
    public void 당첨번호_중복_확인() {
        String[] winningNumbers = "30, 2, 22, 22, 45, 45".split(",");
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidationCheck.checkOverlapWinningNumber(winningNumbers));
    }

    @DisplayName("보너스번호 중복/ 보너스번호 범위 확인")
    @Test
    public void 보너스번호_유효성_확인() {
        Lotto.LOTTO_BONUS_NUMBER = 10;
        assertThatIllegalArgumentException().isThrownBy(() -> InputValidationCheck.checkBonusNumber(lottoWinningNumbers));
    }
}
