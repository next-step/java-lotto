package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositiveNumberTest {

    @DisplayName("new를 사용해 인스턴스를 생성할 때 음수이면 RuntimeException이 발생한다.")
    @Test
    public void newInstanceInvalidateNumber() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    PositiveNumber positiveNumber = new PositiveNumber("-1");
                });
    }

    @DisplayName("of 정적메소드를 통해 인스턴스를 생성할 때 음수이면 RuntimeException이 발생한다.")
    @Test
    public void ofInstanceInvalidateNumber() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    PositiveNumber positiveNumber = PositiveNumber.of("-1");
                });
    }

    @DisplayName("자신에게 있는 int Number를 반환한다.")
    @Test
    public void getNumberTest() {
        PositiveNumber positiveNumber = new PositiveNumber("5");

        int number = positiveNumber.getNumber();

        assertThat(number).isEqualTo(5);
    }



    @DisplayName("null 또는 빈 String 을 입력하면 getNumber 시에 0이 리턴된다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void emptyAndNullTest(String value) {
        PositiveNumber positiveNumber = new PositiveNumber(value);

        int zero = positiveNumber.getNumber();

        assertThat(zero).isEqualTo(0);
    }

    @DisplayName("입력 받은 문자열을 int 형으로 변경할 수 없으면 NumberFormatException 발생시킨다.")
    @Test
    public void createInstanceNoNumberFormat() {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            PositiveNumber positiveNumber = new PositiveNumber("*1");
        });
    }
}
