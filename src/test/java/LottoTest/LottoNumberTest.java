package LottoTest;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LottoNumberTest {
    @Test
    @DisplayName("인스턴스 생성")
    void When_New() {
        assertThat(LottoNumber.create(1)).isEqualTo(LottoNumber.create(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("잘못된 입력값 테스트")
    void Given_InvalidNumber_When_New_Then_Exception(int given) {
        assertThatExceptionOfType(IllegalArgumentException.class).
                isThrownBy(() -> LottoNumber.create(given));

    }

    @Test
    @DisplayName("Caching 테스트")
    void When_CreatedTwice_Then_TheInstancesAreTheSame() {
        assertSame(LottoNumber.create(1), LottoNumber.create(1));
    }
}
