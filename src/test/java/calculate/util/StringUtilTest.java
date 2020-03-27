package calculate.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @DisplayName("구분자로 문자열 자르고 생성된 list의 사이즈 체크")
    @ParameterizedTest
    @CsvSource(value = {":,:1", "1,2,3:,:3", "1,2,3,4:,:4"}, delimiter = ':')
    public void splitStringUseDelimiter(String input, String delimiter, int expect) throws Exception {
        //when
        List<String> strings = StringUtil.splitStringUseDelimiter(input, delimiter);

        //then
        assertThat(strings.size()).isEqualTo(expect);
    }

}
