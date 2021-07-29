package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @DisplayName("1-45 범위를 벗어나면 에러")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void validateValue(int value){
        assertThatThrownBy(()->new LottoNumber(value)).isInstanceOf(IllegalArgumentException.class);
    }
}