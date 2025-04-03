package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningNumbersTest {
    @Test
    @DisplayName("빈 당첨 번호를 생성할 수 없다.")
    void create() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers(" ", 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호는 쉼표로 구분된 6개가 아닌 경우 예외발생한다.")
    void create_1() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,", 10))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("1~45 사이의 숫자가 아닌 경우 예외발생한다.")
    void create_2() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,46", 10))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("중복된 숫자가 있으면 예외가 발생한다.")
    void create_3() {
        Assertions.assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5", 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 티켓을 받아 매치 카운트 정보를 반환한다.")
    void matchCount() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 10);
        Lotto lotto = new Lotto(List.of(LottoNumber.ONE, LottoNumber.TWO, LottoNumber.THREE, LottoNumber.FOUR, LottoNumber.FIVE, LottoNumber.SIX));
        Lotto lotto2 = new Lotto(List.of(LottoNumber.ONE, LottoNumber.TWO, LottoNumber.THREE, LottoNumber.FOUR, LottoNumber.FIVE, LottoNumber.SEVEN));
        Lotto lotto3 = new Lotto(List.of(LottoNumber.ONE, LottoNumber.TWO, LottoNumber.THREE, LottoNumber.FOUR, LottoNumber.FIVE, LottoNumber.EIGHT));
        LottoTicket lottoTicket = new LottoTicket(List.of(lotto, lotto2, lotto3));
        List<MatchCount> matchCounts = winningNumbers.match(lottoTicket);
        Assertions.assertThat(matchCounts).hasSize(3);
    }

    @Test
    @DisplayName("로또 티켓을 받아 당첨과 관련된 요약정보를 만들어준다.")
    void summary() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 10);
        Lotto lotto = new Lotto(List.of(LottoNumber.ONE, LottoNumber.TWO, LottoNumber.THREE, LottoNumber.FOUR, LottoNumber.FIVE, LottoNumber.SIX));
        Lotto lotto2 = new Lotto(List.of(LottoNumber.ONE, LottoNumber.TWO, LottoNumber.THREE, LottoNumber.FOUR, LottoNumber.FIVE, LottoNumber.SEVEN));
        Lotto lotto3 = new Lotto(List.of(LottoNumber.ONE, LottoNumber.TWO, LottoNumber.THREE, LottoNumber.FOUR, LottoNumber.FIVE, LottoNumber.EIGHT));
        LottoTicket lottoTicket = new LottoTicket(List.of(lotto, lotto2, lotto3));
        Summary summary = winningNumbers.summarize(lottoTicket);
        Assertions.assertThat(summary).isNotNull();
    }

}
