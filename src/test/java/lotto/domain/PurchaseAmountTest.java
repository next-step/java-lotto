package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 999})
    void 천원_미만이면_예외가_발생한다(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(amount));
    }

    @ParameterizedTest
    @CsvSource({
            "1000,  1",
            "14000, 14"
    })
    void 구매_가능한_로또_개수를_반환한다(int amount, int expected) {
        assertThat(new PurchaseAmount(amount).getLottoCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "1999,  1",
            "14500, 14"
    })
    void 천원_단위가_아니면_나머지는_버린다(int amount, int expected) {
        assertThat(new PurchaseAmount(amount).getLottoCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "14000, 14000",
            "14500, 14000"
    })
    void 실제_사용_금액을_반환한다(int amount, int expected) {
        assertThat(new PurchaseAmount(amount).getSpentAmount()).isEqualTo(expected);
    }
}
