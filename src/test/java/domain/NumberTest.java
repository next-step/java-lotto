package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {

    @Test
    void 로또_후보군_생성후_갯수_체크(){
        Numbers numbers = new Numbers(Lotto.LOTTO_NUMBER_BOUND);
        assertThat(numbers.getNumbers()).hasSize(45);
    }
}
