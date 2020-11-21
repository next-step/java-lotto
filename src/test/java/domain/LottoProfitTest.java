package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitTest {

    LottoProfit lottoProfit;

    @Test
    @DisplayName("로또 수익 클래스 생성 테스트")
    void createLottoProfitTest() {
        double profit = 0.35;
        lottoProfit = new LottoProfit(profit);

        assertThat(lottoProfit.getProfit()).isEqualTo(profit);
    }

    @Test
    @DisplayName("수익률 계산 기능")
    void calculateProfitTest() {
        LottoInfo lottoInfo = LottoInfo.of(4000, 4);

        String winning = "1, 2, 3, 4, 5, 6";
        LottoNumbers winningNumbers = new LottoNumbers()
                .createWinningNumbers(winning);

        Lottos lottos = initTestLottos();
        Map<Integer, Integer> lottoStatistics = lottos.compileLottoStatistics(winningNumbers);

        assertThat(LottoProfit.calculateProfit(lottoStatistics, lottoInfo.getPrice()).getProfit())
                .isEqualTo(
                        (double) (LottoPrize.valueOf(3)*2
                                + LottoPrize.valueOf(6))
                                / (double) lottoInfo.getPrice()
                );
    }

    private Lottos initTestLottos() {
        String test1 = "1, 2, 3, 4, 5, 6";
        LottoNumbers testNumber1 = new LottoNumbers()
                .createWinningNumbers(test1);
        Lotto testLotto1 = new Lotto(testNumber1);

        String test2 = "1, 7, 8, 9, 10, 11";
        LottoNumbers testNumber2 = new LottoNumbers()
                .createWinningNumbers(test2);
        Lotto testLotto2 = new Lotto(testNumber2);

        String test3 = "1, 2, 3, 9, 10, 11";
        LottoNumbers testNumber3 = new LottoNumbers()
                .createWinningNumbers(test3);
        Lotto testLotto3 = new Lotto(testNumber3);

        String test4 = "1, 2, 3, 9, 10, 11";
        LottoNumbers testNumber4 = new LottoNumbers()
                .createWinningNumbers(test4);
        Lotto testLotto4 = new Lotto(testNumber4);


        return Lottos.from(Arrays.asList(testLotto1, testLotto2, testLotto3, testLotto4));
    }
}
