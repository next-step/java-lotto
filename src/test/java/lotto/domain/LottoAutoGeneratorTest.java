package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoGeneratorTest {

    private Money money;
    private LottoAutoGenerator lottoAutoGenerator;

    @BeforeEach
    void setUp() {
        money = new Money(5000);
        lottoAutoGenerator = new LottoAutoGenerator(new PurchaseInformation(money, 0));
    }

    @DisplayName("구매한 로또를 리턴한다")
    @Test
    void generatePurchasedLottos() {
        assertThat(lottoAutoGenerator.generateLottos().size()).isEqualTo(5);
    }
}
