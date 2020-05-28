package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("LottoNumber 클래스 테스트")
public class LottoNumberTest {

    @DisplayName("1~45 사이의 값 들어오면 Number 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {LottoNumber.MIN_VALUE, 30, LottoNumber.MAX_VALUE})
    void createLottoNumber(int number) {
        assertThatCode(() -> new LottoNumber(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("equals 메소드 테스트")
    @Test
    void equals() {
        assertThat(new LottoNumber(1).equals(new LottoNumber(1))).isTrue();
        assertThat(new LottoNumber(1).equals(new LottoNumber(2))).isFalse();
    }
}
