package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExtractorTest {
    @Test
    void 숫자_추출() {
        Extractor extractor = new Extractor();
        assertThat(extractor.extract_numbers("1 + 2 / 3")).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 사칙연산_추출() {
        Extractor extractor = new Extractor();
        assertThat(extractor.extract_operators("1 + 2 / 3")).isEqualTo(List.of("+", "/"));
        assertThatThrownBy(() -> {
            extractor.extract_operators("1 + 2 ? 3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_예외() {
        Extractor extractor = new Extractor();
        assertThatThrownBy(() -> {
            extractor.extract_numbers("");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            extractor.extract_operators("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
