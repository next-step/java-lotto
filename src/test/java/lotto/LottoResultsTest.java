package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultsTest {
    private List<Lotto> lottos;

    @BeforeEach
    public void setUp() {
        LottoMoney lottoMoney = LottoMoney.of(14_000);
        LottoFactory lottoFactory = new LottoFactory(lottoMoney);
        this.lottos = lottoFactory.createLottos();
    }

    @DisplayName("로또를 한개 구입하고 3개의 숫자를 맞추었을때의 수익률이 일치하는지 검사합니다.")
    @Test
    public void testIncomeRate() {
        Lotto lotto = lottos.get(0);
        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        String lotteryNumbersString = lottoNumbers.get(0) +","+lottoNumbers.get(1)+","+lottoNumbers.get(2)+",46,46,46";
        LottoResults lottoResults = new LottoResults(lotteryNumbersString, Collections.singletonList(lotto));

        double expectedIncomeRate = getExpectedIncomeRate(1, 3);
        assertThat(lottoResults.getIncomeRate()).isEqualTo(expectedIncomeRate);
    }

    private double getExpectedIncomeRate(int countOfLotto, int countOfMatch) {
        float purchaseAmounts = LottoFactory.SINGLE_LOTTO_MONEY * countOfLotto;

        LottoRank lottoRank = LottoRank.valueOf(countOfMatch);
        float lottoWinningMoney = lottoRank.getWinningMoney();

        float expectedIncomeRate =  lottoWinningMoney / purchaseAmounts;
        String expectedIncomeRateString = String.format("%.2f", expectedIncomeRate);

        return Double.parseDouble(expectedIncomeRateString);
    }
}
