package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class CalculatorTest {
    @Test
    public void sumTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator();
        Method method = calculator.getClass().getDeclaredMethod("sum", String.class, String.class);
        method.setAccessible(true);

        assertThat(method.invoke(calculator, "1", "2")).isEqualTo(3);
    }

    @Test
    public void minusTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator();
        Method method = calculator.getClass().getDeclaredMethod("minus", String.class, String.class);
        method.setAccessible(true);

        assertThat(method.invoke(calculator, "1", "2")).isEqualTo(-1);
    }

    @Test
    public void multiplyTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator();
        Method method = calculator.getClass().getDeclaredMethod("multiply", String.class, String.class);
        method.setAccessible(true);

        assertThat(method.invoke(calculator, "1", "2")).isEqualTo(2);
    }

    @Test
    public void divideTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator();
        Method method = calculator.getClass().getDeclaredMethod("divide", String.class, String.class);
        method.setAccessible(true);

        assertThat(method.invoke(calculator, "1", "2")).isEqualTo(0);
    }

    @Test
    public void wrongOperatorTest() throws NoSuchMethodException {
        Calculator calculator = new Calculator();
        Method method = calculator.getClass().getDeclaredMethod("calculate", String.class, String.class, String.class);
        method.setAccessible(true);

        try {
            method.invoke(calculator, "1", "%", "2");
        } catch (IllegalArgumentException e) {
            assertThat(e.getCause().getMessage()).isEqualTo("알수 없는 사칙연산 기호 입니다.");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runTest() {
        Calculator calculator = new Calculator(Arrays.asList("1", "+", "3"));
        assertThat(calculator.run()).isEqualTo(4);
    }
}
