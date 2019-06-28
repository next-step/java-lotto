package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExtractorTest {
    static public String sample = "//delimiter\n1delimiter2";

    Extractor extractor;

    @BeforeEach
    void setUp() {
        extractor = new Extractor(sample);
    }

    @Test
    void 커스텀구분자_입력시_구분자를_골라낸다() {
        assertThat(extractor.getDelimiter()).isEqualTo("delimiter");
    }

    @Test
    void 커스텀구분자_입력시_식만_골라낸다() {
        assertThat(extractor.getRefinedEquation()).isEqualTo("1delimiter2");
    }

    @Test
    void 주어진_식에서_정수_추출() {
        String del = extractor.getDelimiter();

        assertThat(extractor.getOperands(del)).containsExactly(1,2);
    }
}
