package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또는 숫자 여섯개")
    @Test
    void createLotto() {
        Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(2), new LottoNumber(4), new LottoNumber(8), new LottoNumber(41),
            new LottoNumber(15),
            new LottoNumber(20)
        ));
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("여섯개가 아닌 숫자가 들어오면 로또생성은 실패한다")
    @Test
    void when_lotto_size_is_smaller_than_6_then_fail() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(new LottoNumber(2), new LottoNumber(4),
            new LottoNumber(8), new LottoNumber(41), new LottoNumber(15))));
    }

    @DisplayName("중복된 번호가 있으면 생성을 실패한다")
    @Test
    void when_lotto_numbers_duplicates_then_fail() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> new Lotto(Arrays.asList(new LottoNumber(2), new LottoNumber(4),
                new LottoNumber(8), new LottoNumber(41), new LottoNumber(42),
                new LottoNumber(42))));
    }

    @DisplayName("당첨번호와 로또번호를 비교한다")
    @Test
    void matchLottoWithWinningNumber() {
        Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(2), new LottoNumber(4), new LottoNumber(8), new LottoNumber(41),
            new LottoNumber(15),
            new LottoNumber(20)
        ));
        WinningNumber winningNumber = new WinningNumber(
            Arrays.asList(2, 4, 5, 15, 20, 21), 9);
        MatchInfo matchInfo = lotto.matchLottoWithWinningNumber(winningNumber);
        assertThat(matchInfo.getMatchCount()).isEqualTo(4);
    }

    @DisplayName("다섯개의 당첨번호와 보너스볼이 일치한다")
    @Test
    void match_five_winning_number_and_bonus_ball() {
        Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(2), new LottoNumber(4), new LottoNumber(8), new LottoNumber(41),
            new LottoNumber(15),
            new LottoNumber(20)
        ));
        WinningNumber winningNumber = new WinningNumber(
            Arrays.asList(2, 4, 8, 15, 20, 21), 41);
        MatchInfo matchInfo = lotto.matchLottoWithWinningNumber(winningNumber);
        assertThat(matchInfo.getMatchCount()).isEqualTo(5);
        assertThat(matchInfo.getBonusMatch()).isEqualTo(true);
    }
}
