package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.InputString;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    
    @Test
    @DisplayName("로또번호가 아니면 IllegalArgumentException 발생")
    void number_illegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Number(100));
    }

}