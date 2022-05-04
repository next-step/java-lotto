package string_calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {
    @Test
    void parseShouldReturnEqualValuesInBothControllerAndParser() {
        Controller controller = new Controller();
        controller.parse("1 + 2");
        List<Object> actual = controller.parser.values;
        Parser parser = new Parser();
        parser.parse("1 + 2");
        List<Object> expected = parser.values;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void computesShouldReturnEqualValuesInBothControllerAndCalculator() {
        Controller controller = new Controller();
        controller.parse("1 + 2");
        Integer actual = controller.computes();;
        Calculator calculator = new Calculator();
        Integer expected = calculator.computes(controller.parser.values);
        assertThat(actual).isEqualTo(expected);
    }
}
