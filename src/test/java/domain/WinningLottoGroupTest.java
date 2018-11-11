package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoGroupTest {
    Lotto lotto;
    LottoGroup lottoGroup;

    @Before
    public void setUp() throws Exception {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoGroup = new LottoGroup(Arrays.asList(lotto, lotto, lotto));
    }

    @Test
    public void 당첨로또만들기() {
        WinningLottoGroup cobineLottoGroup = LottoGame.getCombineLottos(lottoGroup, lotto);
        assertThat(cobineLottoGroup.getSize()).isEqualTo(3);
    }

    @Test
    public void 당첨안된로또목록() {
        List<Integer> diffNum = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto diff = new Lotto(diffNum);
        WinningLottoGroup cobineLottoGroup = LottoGame.getCombineLottos(lottoGroup, diff);

        assertThat(cobineLottoGroup.getSize()).isEqualTo(0);
        assertThat(cobineLottoGroup.isContain(diff)).isFalse();
    }


    @Test
    public void 당첨금총액() {
        WinningLottoGroup winningLottoGroup = LottoGame.getCombineLottos(lottoGroup, lotto);
        int sum = winningLottoGroup.getTotalReward();
        assertThat(sum).isEqualTo(3 * (LottoRank.FIRST_PRICE.getPriceRewards()));
    }

    @Test
    public void 보너스번호넣기() {
        Integer bonusNum = 10;
        lotto.addNumber(bonusNum);

    }

    @Test
    public void 보너스당첨금() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto lastLotto = new Lotto(numbers);
        Integer bonusNum = 6;
        lastLotto.addNumber(bonusNum);
        WinningLottoGroup winningLottoGroup = LottoGame.getCombineLottos(lottoGroup, lastLotto);
        int sum = winningLottoGroup.getTotalReward();
        assertThat(sum).isEqualTo(3 * (LottoRank.SECOND_PRICE.getPriceRewards()));
    }

    @Test
    public void 보너스복권구하기() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto lastLotto = new Lotto(numbers);
        Integer bonusNum = 6;
        lastLotto.addNumber(bonusNum);

        WinningLottoGroup winningLottoGroup = LottoGame.getCombineLottos(lottoGroup, lastLotto);

        int lottoCount = winningLottoGroup.getCombineNumbers(LottoRank.SECOND_PRICE.getCombineNum(), true);
        assertThat(lottoCount).isEqualTo(3);
    }
}
