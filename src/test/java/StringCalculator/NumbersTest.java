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

}