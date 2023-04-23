package step1.domain.model;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class InputStackTest {

    @Test
    public void 입력값_반전으로되는지테스트() {
        InputStack from = InputStack.from("2 + 3 * 4 / 2");
        assertThat(from.pop()).isEqualTo("2");
        assertThat(from.pop()).isEqualTo("+");
        assertThat(from.pop()).isEqualTo("3");
        assertThat(from.pop()).isEqualTo("*");
        assertThat(from.pop()).isEqualTo("4");
        assertThat(from.pop()).isEqualTo("/");
        assertThat(from.pop()).isEqualTo("2");
    }
}
