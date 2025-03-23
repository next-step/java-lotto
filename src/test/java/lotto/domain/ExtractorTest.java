package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExtractorTest {
    @Test
    void 숫자_추출() {
        assertThat(Extractor.extract_numbers("1 + 2 / 3")).isEqualTo(List.of(1L, 2L, 3L));
    }

    @Test
    void 사칙연산_추출() {
        assertThat(Extractor.extract_operators("1 + 2 / 3")).isEqualTo(List.of(Operator.PLUS, Operator.DIVIDE));
        assertThatThrownBy(() -> {
            Extractor.extract_operators("1 + 2 ? 3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_예외() {
        assertThatThrownBy(() -> {
            Extractor.extract_numbers("");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            Extractor.extract_operators("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
