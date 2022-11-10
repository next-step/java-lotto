package calculator.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class CalculatorTest {
    @Test
    public void sumTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator();
        Method method = calculator.getClass().getDeclaredMethod("sum", String.class, String.class);
        method.setAccessible(true);

        assertThat(method.invoke(calculator,"1","2")).isEqualTo(3);
    }

    @Test
    public void minusTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator();
        Method method = calculator.getClass().getDeclaredMethod("minus", String.class, String.class);
        method.setAccessible(true);

        assertThat(method.invoke(calculator,"1","2")).isEqualTo(-1);
    }
    @Test
    public void multiplyTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator();
        Method method = calculator.getClass().getDeclaredMethod("multiply", String.class, String.class);
        method.setAccessible(true);

        assertThat(method.invoke(calculator,"1","2")).isEqualTo(2);
    }
    @Test
    public void divideTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator();
        Method method = calculator.getClass().getDeclaredMethod("divide", String.class, String.class);
        method.setAccessible(true);

        assertThat(method.invoke(calculator,"1","2")).isEqualTo(0);
    }


}
