package com.cheolhyeonpark.lotto.domain;

import com.cheolhyeonpark.lotto.domain.number.Numbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AmountTest {

    @Test
    void getAutoCount() {
        Amount amount = new Amount(2000);
        Count count = new Count(1);

        Count result = amount.getAutoCount(count);

        assertThat(result.getCount()).isEqualTo(1);
    }

    @Test
    void throwExceptionWhenWrongCount() {
        assertThatThrownBy(() -> new Amount(0))
                .hasMessage("Not enough money.");
    }
}