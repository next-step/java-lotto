package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        this.lottoService = new LottoService();
    }

    @DisplayName("Money를 넘기면 1000원짜리 로또를 몇개 구입했는지 반환한다.")
    @Test
    void lotto_purchase_count() {
        assertThat(lottoService.purchaseNumber(new Money(3000))).isEqualTo(3);
    }
}
