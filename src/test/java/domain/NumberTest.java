package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    void 음수가_들어올_때_테스트() {
        assertThatThrownBy(() -> new Numbers(new String[]{"-1", "1", "2"}))
                .isInstanceOf(RuntimeException.class);
    }


}
