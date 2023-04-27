package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step2.domain.LotteryWin;
import step2.domain.Lotto;
import step2.domain.WinningNumbers;
import step2.utils.Profit;

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
            lotteryWin = new LotteryWin(new WinningNumbers(winningNumbers));
        }

        @DisplayName("당첨 번호와 3개가 일치하는 경우를 나타낼 수 있다.")
        @Test
        void test6() throws Exception {

            List<Integer> lotto = List.of(1, 2, 3, 11, 12, 13);
            this.lottoList.add(new Lotto(lotto));

            lotteryWin.confirm(this.lottoList);
            Map<Integer, Integer> count = lotteryWin.getResult();

            assertThat(count).containsEntry(3, 1);
        }

        @DisplayName("당첨 번호와 4개가 일치하는 경우를 나타낼 수 있다.")
        @Test
        void test7() throws Exception {
            List<Integer> lotto = List.of(1, 2, 3, 4, 8, 9);
            this.lottoList.add(new Lotto(lotto));

            lotteryWin.confirm(this.lottoList);
            Map<Integer, Integer> count = lotteryWin.getResult();

            assertThat(count).containsEntry(4, 1);
        }

        @DisplayName("당첨 번호와 5개가 일치하는 경우를 나타낼 수 있다.")
        @Test
        void test8() throws Exception {
            List<Integer> lotto = List.of(1, 2, 3, 4, 5, 9);
            this.lottoList.add(new Lotto(lotto));

            lotteryWin.confirm(this.lottoList);
            Map<Integer, Integer> count = lotteryWin.getResult();

            assertThat(count).containsEntry(5, 1);
        }

        @DisplayName("당첨 번호와 6개가 일치하는 경우를 나타낼 수 있다.")
        @Test
        void test9() throws Exception {
            List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
            this.lottoList.add(new Lotto(lotto));

            lotteryWin.confirm(this.lottoList);
            Map<Integer, Integer> count = lotteryWin.getResult();

            assertThat(count).containsEntry(6, 1);
        }
    }

    @Nested
    @DisplayName("로또를 여러 장 구입하는 경우")
    class Lotto_Many {

        private List<Lotto> lottoList;
        private LotteryWin lotteryWin;

        @BeforeEach
        void setUpEach(){
            lottoList = getLottoList();
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            lotteryWin = new LotteryWin(new WinningNumbers(winningNumbers));
        }
        @DisplayName("일치하는 경우를 모두 나타낼 수 있다.")
        @Test
        void test1() throws Exception {

            lotteryWin.confirm(this.lottoList);
            Map<Integer, Integer> count = lotteryWin.getResult();

            assertThat(count).containsEntry(3, 1)
                .containsEntry(4, 1)
                .containsEntry(5, 1)
                .containsEntry(6, 1);
        }

        @DisplayName("수익률과 당첨 금액을 나타낼 수 있다.")
        @Test
        void test2() throws Exception {
           lotteryWin.confirm(lottoList);
            int winningAmount = lotteryWin.getWinningAmount();

            String rateOfReturn = Profit.getRateOfReturn(5000, winningAmount);

            assertThat(winningAmount).isEqualTo(2001555000);
            assertThat(rateOfReturn).isEqualTo("400311.00");
        }

        private List<Lotto> getLottoList() {
            List<Lotto> lottoList = new ArrayList<>();

            List<Integer> match3 = List.of(1, 2, 3, 7, 8, 9);
            List<Integer> match4 = List.of(1, 2, 3, 4, 33, 22);
            List<Integer> match5 = List.of(1, 2, 3, 4, 5, 22);
            List<Integer> match6 = List.of(1, 2, 3, 4, 5, 6);
            List<Integer> match0 = List.of(11, 12, 33, 34, 44, 45);

            lottoList.add(new Lotto(match3));
            lottoList.add(new Lotto(match4));
            lottoList.add(new Lotto(match5));
            lottoList.add(new Lotto(match6));
            lottoList.add(new Lotto(match0));

            return lottoList;
        }
    }
}
