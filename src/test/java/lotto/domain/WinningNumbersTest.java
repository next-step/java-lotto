package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {

    @Test
    @DisplayName("로또 당첨 번호 생성")
    public void create() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        WinningNumbers winningNumbers = WinningNumbers.from((numbers));
        assertThat(winningNumbers).isEqualTo(WinningNumbers.from((numbers)));
    }

    @Test
    @DisplayName("당첨 번호와 로또 번호를 비교하여 매칭된 번호 개수를 구한다.")
    public void matchedCountWith() throws Exception {
        //given
        WinningNumbers winningNumbers = WinningNumbers.from(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = LottoNumbers.from(1, 2, 3, 4, 5, 6);

        //when
        MatchedCount matchedCount = winningNumbers.matchedCountWith(lottoNumbers.lottoNumbers());

        //then
        assertThat(matchedCount).isEqualTo(new MatchedCount(6));
    }

    @Test
    @DisplayName("당첨 번호 길이가 6자 이외일 경우 예외가 발생한다.")
    public void checkLength() throws Exception {
        int[] overSix = {1, 2, 3, 4, 5, 6, 7};
        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.from(overSix));
        int[] lowerSix = {1, 2, 3, 4, 5};
        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.from(lowerSix));
    }

    @Test
    @DisplayName("당첨 번호 중 중복되는 숫자가 존재할 경우 예외가 발생한다.")
    public void checkDuplication() throws Exception {
        int[] winningNumbers = {1, 2, 3, 4, 5, 5};
        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.from(winningNumbers));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복 시 예외가 발생한다.")
    public void check() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        WinningNumbers winningNumbers = WinningNumbers.from(numbers);
        assertThatIllegalArgumentException().isThrownBy(() -> winningNumbers.check(LottoNumber.of(1)));
    }
}
