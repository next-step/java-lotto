package lotto.domain;

import lotto.enums.WinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {

    @Test
    @DisplayName("로또 당첨 번호 생성")
    public void create() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        WinningNumbers winningNumbers = new WinningNumbers(7, numbers);
        assertThat(winningNumbers).isEqualTo(new WinningNumbers(7, numbers));
    }

    @Test
    @DisplayName("당첨 번호와 로또 번호를 비교하여 매칭된 번호 개수를 구한다.")
    public void matchWith() throws Exception {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(7, 1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(LottoNumbers.from(1, 2, 3, 4, 5, 6));

        //when
        WinningRank winningRank = winningNumbers.matchWith(lottoTicket);

        //then
        assertThat(winningRank).isEqualTo(WinningRank.FIRST_PLACE);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복 시 예외가 발생한다.")
    public void checkDuplication() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(6, numbers));
    }
}
