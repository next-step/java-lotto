package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DigitTest {

    @Test
    void 생성테스트(){
        Digit digit1 = new Digit("1");
        Digit digit2 = new Digit("2");
        assertThat(digit1).isEqualTo(new Digit("1"));
        assertThat(digit2).isNotEqualTo(new Digit("1"));
    }

    @Test
    void 음수로번호생성시도(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            new Digit("-1");
        });
    }

    @Test
    void 숫자가아닌토큰으로생성시도(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            new Digit("선");
        });
    }
}