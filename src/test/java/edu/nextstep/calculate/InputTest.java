package edu.nextstep.calculate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 21:56
 */
public class InputTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void getInputData(String inputData) {
        List<String> testInputData = new ArrayList<>(Arrays.asList("1", "2", "3"));
        Input input = new Input(testInputData);

        assertThat(input.getInputData().contains(inputData)).isTrue();
    }
}
