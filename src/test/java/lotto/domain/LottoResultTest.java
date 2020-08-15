package lotto.domain;

import common.StringResources;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    public void setup() {

        LottoResultNumber lottoResultNumber = new LottoResultNumber(
                new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)));

        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            lottoNumberList.add(new LottoNumber(new Ticket(
                    Arrays.asList(i, i + 1, i + 2, i + 3, i + 4, i + 5)
            )));
        }

        lottoResult = new LottoResult(10000, lottoNumberList, lottoResultNumber);
    }

    @Test
    void lottoResultTest() {
        assertEquals(lottoResult.getWinningCount(3), 0);
        assertEquals(lottoResult.getWinningCount(4), 1);
        assertEquals(lottoResult.getWinningCount(5), 1);
        assertEquals(lottoResult.getWinningCount(6), 1);
    }

    @Test
    void wrongWinningCount() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            lottoResult.getWinningCount(-1)
        ).withMessage(StringResources.ERR_WRONG_RANGE_RESULT_NUMBER);

        assertThatIllegalArgumentException().isThrownBy(() ->
                lottoResult.getWinningCount(7)
        ).withMessage(StringResources.ERR_WRONG_RANGE_RESULT_NUMBER);
    }

    @Test
    public void earningsRateTest() {
        assertEquals(200155, lottoResult.getEarningsRate());
    }
}
