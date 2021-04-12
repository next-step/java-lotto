package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    @ParameterizedTest(name = "문자열 split 테스트")
    @ValueSource(strings = {"1,3,5","1:3:5", "//;\n1;3;5"})
    void splitStringIntoList(String given) {
        // when
        Splitter splitter = new StringSplitter();
        List<String> actual = splitter.splitStringIntoList(given);

        // then
        assertThat(actual).containsExactly("1","3","5");
    }
}
