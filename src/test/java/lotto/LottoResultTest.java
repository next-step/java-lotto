package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoResultTest {

    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult(Arrays.asList(3, 4, 5, 6, 5));
    }

    @Test
    void resultCountSummary() {
        Map<Integer, List<Integer>> result = lottoResult.resultSummary();
        assertThat(result.get(5).size()).isEqualTo(2);
    }

    @Test
    void rateOfReturn() {
        HashMap<Integer, List<Integer>> param = new HashMap<>();
        param.put(3, Collections.singletonList(1));
        int result = lottoResult.rateOfReturn(3, param);
        assertThat(result).isEqualTo(5000);
    }

    @Test
    void rateOfReturnAll() {
        int result = lottoResult.rateOfReturnAll();
        assertThat(result).isEqualTo(2003055000);
    }

}