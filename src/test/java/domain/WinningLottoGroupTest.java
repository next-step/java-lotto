package domain;

import org.junit.Before;
import org.junit.Test;
import view.ResultView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoGroupTest {
    Lotto lotto;
    LottoGroup lottoGroup;
    List<Integer> numbers;

    @Before
    public void setUp() throws Exception {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lotto = new Lotto(numbers);
        lottoGroup = new LottoGroup(Arrays.asList(lotto, lotto, lotto));
    }

    @Test
    public void 당첨로또만들기() {
        WinningLotto winningLotto = new WinningLotto(lotto);
        WinningLottoGroup cobineLottoGroup =lottoGroup.getCombineLottos(winningLotto);
        assertThat(cobineLottoGroup.getSize()).isEqualTo(3);
    }

    @Test
    public void 당첨안된로또목록() {
        List<Integer> diffNum = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto diff = new Lotto(diffNum);
        WinningLotto winningLotto = new WinningLotto(diff);
        WinningLottoGroup cobineLottoGroup = lottoGroup.getCombineLottos(winningLotto);

        assertThat(cobineLottoGroup.getSize()).isEqualTo(0);
        assertThat(cobineLottoGroup.isContain(diff)).isFalse();
    }


    @Test
    public void 당첨금총액() {
        WinningLotto winningLotto = new WinningLotto(lotto);
        WinningLottoGroup cobineLottoGroup = lottoGroup.getCombineLottos(winningLotto);
        int sum = cobineLottoGroup.getTotalReward();
        assertThat(sum).isEqualTo(3 * (LottoRank.FIRST_PRICE.getPriceRewards()));
    }

    @Test
    public void 보너스당첨금() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(numbers);
        Integer bonusNum = 6;
        WinningLotto winningLotto = new WinningLotto(lotto,bonusNum);
        WinningLottoGroup winningLottoGroup =lottoGroup.getCombineLottos(winningLotto);
        int sum = winningLottoGroup.getTotalReward();
        assertThat(sum).isEqualTo(3 * (LottoRank.SECOND_PRICE.getPriceRewards()));
    }

    @Test
    public void 보너스통계출력하기() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(numbers);
        Integer bonusNum = 6;
        WinningLotto winningLotto = new WinningLotto(lotto,bonusNum);
        WinningLottoGroup winningLottoGroup =  lottoGroup.getCombineLottos(winningLotto) ;

        for (LottoRank rank : LottoRank.values()) {
            int lottoCount = winningLottoGroup.getCombineNumbers(rank);

            ResultView.printCombineCurrent(rank);
            ResultView.printCombineCount(lottoCount);
        }
    }
}
