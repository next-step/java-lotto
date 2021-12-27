package stringcaculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringToIntegerValueTest {
    @ParameterizedTest
    @CsvSource({"'1','2','3'","'4','5','9'"})
    @DisplayName("정상적으로 sum이 실행되는지 확인합니다")
    void sum(String thisValue, String addtionalValue, String result) {
        assertThat(new StringToIntegerValue(thisValue).sum(new StringToIntegerValue(addtionalValue))
                .equals(new StringToIntegerValue(result))).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"'1','2','7'","'4','5','1'"})
    @DisplayName("비정상적으로 sum이 실행되는지 확인합니다")
    void wrongSum(String thisValue, String addtionalValue, String result) {
        assertThat(new StringToIntegerValue(thisValue).sum(new StringToIntegerValue(addtionalValue))
                .equals(new StringToIntegerValue(result))).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"'1',1","'4678987',4678987"})
    @DisplayName("정상적으로 Value가 int 형으로 변환되는지 확인합니다")
    void intValue(String thisValue, int convertedValue) {
        assertThat(new StringToIntegerValue(thisValue).intValue()).isEqualTo(convertedValue);
    }
}