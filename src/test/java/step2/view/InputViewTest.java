package step2.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    void convertTest() {
        final String inputString = "1, 2, 3, 4, 5, 6";
        final List<Integer> actual = InputView.convertStringToListOfNumber(inputString);
        final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(actual).isEqualTo(expected);
    }
}
