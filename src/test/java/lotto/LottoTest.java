package lotto;
//
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.RepeatedTest;
//import org.junit.jupiter.api.RepetitionInfo;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//public class LottoTest {
//
//    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.")
//    @Test
//    void buyLottoTest() {
//        LottoPurchase lottoPurchase = new LottoPurchase();
//        int money = 14000;
//        assertThat(lottoPurchase.buyLotto(money)).isEqualTo(14);
//    }
//
//    @DisplayName("로또 공은 1~45까지이다.")
//    @RepeatedTest(value = 45)
//    void lottoNumbersTest(RepetitionInfo repetitionInfo) {
//        Lotto lotto = new Lotto();
//        assertThat(lotto.createLottoNumbers()).contains(repetitionInfo.getCurrentRepetition());
//    }
//
//    @DisplayName("로또번호는 숫자 6개로 이루어져있다.")
//    @Test
//    void lottoSizeTest() {
//        Lotto lotto = new Lotto();
//        lotto.createLottoNumbers();
//
//        assertThat(lotto.chooseLottoNumbers().size()).isEqualTo(6);
//    }
//
//    @DisplayName("로또번호는 오름차순으로 정렬된다.")
//    @Test
//    void lottoSortTest() {
//        Lotto lotto = new Lotto();
//        lotto.createLottoNumbers();
//
//        assertThat(lotto.sortLottoNumbers()).isSorted();
//    }
//}
