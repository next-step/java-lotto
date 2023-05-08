package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.Rank;
import lotto.domian.WinNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    private WinNumber winNumber;

    @BeforeEach
    public void setUp() {
        winNumber = new WinNumber(Lotto.of(1,2,3,4,5,6));
    }

    @DisplayName("1등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFirst() {
        Lotto lotto = Lotto.of(1,2,3,4,5,6);

        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.FIRST).isEqualTo(rank);
    }

    @DisplayName("2등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseSecond() {
        Lotto lotto = Lotto.of(1,2,3,4,5,7);

        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.SECOND).isEqualTo(rank);
    }

    @DisplayName("3등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseThird() {
        Lotto lotto = Lotto.of(1,2,3,4,7,8);

        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.THIRD).isEqualTo(rank);
    }

    @DisplayName("4등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFourth() {
        Lotto lotto = Lotto.of(1,2,3,7,8,9);

        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.FOURTH).isEqualTo(rank);
    }

    @DisplayName("2개 이하를 맞힐 경우 예외가 발생한다.")
    @Test
    public void rank_DependsOnUnderCount_ThrowException() {
        Lotto lotto = Lotto.of(1,2,7,8,9,10);

        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.MISS).isEqualTo(rank);
    }

}
