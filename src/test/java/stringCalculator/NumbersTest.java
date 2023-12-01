package stringCalculator;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    private Numbers numbers;

    @BeforeEach
    public void 초기화(){
        this.numbers = new Numbers(new String[]{"2","+","2","-","4"});
    }

}