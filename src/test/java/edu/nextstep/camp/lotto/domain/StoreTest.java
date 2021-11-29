package edu.nextstep.camp.lotto.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StoreTest {
    @ParameterizedTest(name = "create: {arguments}")
    @CsvSource(value = {"1000,1", "2000,2"}, delimiter = ',')
    public void create(int budget, int expected) {
        assertThat(Store.purchase(budget, AutoLottoGenerator.getInstance()).amount())
                .isEqualTo(expected);
    }

    @ParameterizedTest(name = "create failed by not enough money: {arguments}")
    @ValueSource(ints = {-1000, 0, 999})
    public void createFailedByNotEnoughMoney(int budget) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Store.purchase(budget, AutoLottoGenerator.getInstance()))
                .withMessageContaining("budget must be at least 1000");
    }


    @ParameterizedTest(name = "create failed change exist: {arguments}")
    @ValueSource(ints = {1999, 1001})
    public void createFailedByChaneExist(int budget) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Store.purchase(budget, AutoLottoGenerator.getInstance()))
                .withMessageContaining("budget must be multiple of 1000");
    }
}
