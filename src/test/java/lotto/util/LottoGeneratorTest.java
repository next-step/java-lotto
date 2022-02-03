package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("구매금액을 통해 로또 개수를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"14000,14", "2000,2"})
    void getLottoQuantity(final int purchasePrice, final int expected) {
        assertThat(lottoGenerator.getLottoQuantity(purchasePrice)).isSameAs(expected);
    }

    @Test
    @DisplayName("구매금액이 1000원 미만이면 예외처리해야 한다.")
    void getLottoQuantity() {
        final int invalidPrice = 900;
        assertThatThrownBy(() -> lottoGenerator.getLottoQuantity(invalidPrice))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
    }
}
