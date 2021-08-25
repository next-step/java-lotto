package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchasingMachineTest {

    @Test
    @DisplayName("자동번호 로또 갯수 확인")
    void buyAutomaticLotto() {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        List<Lotto> ticket = lottoPurchasingMachine.buyAutomaticLotto(13500);
        List<Lotto> ticket2 = lottoPurchasingMachine.buyAutomaticLotto(14000);

        assertThat(ticket.size()).isEqualTo(13);
        assertThat(ticket2.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("수동번호 로또 갯수 확인")
    void buyLottoManualNumber() {
        String[] manualNumbers = new String[] {"1,2,3,4,5,6","11,12,13,14,15,16", "21,22,23,24,25,26"};
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();

        List<Lotto> lottoList = lottoPurchasingMachine.buyManualLotto(manualNumbers);

        assertThat(lottoList.size()).isEqualTo(3);
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

    @Test
    @DisplayName("보너스 번호 중복체크")
    void checkBonusNumber() {
        LottoPurchasingMachine lottoPurchasingMachine = new LottoPurchasingMachine();
        assertThatThrownBy(() -> {
            lottoPurchasingMachine.checkLottoList(lottoPurchasingMachine.buyManualLotto(new String[] {"1,2,3,4,5,6"}), Arrays.asList(11,12,23,24,5,6), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}