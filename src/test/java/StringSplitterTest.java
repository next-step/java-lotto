import utils.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {
    @DisplayName("구분자 split 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,3",
            "2,5:6:4,2",
            "//(\\n5(5",
            "//;\\n1;2;3"})
    public void split_delimiter_Test(String input) {
        int output = StringSplitter.splitDelimiter(input).size();
        List<Integer> result = StringSplitter.splitDelimiter(input);
        assertThat(result.size()).isEqualTo(output);
    }
}