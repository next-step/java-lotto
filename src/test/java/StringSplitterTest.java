import utils.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringSplitterTest {
    @DisplayName("구분자 split 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3",
            "2,5:6:4,2",
            "//.\n5.6",
            "//-\n5-6",
            "//&\n5&6",
            "//;\n1;1;1"})
    public void split_delimiter_Test(String input) {
        int output = StringSplitter.splitDelimiter(input).size();
        List<Integer> result = StringSplitter.splitDelimiter(input);
        assertThat(result.size()).isEqualTo(output);
    }

    @DisplayName("입력이 음수일 경우 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1,2,3",
            "2,-5:6:4,2"})
    public void negative_Value_Exception_Test(String input) {
        assertThatThrownBy(() -> {
            StringSplitter.splitDelimiter(input);
        }).isInstanceOf(RuntimeException.class);
    }
}