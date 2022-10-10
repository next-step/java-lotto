package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void profitRatio() {
        List<Integer> correctNumbers = List.of(0, 0, 0, 4, 2, 1);
        LottoResult lottoResult = new LottoResult(correctNumbers);

        double ratio = lottoResult.retrieveProfitRatio(1000);
        Assertions.assertThat(ratio).isEqualTo(50.0d);
    }
}