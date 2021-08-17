package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchasingMachineTest {

    @Test
    void buyLotto() {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        List<Lotto> ticket = lottoPurchasingMachine.buyLotto(13500);
        List<Lotto> ticket2 = lottoPurchasingMachine.buyLotto(14000);

        assertThat(ticket.size()).isEqualTo(13);
        assertThat(ticket2.size()).isEqualTo(14);
    }

    @Test
    void checkLottoList() {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        Lotto firstPlace = new Lotto(new Integer[] {1,2,3,4,5,6});
        Lotto secondPlace = new Lotto(new Integer[] {1,2,3,4,5,11});
        Lotto thirdPlace = new Lotto(new Integer[] {1,2,3,4,11,12});
        Lotto fourthPlace = new Lotto(new Integer[] {1,2,3,11,12,13});
        Lotto fourthPlace2 = new Lotto(new Integer[] {1,2,3,13,17,26});
        Integer[] result = lottoPurchasingMachine.checkLottoList(Arrays.asList(fourthPlace, thirdPlace, secondPlace, firstPlace, fourthPlace2), new Integer[] {1,2,3,4,5,6});

        assertThat(result[LottoPurchasingMachine.FIRST_PLACE_INDEX]).isEqualTo(1);
        assertThat(result[LottoPurchasingMachine.SECOND_PLACE_INDEX]).isEqualTo(1);
        assertThat(result[LottoPurchasingMachine.THIRD_PLACE_INDEX]).isEqualTo(1);
        assertThat(result[LottoPurchasingMachine.FOURTH_PLACE_INDEX]).isEqualTo(2);
    }

    @Test
    void getYield() {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        double yield = lottoPurchasingMachine.getYield(new Integer[] {0, 0, 0, 1}, 14000);
        System.out.println(yield);

        assertThat(yield).isEqualTo(0.35);
    }
}