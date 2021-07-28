package lotto.domain;

import lotto.exception.OutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @DisplayName("ctor Test")
    @ValueSource(ints = {
            1, 6
    })
    @ParameterizedTest
    public void ctorTest(int value) {
        new LottoRank(value);
    }

    @DisplayName("ctor Test - OutOfRangeException")
    @ValueSource(ints = {
            0, 7
    })
    @ParameterizedTest
    public void ctorTest_OutOfRangeException(int value) {
        assertThatThrownBy(() ->
            ctorTest(value)
        ).isInstanceOf(OutOfRangeException.class);
    }
}