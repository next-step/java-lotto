package calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @Test
    @DisplayName("객체 생성 테스트")
    public void test1(){
        Number defaultNumber = new Number();
        Number strInputNumber = new Number("1");
        Number intInputNumber = new Number(1);

        assertThat(defaultNumber.getNumber()).isEqualTo(0);
        assertThat(strInputNumber.getNumber()).isEqualTo(1);
        assertThat(intInputNumber.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("add test")
    public void test2(){
        Number number1 = new Number(10);
        Number number2 = new Number("20");
        Number sum = number1.add(number2);

        assertThat(sum.getNumber()).isEqualTo(30);
    }

    @Test
    @DisplayName("equal test")
    public void test3(){
        Number number1 = new Number(10);
        Number number2 = new Number("10");

        assertThat(number1).isEqualTo(number2);
    }
}