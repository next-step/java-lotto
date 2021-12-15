package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AmountTest {
    @Test
    @DisplayName("Amount 객체가 동일한지 확인합니다.")
    void equals() {
        //given
        Amount criteriaAmount = new Amount(1000);
        Amount compareAmount = new Amount(1000);
        //when
        boolean result = criteriaAmount.equals(compareAmount);
        //then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 1234})
    @DisplayName("허용하지 않는 값으로 Amount 생성시 IllegalArgumentException이 발생하는지 확인합니다")
    void illegalArgument(int value) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    new Amount(value);
                }
        );
    }

    @ParameterizedTest
    @CsvSource({"1000,1", "14000,14", "123000,123"})
    @DisplayName("주어진 금액에 따라 로또 장수가 예측한대로 반환되는지 확인한다")
    void lottoPieceCount(int value, int count) {
        //given
        Amount amount = new Amount(value);
        //when
        int lottoPieceCount = amount.lottoPieceCount();
        //then
        assertThat(lottoPieceCount).isEqualTo(count);
    }
}