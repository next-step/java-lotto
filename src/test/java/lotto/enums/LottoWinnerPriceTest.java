package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinnerPriceTest {

    @ParameterizedTest
    @DisplayName("맞은 개수에 따라 상금을 반환한다.")
    @CsvSource(value = {"6,2000000000", "5,1500000", "4,50000", "3,5000"})
    void 상금_반환(int matchCount, int price) {
        assertThat(LottoWinnerPrice.getPrice(matchCount)).isEqualTo(price);
    }

    @Test
    @DisplayName("list 조회를 하면 등록된 상의 개수만큼 반환한다.")
    void enum_개수_반환() {
        assertThat(LottoWinnerPrice.getLottoWinnerPrice()).hasSize(4);
    }
}