package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankTest {

    @Test
    @DisplayName("생성 테스트")
    void ctor_test() {
        assertThatNoException().isThrownBy(() -> new Bank(new EnumMap<>(Map.of(Rank.FOURTH, 1))));
    }

    @Test
    @DisplayName("수익률 계산")
    void yield_calculate_test() {
        //given
        Bank bank = new Bank(new EnumMap<>(Map.of(Rank.FIFTH, 1)));

        //when
        double yield = bank.yield(1000);

        //then
        assertThat(yield).isEqualTo(5);
    }


}