package lotto.oop.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    private InputView input;

    @BeforeEach
    public void setUp() {
        input = new InputView();
    }

    @Test
    void convertIntList() {
        String number = "1,3,5,6,7,8";
        List<Integer> num = input.convertInt(number);
        assertThat(num).isEqualTo(Arrays.asList(1,3,5,6,7,8));
    }
}
