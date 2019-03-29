package domain;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {
    private static final int TOTAL_AMOUNT = 1_000;
    private static final String[] INPUT_WINNING_NUMBERS = new String[]{"1","3","5","6","7","8"};
    private static final int INPUT_BONUs_NUMBER = 9;
    private LottoResult lottoResult;
    private Money money;

    @Before
    public void setUp() {
        money = new Money(TOTAL_AMOUNT);

        //3장 중 1장만 1등으로 되도록 확인.
        List<Integer> lottoNumbers= Arrays.asList(1,3,5,6,7,8);
        List<Integer> lottoNumbers2= Arrays.asList(9,10,11,12,13,14);
        List<Integer> lottoNumbers3= Arrays.asList(9,10,11,12,13,14);

        LottoNumbers numbers1 = LottoNumbers.createInstance(lottoNumbers);
        LottoNumbers numbers2 = LottoNumbers.createInstance(lottoNumbers2);
        LottoNumbers numbers3 = LottoNumbers.createInstance(lottoNumbers3);
        List<Lotto> lottos = Arrays.asList(new Lotto(numbers1), new Lotto(numbers2), new Lotto(numbers3));

        lottoResult = new LottoResult(lottos, new WinningLotto(INPUT_WINNING_NUMBERS, INPUT_BONUs_NUMBER));
    }

    @Test
    public void 로또_수익률_계산() {
        assertThat(lottoResult.calculateBenefit(money))
                .isEqualTo(LottoResultStatus.getWinnersPriceByStatus(1, LottoResultStatus.WINNING_NUM_6).divide(BigDecimal.valueOf(TOTAL_AMOUNT), 2, RoundingMode.HALF_UP));
    }
}
