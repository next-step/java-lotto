package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @Test
    @DisplayName("보너스 번호 매치 테스트")
    public void bonusNumberMatch(){
        List<LottoNumber> lottoNumbers = LottoTicket.toLottoTickets(3,5,7,9,13,11);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(3,5,7,9,6,10),11);
        assertThat(winningNumbers.bonusNumberMatch(lottoNumbers)).isTrue();
    }

    @Test
    @DisplayName("보너스 번호 매치 실패 테스트")
    public void bonusNumberFailMatch(){
        List<LottoNumber> lottoNumbers = LottoTicket.toLottoTickets(3,5,7,9,13,11);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(3,5,7,9,6,10),12);
        assertThat(winningNumbers.bonusNumberMatch(lottoNumbers)).isFalse();
    }
    @Test
    @DisplayName("당첨번호 당첨 갯수 테스트")
    public void winningNumbersMatch(){
        List<LottoNumber> lottoNumbers = LottoTicket.toLottoTickets(3,5,7,9,13,11);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(3,5,7,9,18,17),15);
        assertThat(winningNumbers.lottoMatchCount(lottoNumbers)).isEqualTo(4);
    }

    @Test
    @DisplayName("당첨번호가 6개가 초과하여 들어올 경우 테스트")
    public void winningNumbersSizeException(){
        assertThatThrownBy(() -> new WinningNumbers(List.of(3,5,6,7,8,9,10),15))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개만 입력해주세요.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호와 일치할 때")
    public void bonusNumberExceptionCheck(){
        assertThatThrownBy(() -> new WinningNumbers(List.of(3,5,6,7,8,9),9))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이미 당첨번호에 포함 되어 있습니다.");
    }

    @Test
    @DisplayName("빈값 테스트")
    public void winningNumbersNullPointException(){
        assertThatThrownBy(() -> new WinningNumbers(List.of(),10))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("빈값이 들어왔습니다.");
    }
}
