package calcalator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {


    @Test
    @DisplayName("생성자 테스트")
    void constructor() {
        Number number = new Number("1");
        assertThat(number.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("equals 테스트")
    void equals() {
        Number number = new Number("1");
        assertThat(number.equals(new Number("1"))).isTrue();
    }
}
