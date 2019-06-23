package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {
    @Test
    void 문자열_분할기를_생성한다() {
        //Given
        StringSplitter splitter = new StringSplitter();

        //When
        //Then
        assertThat(splitter).isNotNull();
    }
}
