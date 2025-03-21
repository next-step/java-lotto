package lotto.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoShopTest {

    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "14000, 14", "123123, 123"})
    public void buyTest(int money, int expected) {
        List<Lotto> actual
            = new LottoShop().buy(money);

        assertThat(actual.size()).isEqualTo(expected);
    }

}
