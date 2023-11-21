package StringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    private Numbers numbers;

    @BeforeEach
    public void 초기화(){
        this.numbers = new Numbers(new String[]{"2","+","2","-","4"});
    }

    @Test
    void 덧셈테스트() {
        assertThat(numbers.interact("+",4,1)).isEqualTo(8);
    }

    @Test
    void 뺄셈테스트() {
        assertThat(numbers.interact("-",4,1)).isEqualTo(0);
    }

    @Test
    void 곱셈테스트() {
        assertThat(numbers.interact("*",1,1)).isEqualTo(4);
    }

    @Test
    void 나눗셈테스트() {
        assertThat(numbers.interact("/",4,1)).isEqualTo(1);
    }
}