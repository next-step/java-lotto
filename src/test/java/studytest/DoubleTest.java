package studytest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DoubleTest {

    @DisplayName("double형이 담을 수 있는 소수점 자리수를 확인한다.")
    @Test
    void doubleHowManyInput() {
        // given
        double num1 = 1.1234567890123456789012345678901234567890; // 소수점 40자리
        double num2 = 12.1234567890123456789012345678901234567890; // 소수점 16자리

        System.out.println(num1);
        System.out.println(num2);

        // when & then
        assertThat(num1).isEqualTo(1.1234567890123457);
        assertThat(num2).isEqualTo(12.123456789012346);
    }
}
