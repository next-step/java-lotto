package lotto.domain;

import lotto.exception.OutOfSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoListTest {
    @DisplayName("newAuto Test")
    @ValueSource(ints = {
            10, 100
    })
    @ParameterizedTest
    void newAutoTest(int size) {
        assertThat(
                LottoList.newAuto(size).size()
        ).isEqualTo(size);
    }

    @DisplayName("newAuto Test - OutOfSizeException")
    @ValueSource(ints = {
            0, -1
    })
    @ParameterizedTest
    void newAutoTest_OutOfSizeException(int size) {
        assertThatThrownBy(() -> newAutoTest(size))
                .isInstanceOf(OutOfSizeException.class);
    }

    @ValueSource(ints = {
            10, 100
    })
    @DisplayName("statistics Test")
    @ParameterizedTest
    void statisticsTest(int size) {
        assertThat(
                LottoList.newAuto(size)
                        .statistics(Lotto.newAuto())
                        .totalSize()
        ).isEqualTo(size);
    }
}