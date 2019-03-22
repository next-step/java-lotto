package domain;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {
    private static final int totalAmount = 1_000;
    private static final int[] inputWinningNumbers = {1,3,5,6,7,8};
    private LottoResult lottoResult;
    private Price price;

    @Before
    public void setUp() {
        price = new Price(totalAmount);

        //3장 중 1장만 1등으로 되도록 확인.
        List<Integer> lottoNumbers= Arrays.asList(1,3,5,6,7,8);
        List<Integer> lottoNumbers2= Arrays.asList(9,10,11,12,13,14);
        List<Integer> lottoNumbers3= Arrays.asList(9,10,11,12,13,14);

        List<Lotto> lottos = Arrays.asList(Lotto.generateLotto(lottoNumbers)
                                        , Lotto.generateLotto(lottoNumbers2)
                                        , Lotto.generateLotto(lottoNumbers3));

        lottoResult = new LottoResult(lottos, inputWinningNumbers);
    }

    @Test
    public void LOTTO_RESULT_() {
        lottoResult.calculateBenefit(price);
        assertThat(lottoResult.getBenefitRate())
                .isEqualTo(LottoResultStatus.getWinnersPriceByStatus(1, LottoResultStatus.WINNING_NUM_6).divide(BigDecimal.valueOf(totalAmount), 2, RoundingMode.HALF_UP));
    }
}
