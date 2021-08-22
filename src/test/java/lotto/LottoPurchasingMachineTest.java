package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchasingMachineTest {

    @Test
    @DisplayName("로또 구매 후 구입갯수 확인")
    void buyLotto() {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        List<Lotto> ticket = lottoPurchasingMachine.buyLotto(13500);
        List<Lotto> ticket2 = lottoPurchasingMachine.buyLotto(14000);

        assertThat(ticket.size()).isEqualTo(13);
        assertThat(ticket2.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("당첨된 로또가 몇개 인지 확인")
    void checkLottoList() {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        Lotto firstPlace = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto secondPlace = new Lotto(Arrays.asList(1,2,3,4,5,11));
        Lotto thirdPlace = new Lotto(Arrays.asList(1,2,3,4,11,12));
        Lotto fourthPlace = new Lotto(Arrays.asList(1,2,3,11,12,13));
        Lotto fourthPlace2 = new Lotto(Arrays.asList(1,2,3,13,17,26));

        int bonusNumber = 11;

        List<Integer> result = lottoPurchasingMachine.checkLottoList(Arrays.asList(fourthPlace, thirdPlace, secondPlace, firstPlace, fourthPlace2), Arrays.asList(1,2,3,4,5,6), bonusNumber);

        assertThat(result.get(Rank.FIRST.getPlaceIndex())).isEqualTo(1);
        assertThat(result.get(Rank.SECOND_BONUS.getPlaceIndex())).isEqualTo(1);
        assertThat(result.get(Rank.SECOND.getPlaceIndex())).isEqualTo(0);
        assertThat(result.get(Rank.THIRD.getPlaceIndex())).isEqualTo(1);
        assertThat(result.get(Rank.FOURTH.getPlaceIndex())).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 수익률 확인")
    void findYield() {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        double yield = lottoPurchasingMachine.findYield(Arrays.asList(0, 0, 0, 0, 1, 0), 14000);

        assertThat(yield).isEqualTo(0.35);
    }
}