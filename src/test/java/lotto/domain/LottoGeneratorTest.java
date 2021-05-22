package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    private Money money;
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        money = new Money(5000);
        lottoGenerator = new LottoGenerator(new PurchaseInformation(money, 0));
    }

    @DisplayName("구매한 로또를 리턴한다")
    @Test
    void generatePurchasedLottos() {
        assertThat(lottoGenerator.getPurchasedLottos().size()).isEqualTo(5);
    }

}
