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

public class LottoMatchTest {

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

        @DisplayName("당첨 번호와 3개가 일치하는 경우를 나타낼 수 있다.")
        @Test
        void test6() throws Exception {

            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 11, 12, 13));

            Lotto lotto = new Lotto(numbers);
            this.lottoList.add(lotto);

            lotteryWin.confirm(new PurchasedLotto(this.lottoList));

            assertThat(lotto.getPrizedMoney()).isEqualTo(Ranking.FIFTH.getWinningMoney());
        }

        @DisplayName("당첨 번호와 4개가 일치하는 경우를 나타낼 수 있다.")
        @Test
        void test7() throws Exception {
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 8, 9));
            Lotto lotto = new Lotto(numbers);
            this.lottoList.add(lotto);

            lotteryWin.confirm(new PurchasedLotto(this.lottoList));

            assertThat(lotto.getPrizedMoney()).isEqualTo(Ranking.FOURTH.getWinningMoney());
        }

        @DisplayName("당첨 번호와 5개가 일치하는 경우를 나타낼 수 있다.")
        @Test
        void test8() throws Exception {
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 9));
            Lotto lotto = new Lotto(numbers);
            this.lottoList.add(lotto);

            lotteryWin.confirm(new PurchasedLotto(this.lottoList));

            assertThat(lotto.getPrizedMoney()).isEqualTo(Ranking.THIRD.getWinningMoney());
        }

        @DisplayName("당첨 번호와 6개가 일치하는 경우를 나타낼 수 있다.")
        @Test
        void test9() throws Exception {
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
            Lotto lotto = new Lotto(numbers);
            this.lottoList.add(lotto);

            lotteryWin.confirm(new PurchasedLotto(this.lottoList));

            assertThat(lotto.getPrizedMoney()).isEqualTo(Ranking.FIRST.getWinningMoney());
        }

        @DisplayName("3등을 나타낼 수 있다.")
        @Test
        void test11() throws Exception {
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 44));
            Lotto lotto = new Lotto(numbers);
            this.lottoList.add(lotto);

            lotteryWin.confirm(new PurchasedLotto(this.lottoList));

            assertThat(lotto.getPrizedMoney()).isEqualTo(Ranking.THIRD.getWinningMoney());
        }

        @DisplayName("2등을 나타낼 수 있다.")
        @Test
        void test10() throws Exception {
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 22));
            Lotto lotto = new Lotto(numbers);
            this.lottoList.add(lotto);

            lotteryWin.confirm(new PurchasedLotto(this.lottoList));

            assertThat(lotto.getPrizedMoney()).isEqualTo(Ranking.SECOND.getWinningMoney());
        }
    }

    @Nested
    @DisplayName("로또를 여러 장 구입하는 경우")
    class Lotto_Many {

        private PurchasedLotto purchasedLotto;
        private LotteryWin lotteryWin;

        @BeforeEach
        void setUpEach() {
            purchasedLotto = new PurchasedLotto(getLottoList());
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            lotteryWin = new LotteryWin(new WinningNumbers(winningNumbers), 22);
        }


        @DisplayName("수익률을 나타낼 수 있다(보너스 숫자 포함).")
        @Test
        void test2() throws Exception {
            lotteryWin.confirm(purchasedLotto);

            String rateOfReturn = purchasedLotto.getRateOfReturn(5000);

            assertThat(rateOfReturn).isEqualTo("406311.00");
        }

        @DisplayName("수동 입력을 포함한 수익률을 나타낼 수 있다(보너스 숫자 포함).")
        @Test
        void test3() throws Exception {
            purchasedLotto.addManualLottos(
                new ManualLotto(new ArrayList<>(List.of("1,2,3,7,8,9")))
            );

            lotteryWin.confirm(purchasedLotto);


            String rateOfReturn = purchasedLotto.getRateOfReturn(5000);

            assertThat(rateOfReturn).isEqualTo("406312.00");
        }


        private List<Lotto> getLottoList() {
            List<Lotto> lottoList = new ArrayList<>();

            List<Integer> match3 = new ArrayList<>(List.of(1, 2, 3, 7, 8, 9));
            List<Integer> match4 = new ArrayList<>(List.of(1, 2, 3, 4, 33, 44));
            List<Integer> match5 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 44));
            List<Integer> match6 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
            List<Integer> match0 = new ArrayList<>(List.of(11, 12, 33, 34, 44, 45));
            List<Integer> matchBonus = new ArrayList<>(List.of(1, 2, 3, 4, 5, 22));

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
