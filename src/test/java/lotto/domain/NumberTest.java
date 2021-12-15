package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {
    @ParameterizedTest
    @CsvSource({"-1,0", "0,0", "100,100"})
    @DisplayName("비 정상적인 값으로 Number이 생성될때 illegalArgumentException이 발생하는지 확인합니다.")
    void illegalArgument(int number, int position) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {new Number(number, new Position(position));}
        );
    }

}