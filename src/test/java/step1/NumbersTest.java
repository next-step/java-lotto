package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Number;
import step1.domain.Numbers;

import static org.assertj.core.api.Assertions.*;

public class NumbersTest {
    @Test
    @DisplayName("Numbers 객체 생성")
    void create() {
        Numbers numbers = new Numbers("1;2;3".split(";"));
        assertThat(numbers).isEqualTo(new Numbers("1;2;3".split(";")));
    }

    @Test
    @DisplayName("Number List get method test")
    void getList() {
        Numbers numbers = new Numbers("1;2;3".split(";"));
        assertThat(numbers.getList())
                .containsExactly(new Number(1), new Number(2), new Number(3));
    }

    @Test
    @DisplayName("Number 객체들의 합")
    void sum() {
        Numbers numbers = new Numbers("1;2;3".split(";"));
        assertThat(numbers.sum()).isEqualTo(new Number(6));
    }
}
