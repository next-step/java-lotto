package lotto.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RankTest {
    @Test
    @DisplayName("당첨 번호와 3개 일치 하면 5등")
    void getFifthRank() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(10), new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(15), new LottoNumber(14), new LottoNumber(13), new LottoNumber(2), new LottoNumber(1), new LottoNumber(3));
        Winning winning = new Winning(new HashSet<>(winningNumber), new LottoNumber(10));
        int countOfMatch = lottery.matchWinningNumber(winning);
        Rank rank = Rank.getRankBy(countOfMatch, lottery.containBonus(winning));
        Assertions.assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("당첨 번호와 4개 일치 하면 4등")
    void getFourthRank() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(10), new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(15), new LottoNumber(14), new LottoNumber(13), new LottoNumber(2), new LottoNumber(11), new LottoNumber(3));
        Winning winning = new Winning(new HashSet<>(winningNumber), new LottoNumber(10));
        int countOfMatch = lottery.matchWinningNumber(winning);
        Rank rank = Rank.getRankBy(countOfMatch, lottery.containBonus(winning));
        Assertions.assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("당첨 번호와 5개 일치 , 보너스 번호 불일치 3등")
    void getThirdRank() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(10), new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(15), new LottoNumber(14), new LottoNumber(13), new LottoNumber(12), new LottoNumber(11), new LottoNumber(3));
        Winning winning = new Winning(new HashSet<>(winningNumber), new LottoNumber(9));
        int countOfMatch = lottery.matchWinningNumber(winning);
        Rank rank = Rank.getRankBy(countOfMatch, lottery.containBonus(winning));
        Assertions.assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("당첨 번호와 5개 일치 , 보너스 번호 일치 2등")
    void getSecondRank() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(10), new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(15), new LottoNumber(14), new LottoNumber(13), new LottoNumber(12), new LottoNumber(11), new LottoNumber(3));
        Winning winning = new Winning(new HashSet<>(winningNumber), new LottoNumber(10));
        int countOfMatch = lottery.matchWinningNumber(winning);
        Rank rank = Rank.getRankBy(countOfMatch, lottery.containBonus(winning));
        Assertions.assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("당첨 번호와 6개 일치하먄 1등")
    void getFirstRank() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(10), new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15));
        Lottery lottery = new Lottery(new HashSet<>(lottoNumbers));
        List<LottoNumber> winningNumber = Arrays.asList(new LottoNumber(15), new LottoNumber(14), new LottoNumber(13), new LottoNumber(12), new LottoNumber(11), new LottoNumber(10));
        Winning winning = new Winning(new HashSet<>(winningNumber), new LottoNumber(20));
        int countOfMatch = lottery.matchWinningNumber(winning);
        Rank rank = Rank.getRankBy(countOfMatch, lottery.containBonus(winning));
        Assertions.assertThat(rank).isEqualTo(Rank.FIRST);
    }

}
