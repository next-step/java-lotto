package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPurchaseInfoTest {
    @Test
    void 로또구매정보_생성() {
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(1, 3);
        assertThat(lottoPurchaseInfo).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"-1, 2", "2, -1"})
    void 로또구매정보_검증(int manualNumber, int autoNumber) {
        assertThatThrownBy(() -> new LottoPurchaseInfo(manualNumber, autoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}