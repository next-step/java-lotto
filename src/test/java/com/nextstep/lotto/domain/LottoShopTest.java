package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidLottoShopException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {
    @DisplayName("Money를 인자로 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Money money = new Money(10000L);

        assertThat(new LottoShop(money)).isNotNull();
    }

    @DisplayName("1000원 미만의 돈으로 객체 생성 시도시 예외 발생")
    @ParameterizedTest
    @ValueSource(longs = { 0, 111, 999 })
    void createFailTest(long notEnoughValue) {
        Money money = new Money(notEnoughValue);

        assertThatThrownBy(() -> new LottoShop(money)).isInstanceOf(InvalidLottoShopException.class);
    }
}