package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.LottoNumber;
import lotto.domian.Rank;
import lotto.domian.WinNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RankTest {

    private WinNumber winNumber;

    @BeforeEach
    public void setUp() {
        winNumber = new WinNumber(Lotto.of(Arrays.asList(1,2,3,4,5,6)), new LottoNumber(45));
    }

    @DisplayName("1등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFirst() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));

        Rank rank = Rank.find(winNumber.distinguish(lotto), winNumber.haveBonus(lotto));

        Assertions.assertThat(Rank.FIRST).isEqualTo(rank);
    }

    @DisplayName("2등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseSecond() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,45));

        Rank rank = Rank.find(winNumber.distinguish(lotto), winNumber.haveBonus(lotto));

        Assertions.assertThat(Rank.SECOND).isEqualTo(rank);
    }

    @DisplayName("3등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseThird() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,8));

        Rank rank = Rank.find(winNumber.distinguish(lotto), winNumber.haveBonus(lotto));

        Assertions.assertThat(Rank.THIRD).isEqualTo(rank);
    }

    @DisplayName("4등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFourth() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,8,9));

        Rank rank = Rank.find(winNumber.distinguish(lotto), winNumber.haveBonus(lotto));

        Assertions.assertThat(Rank.FOURTH).isEqualTo(rank);
    }

    @DisplayName("2개 이하를 맞혔을 경우 꽝이다.")
    @Test
    public void rank_DependsOnUnderCount_ThrowException() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,7,8,9,10));

        Rank rank = Rank.find(winNumber.distinguish(lotto), winNumber.haveBonus(lotto));

        Assertions.assertThat(Rank.MISS).isEqualTo(rank);
    }

}
