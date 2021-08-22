package Lotto.Number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("로또 숫자 리스트는")
public class LottoNumbersTest {

    @DisplayName("길이가 6이 아닐 경우 에러 발생")
    @Test
    void lottoNumbersAboveOrUnder6ThrowsError() {
        List<LottoNumber> given = Stream.of(1, 2, 3, 4, 5).map(LottoNumber::new).collect(Collectors.toList());
        assertThatThrownBy(() -> new LottoNumbers(given)).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("로또 숫자는 6개입니다.");
    }

    @DisplayName("길이가 6일 경우 정상")
    @Test
    void lottoNumbersLengthMustBe6() {
        List<LottoNumber> given = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        assertDoesNotThrow(() -> new LottoNumbers(given));
    }
}
