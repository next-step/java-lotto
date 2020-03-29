package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilTest {

    @DisplayName("구분자로 문자열 자르고 생성된 list의 사이즈 체크")
    @ParameterizedTest
    @CsvSource(value = {"1:,:1", "1,2,3:,:3", "1,2,3,4:,:4"}, delimiter = ':')
    public void splitStringUseDelimiter(String input, String delimiter, int expect) throws Exception {
        //when
        List<String> strings = StringUtil.splitStringUseDelimiter(input, delimiter);

        //then
        assertThat(strings.size()).isEqualTo(expect);
    }

    @DisplayName("String을 int 로 변환")
    @ParameterizedTest
    @CsvSource(value = {"123:123", "1:1", "0:0", "1000:1000"}, delimiter = ':')
    public void parseStringToInt(String input, int expect) throws Exception {
        assertThat(StringUtil.parseStringToInt(input)).isEqualTo(expect);
    }

    @DisplayName("String을 int 로 변환 : fail")
    @ParameterizedTest
    @ValueSource(strings = {":123", "abc", "!!"})
    public void parseStringToInt_fail(String input) throws Exception {
        assertThatThrownBy(
                () -> StringUtil.parseStringToInt(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(",로 구분된 문다열을 입력 받아 List<Integer> 로 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2:2", "1,2,3:3", "1,2,3,4:4"}, delimiter = ':')
    public void splitStringToIntegers(String input, int expect) throws Exception {
        //given
        assertThat(StringUtil.splitStringToIntegers(input).size()).isEqualTo(expect);
    }

}
