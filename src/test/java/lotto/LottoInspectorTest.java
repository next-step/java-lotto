package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoInspector;
import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoInspectorTest {

    private LottoInspector lottoInspector;

    @BeforeEach
    void setting() {
        this.lottoInspector = new LottoInspector();
        List<Lotto> testLottos = new ArrayList<>();

        Lotto lotto1 = Lotto.manual(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.manual(Arrays.asList(1, 2, 3, 41, 42, 43));
        testLottos.add(lotto1);
        testLottos.add(lotto2);
    }

    @Test
    @DisplayName("수익률 가져오기 테스트")
    void getYieldTest() {
        assertThat(
                this.lottoInspector.getYield(new Money(1000), 5000)
        ).isEqualByComparingTo(new BigDecimal(5));
    }
}
