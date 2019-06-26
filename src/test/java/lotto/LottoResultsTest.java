package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultsTest {
    private List<Lotto> lottos;

    @BeforeEach
    public void setUp() {
        LottoFactory lottoFactory = new LottoFactory(14_000);
        this.lottos = lottoFactory.createLottos();
    }

    @DisplayName("인자가 1~6이 아닌 경우 예외를 발생합니다.")
    @ParameterizedTest
    @ValueSource(ints={-1,0,7,8})
    public void testInvokeException(int fitCount) {
        LottoResults lottoResults = new LottoResults("1,2,3,4,5,6", lottos);

        assertThatThrownBy(()-> lottoResults.countLotteryOf(fitCount))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("로또를 한개 구입하고 3개의 숫자를 맞추었을때의 수익률이 일치하는지 검사합니다.")
    @Test
    public void testIncomeRate() {
        Lotto lotto = lottos.get(0);
        List<Integer> rottoNumbers = lotto.getNumbers();

        String lotteryNumbersString = rottoNumbers.get(0) +","+rottoNumbers.get(1)+","+rottoNumbers.get(2)+",46,46,46";
        LottoResults lottoResults = new LottoResults(lotteryNumbersString, Collections.singletonList(lotto));

        double expectedIncomeRate = getExpectedIncomeRate(1, 3);
        assertThat(lottoResults.getIncomeRate()).isEqualTo(expectedIncomeRate);
    }

    private double getExpectedIncomeRate(int countOfLotto, int fitCount) {
        float purchaseAmounts = LottoFactory.SINGLE_LOTTO_AMOUNT * countOfLotto;

        LottoAmount lottoAmount = LottoAmount.getByFitCount(fitCount);
        float rottoAmountValue = lottoAmount.getAmount();

        float expectedIncomeRate =  rottoAmountValue / purchaseAmounts;
        String expectedIncomeRateString = String.format("%.2f", expectedIncomeRate);

        return Double.parseDouble(expectedIncomeRateString);
    }
}
