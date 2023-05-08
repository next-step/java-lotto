package lotto.domain;

import lotto.domian.Lotto;
import lotto.domian.LottoNumber;
import lotto.domian.Rank;
import lotto.domian.WinNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class RankTest {

    private WinNumber winNumber;
    private Set<LottoNumber> lottoNumberSet = new HashSet<>();

    @BeforeEach
    public void setUp() {
        winNumber = new WinNumber(Lotto.of(1,2,3,4,5,6));

        lottoNumberSet.add(new LottoNumber(1));
        lottoNumberSet.add(new LottoNumber(2));
    }

    @DisplayName("1등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFirst() {
        lottoNumberSet.add(new LottoNumber(3));
        lottoNumberSet.add(new LottoNumber(4));
        lottoNumberSet.add(new LottoNumber(5));
        lottoNumberSet.add(new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumberSet);

        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.FIRST).isEqualTo(rank);
    }

    @DisplayName("2등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseSecond() {
        lottoNumberSet.add(new LottoNumber(3));
        lottoNumberSet.add(new LottoNumber(4));
        lottoNumberSet.add(new LottoNumber(5));
        lottoNumberSet.add(new LottoNumber(7));
        Lotto lotto = new Lotto(lottoNumberSet);

        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.SECOND).isEqualTo(rank);
    }

    @DisplayName("3등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseThird() {
        lottoNumberSet.add(new LottoNumber(3));
        lottoNumberSet.add(new LottoNumber(4));
        lottoNumberSet.add(new LottoNumber(7));
        lottoNumberSet.add(new LottoNumber(8));
        Lotto lotto = new Lotto(lottoNumberSet);

        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.THIRD).isEqualTo(rank);
    }

    @DisplayName("4등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFourth() {
        lottoNumberSet.add(new LottoNumber(3));
        lottoNumberSet.add(new LottoNumber(7));
        lottoNumberSet.add(new LottoNumber(8));
        lottoNumberSet.add(new LottoNumber(9));
        Lotto lotto = new Lotto(lottoNumberSet);

        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.FOURTH).isEqualTo(rank);
    }

    @DisplayName("2개 이하를 맞힐 경우 예외가 발생한다.")
    @Test
    public void rank_DependsOnUnderCount_ThrowException() {
        lottoNumberSet.add(new LottoNumber(7));
        lottoNumberSet.add(new LottoNumber(8));
        lottoNumberSet.add(new LottoNumber(9));
        lottoNumberSet.add(new LottoNumber(10));
        Lotto lotto = new Lotto(lottoNumberSet);

        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.MISS).isEqualTo(rank);
    }

}
