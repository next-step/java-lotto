package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseMethodTest {

    @Test
    @DisplayName("로또 구매 방식 - 자동 횟수 테스트")
    void autoCount_Test(){
        assertThat(new LottoPurchaseMethod(10000, 4).autoCount()).isEqualTo(6);
        assertThat(new LottoPurchaseMethod(20000, 8).autoCount()).isEqualTo(12);
    }

    @ParameterizedTest
    @CsvSource(value = {"900:0", "10000:11"}, delimiter = ':')
    @DisplayName("로또 구매 - 예외 테스트")
    void construct_exception_test(int purchaseMoney, int manualCount) {
        assertThatThrownBy(() -> new LottoPurchaseMethod(purchaseMoney, manualCount))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
