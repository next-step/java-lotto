package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitTest {
    private final String NUMBER_DELIMITER = ", ";

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
        int bonusNumber = 7;
        LottoInfo lottoInfo = LottoInfo.of(4000, 4);

        String winning = "1, 2, 3, 4, 5, 6";
        LottoNumbers winningNumbers = new LottoNumbers()
                .createLottoNumbers(winning.split(NUMBER_DELIMITER));

        Lottos lottos = initTestLottos();
        Map<Integer, Integer> lottoStatistics = lottos.compileLottoStatistics(winningNumbers, bonusNumber);

        double profit = LottoProfit.calculateProfit(lottoStatistics, lottoInfo.getPrice()).getProfit();
        assertThat(profit)
                .isEqualTo(
                        (double) (LottoPrize.valueOf(5).get(1)*2
                                + LottoPrize.valueOf(3).get(1)
                                + LottoPrize.valueOf(2).get(1)
                                + LottoPrize.valueOf(1).get(1)
                        )
                                / (double) lottoInfo.getPrice()
                );
    }

    private Lottos initTestLottos() {
        String test1 = "1, 2, 3, 4, 5, 6"; // 1등
        LottoNumbers testNumber1 = new LottoNumbers()
                .createLottoNumbers(test1.split(NUMBER_DELIMITER));
        Lotto testLotto1 = new Lotto(testNumber1);

        String test2 = "1, 7, 8, 9, 10, 11"; // X
        LottoNumbers testNumber2 = new LottoNumbers()
                .createLottoNumbers(test2.split(NUMBER_DELIMITER));
        Lotto testLotto2 = new Lotto(testNumber2);

        String test3 = "1, 2, 3, 9, 10, 11"; // 5등
        LottoNumbers testNumber3 = new LottoNumbers()
                .createLottoNumbers(test3.split(NUMBER_DELIMITER));
        Lotto testLotto3 = new Lotto(testNumber3);

        String test4 = "1, 2, 3, 9, 10, 11"; // 5등
        LottoNumbers testNumber4 = new LottoNumbers()
                .createLottoNumbers(test4.split(NUMBER_DELIMITER));
        Lotto testLotto4 = new Lotto(testNumber4);

        String test5 = "1, 2, 3, 4, 5, 7"; // 2등
        LottoNumbers testNumber5 = new LottoNumbers()
                .createLottoNumbers(test5.split(NUMBER_DELIMITER));
        Lotto testLotto5 = new Lotto(testNumber5);

        String test6 = "1, 2, 3, 4, 5, 8"; // 3등
        LottoNumbers testNumber6 = new LottoNumbers()
                .createLottoNumbers(test6.split(NUMBER_DELIMITER));
        Lotto testLotto6 = new Lotto(testNumber6);

        return Lottos.from(Arrays.asList(testLotto1, testLotto2, testLotto3, testLotto4, testLotto5, testLotto6));
    }
}
