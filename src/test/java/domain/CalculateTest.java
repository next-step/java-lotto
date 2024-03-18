package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateTest {

    Calculate calculate;

    @BeforeEach
    void setUp() {
        calculate = new Calculate();
    }

    @Test
    void plus(){
        final String[] inputs = {"1", "+", "2"};
        for(String input : inputs){
            calculate.process(input);
        }
        assertThat(calculate.getResult()).isEqualTo(3);
    }

    @Test
    void minus(){
        final String[] inputs = {"1", "-", "2"};
        for(String input : inputs){
            calculate.process(input);
        }
        assertThat(calculate.getResult()).isEqualTo(-1);
    }

}