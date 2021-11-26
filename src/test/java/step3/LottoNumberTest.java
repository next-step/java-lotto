package step3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.InvalidLottoNumberRangeException;
import step3.model.LottoNumber;
import step3.model.Money;

@DisplayName("LottoNumber 클래스 테스트")
public class LottoNumberTest {

    @DisplayName("equals 와 hashCode 테스트")
    @Test
    void equalsAndHashCode() {
        Money money = new Money(1000);
        Money equal = new Money(1000);
        Money differ = new Money(2000);

        assertAll(
            () -> assertTrue(money.equals(equal)),
            () -> assertEquals(equal.hashCode(), money.hashCode()),
            () -> assertFalse(money.equals(differ)),
            () -> assertNotEquals(equal.hashCode(), differ.hashCode())
        );
    }

    @DisplayName("랜덤 숫자 생성이 원하는 갯수만큼 이뤄지는지")
    @ParameterizedTest(name = "[{index}] size = {0}, expected = {1}")
    @CsvSource(value = {
        "1, 1",
        "6, 6",
    })
    void generateRandomNumbersSize(int size, int expectedSize) {
        List<LottoNumber> lottoNumbers = LottoNumber.generateRandomNumbers(size);
        assertEquals(expectedSize, lottoNumbers.size());
    }

    @DisplayName("예외 - 1부터 45 사이 범위를 벗어난 경우")
    @ParameterizedTest(name = "[{index}] input = {0}")
    @ValueSource(ints = {0, 46})
    void exception_rangeError(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
            .isInstanceOf(InvalidLottoNumberRangeException.class);
    }

}
