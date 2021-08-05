package app.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class ManualCountTest {

    @DisplayName("숫자를 받아서 객체 생성")
    @Test
    void createObjectByNumber(){
        ManualCount count = ManualCount.of(5);
        assertThat(count.getCount()).isEqualTo(5);
    }

    @DisplayName("숫자 문자를 받아서 객체 생성")
    @Test
    void createObjectByString(){
        ManualCount count = ManualCount.of("5");
        assertThat(count.getCount()).isEqualTo(5);
    }
    
    @DisplayName("음수 입력시 에러 발생.")
    @Test
    void isNegativeNumberThrowException(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualCount.of(-1)
        ).withMessageContaining("음수");
    }

}