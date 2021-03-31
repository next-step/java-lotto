package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {

    @Test
    @DisplayName("로또 당첨 번호 생성")
    public void create() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = WinningNumbers.from((numbers));
        assertThat(winningNumbers).isEqualTo(WinningNumbers.from((numbers)));
    }

    @Test
    @DisplayName("로또 번호와 비교")
    public void countMatchingNumbers() throws Exception {
        //given
        WinningNumbers winningNumbers = WinningNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = LottoNumbers.createByintegers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //when
        MatchedCount matchedCount = winningNumbers.countMatchingNumbers(lottoTicket.lottoNumbers());

        //then
        assertThat(matchedCount.matchedCount()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 번호 길이가 6자 이외일 경우 예외")
    public void checkLength() throws Exception {
        List<Integer> overSix = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.from((overSix)));
        List<Integer> lowerSix = Arrays.asList(1, 2, 3, 4, 5);
        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.from((lowerSix)));
    }

    @Test
    @DisplayName("당첨 번호의 요소 범위가 1 ~ 45가 아닐 경우 예외")
    public void checkBound() throws Exception {
        List<Integer> overMax = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.from((overMax)));
        List<Integer> lowerMin = Arrays.asList(0, 2, 3, 4, 5, 45);
        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.from((lowerMin)));
    }

    @Test
    @DisplayName("당첨 번호 중 중복되는 숫자가 존재할 경우")
    public void checkDuplication() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.from((numbers)));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복 시 에러")
    public void check() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = WinningNumbers.from(numbers);
        assertThatIllegalArgumentException().isThrownBy(() -> winningNumbers.check(new LottoNumber(1)));
    }
}
