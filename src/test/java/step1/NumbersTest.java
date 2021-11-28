package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Inputs;
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
                .containsExactly(Number.createFromInt(1), Number.createFromInt(2), Number.createFromInt(3));
    }

    @Test
    @DisplayName("Number 객체들의 합")
    void sum() {
        Numbers numbers = new Numbers("1;2;3".split(";"));
        assertThat(numbers.sum()).isEqualTo(Number.createFromInt(6));
    }

    @Test
    @DisplayName("input String의 숫자 사이 구분자 유효성 체크")
    void validate() {
        assertThatThrownBy(() -> Inputs.create("1;2,4"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력 구분자 오류");

        assertThatThrownBy(() -> Inputs.create("//$\n1,2,4"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력 구분자 오류");

    }
}
