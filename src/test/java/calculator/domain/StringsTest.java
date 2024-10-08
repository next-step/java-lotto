package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringsTest {
    @Test
    void 특정_인덱스_다음_값() {
        String plus = "+";
        Strings strings = new Strings(new String[]{"1", plus});
        assertThat(strings.getNext(0)).isEqualTo(plus);
    }

    @Test
    void 특정_인덱스_값() {
        String one = "1";
        Strings strings = new Strings(new String[]{one});
        assertThat(strings.get(0)).isEqualTo(one);
    }

    @Test
    void 길이() {
        String[] values = {"1"};
        Strings strings = new Strings(values);
        assertThat(strings.length()).isEqualTo(values.length);
    }

    @Test
    void 첫번쨰_문자_반환() {
        String[] values = {"1"};
        Strings strings = new Strings(values);
        assertThat(strings.getFirst()).isEqualTo(values[0]);
    }
}