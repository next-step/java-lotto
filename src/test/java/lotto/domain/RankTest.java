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
import java.util.List;

public class RankTest {

    private WinNumber winNumber;

    @BeforeEach
    public void setUp() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)        // todo) new LottoNumber() 로 테스트 데이터 만드는 것 수정하기
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
        Lotto winLotto = new Lotto(lottoNumberList);
        winNumber = new WinNumber(winLotto);
    }

    @DisplayName("1등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFirst() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumberList);
        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.FIRST).isEqualTo(rank);
    }

    @DisplayName("2등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseSecond() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(7));
        Lotto lotto = new Lotto(lottoNumberList);
        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.SECOND).isEqualTo(rank);
    }

    @DisplayName("3등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseThird() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(7)
                , new LottoNumber(8));
        Lotto lotto = new Lotto(lottoNumberList);
        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.THIRD).isEqualTo(rank);
    }

    @DisplayName("4등을 가릴 수 있다.")
    @Test
    public void rank_DependsOnCount_ChooseFourth() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(7)
                , new LottoNumber(8)
                , new LottoNumber(9));
        Lotto lotto = new Lotto(lottoNumberList);
        Rank rank = Rank.find(winNumber.distinguish(lotto));

        Assertions.assertThat(Rank.FOURTH).isEqualTo(rank);
    }

    @DisplayName("2개 이하를 맞힐 경우 예외가 발생한다.")
    @Test
    public void rank_DependsOnUnderCount_ThrowException() {
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(7)
                , new LottoNumber(8)
                , new LottoNumber(9)
                , new LottoNumber(10));
        Lotto lotto = new Lotto(lottoNumberList);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Rank.find(winNumber.distinguish(lotto)));
    }

}
