package lotto.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningTest {

    @Test
    @DisplayName("보너스 볼이 당첨 번호에 포함되면 예외를 발생시킨다.")
    void isValidWinningLotto() {
        Lottery winningNumbers = LottoCreator.convertToLotto("1,2,3,4,5,6");
        assertThatThrownBy(() -> new Winning(winningNumbers, new LottoNumber(3))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호와 3개 일치")
    void matchLottery() {
        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Winning winning = new Winning(new Lottery(new HashSet<>(winningNumber)), new LottoNumber(7));

        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        Rank rank = winning.match(lottery);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("당첨 번호와 4개 일치")
    void matchLottery2() {
        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Winning winning = new Winning(new Lottery(new HashSet<>(winningNumber)), new LottoNumber(7));

        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(15), new LottoNumber(16));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        Rank rank = winning.match(lottery);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("당첨 번호와 5개 일치 , 보너스 볼 불일치")
    void matchLottery3() {
        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Winning winning = new Winning(new Lottery(new HashSet<>(winningNumber)), new LottoNumber(7));

        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(16));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        Rank rank = winning.match(lottery);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("당첨 번호와 5개 일치 , 보너스 볼 일치")
    void matchLottery4() {
        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Winning winning = new Winning(new Lottery(new HashSet<>(winningNumber)), new LottoNumber(7));

        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        Rank rank = winning.match(lottery);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("당첨 번호와 6개 일치")
    void matchLottery5() {
        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Winning winning = new Winning(new Lottery(new HashSet<>(winningNumber)), new LottoNumber(7));

        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        Rank rank = winning.match(lottery);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }


}
