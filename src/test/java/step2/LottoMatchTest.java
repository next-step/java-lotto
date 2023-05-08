package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step2.domain.LotteryWin;
import step2.domain.Lotto;
import step2.domain.ManualLotto;
import step2.domain.PurchasedLotto;
import step2.domain.Ranking;
import step2.domain.WinningNumbers;

class LottoMatchTest {

    @DisplayName("매칭 번호가 2개 이하인 경우 MISSING이 출력된다.")
    @Test
    void test1() throws Exception {
        Ranking ranking = Ranking.match2(2, false);
        assertThat(ranking).isEqualTo(Ranking.MISSING);
    }

    @DisplayName("3등을 나타낼 수 있다.")
    @Test
    void test2() throws Exception {
        Ranking ranking = Ranking.match2(5, false);
        assertThat(ranking).isEqualTo(Ranking.THIRD);
    }

    @DisplayName("2등을 나타낼 수 있다.")
    @Test
    void test3() throws Exception {
        Ranking ranking = Ranking.match2(5, true);
        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @Nested
    @DisplayName("로또 한 장을 구매했을 경우")
    class Lotto_One {

        private LotteryWin lotteryWin;
        private List<Lotto> lottoList;

        @BeforeEach
        void setUpEach() {
            lottoList = new ArrayList<>();
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            lotteryWin = new LotteryWin(new WinningNumbers(winningNumbers), 22);
        }

        @DisplayName("매칭 번호가 2개 이하일 경우 당첨금은 0이다.")
        @Test
        void test3() throws Exception {
            List<Integer> numbers = List.of(1, 2, 7, 8, 9, 10);
            Lotto lotto = new Lotto(numbers);
            this.lottoList.add(lotto);

            PurchasedLotto purchasedLotto = lotteryWin.confirm2(new PurchasedLotto(this.lottoList));

            assertThat(purchasedLotto.get()).containsOnly(new Lotto(numbers, Ranking.MISSING));
        }

        @DisplayName("보너스 번호를 제외한 등수을 나타낼 수 있다(3등).")
        @Test
        void test11() throws Exception {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 44);
            Lotto lotto = new Lotto(numbers);
            this.lottoList.add(lotto);

            PurchasedLotto purchasedLotto = lotteryWin.confirm2(new PurchasedLotto(this.lottoList));

            assertThat(purchasedLotto.get()).containsOnly(new Lotto(numbers, Ranking.THIRD));
        }

        @DisplayName("보너스 번호를 포함하는 등수 나타낼 수 있다(2등).")
        @Test
        void test10() throws Exception {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 22);
            Lotto lotto = new Lotto(numbers);
            this.lottoList.add(lotto);

            PurchasedLotto purchasedLotto = lotteryWin.confirm2(new PurchasedLotto(this.lottoList));
            assertThat(purchasedLotto.get()).containsOnly(new Lotto(numbers, Ranking.SECOND));
        }
    }

    @Nested
    @DisplayName("로또를 여러 장 구입하는 경우")
    class Lotto_Many {

        private PurchasedLotto unrankedPurchasedLotto;
        private LotteryWin lotteryWin;

        @BeforeEach
        void setUpEach() {
            unrankedPurchasedLotto = new PurchasedLotto(getLottoList());
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            lotteryWin = new LotteryWin(new WinningNumbers(winningNumbers), 22);
        }


        @DisplayName("수익률을 나타낼 수 있다(보너스 숫자 포함).")
        @Test
        void test2() throws Exception {
            PurchasedLotto purchasedLotto = lotteryWin.confirm2(unrankedPurchasedLotto);

            String rateOfReturn = purchasedLotto.getRateOfReturn(5000);

            assertThat(rateOfReturn).isEqualTo("406311.00");
        }

        @DisplayName("수동 입력을 포함한 수익률을 나타낼 수 있다(보너스 숫자 포함).")
        @Test
        void test3() throws Exception {
            unrankedPurchasedLotto.addManualLotto(
                new ManualLotto(List.of("1,2,3,7,8,9"))
            );

            PurchasedLotto purchasedLotto = lotteryWin.confirm2(unrankedPurchasedLotto);
            String rateOfReturn = purchasedLotto.getRateOfReturn(5000);

            assertThat(rateOfReturn).isEqualTo("406312.00");
        }


        private List<Lotto> getLottoList() {
            List<Lotto> lottoList = new ArrayList<>();

            List<Integer> match3 = List.of(1, 2, 3, 7, 8, 9);
            List<Integer> match4 = List.of(1, 2, 3, 4, 33, 44);
            List<Integer> match5 = List.of(1, 2, 3, 4, 5, 44);
            List<Integer> match6 = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> match0 = List.of(11, 12, 33, 34, 44, 45);
            List<Integer> matchBonus = List.of(1, 2, 3, 4, 5, 22);

            lottoList.add(new Lotto(match3));
            lottoList.add(new Lotto(match4));
            lottoList.add(new Lotto(match5));
            lottoList.add(new Lotto(match6));
            lottoList.add(new Lotto(match0));
            lottoList.add(new Lotto(matchBonus));

            return lottoList;
        }
    }
}
