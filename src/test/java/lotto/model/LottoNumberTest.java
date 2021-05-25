package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @DisplayName("로또 생성시 로또 번호 리스트 범위가 1~45를 벗어나면 에러")
    @ParameterizedTest
    @ValueSource(ints = {0,46,47})
    void validateLottoListRangeTest(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoNumber(number);
                });
    }

}
