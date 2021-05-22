package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DigitsTest {

    @Test
    void 합구하기(){
        Digits digits = new Digits(Arrays.asList(new Digit("1"), new Digit("2")));
        assertThat(digits.sum()).isEqualTo(3);
    }
}