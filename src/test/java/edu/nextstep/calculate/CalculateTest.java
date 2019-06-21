package edu.nextstep.calculate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
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
 * create date  : 2019-06-22 02:59
 */
public class CalculateTest {
    private List<String> convertSource;

    @BeforeEach
    void setUp() {
        convertSource = new ArrayList<>();
        convertSource.add("1");
        convertSource.add("2");
        convertSource.add("3");
    }


    @DisplayName("String List를 Integer List로 변환")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void convertIntegerList(int convertTarget) {
        Calculate calculate = new Calculate();
        assertThat(calculate.convertToInteger(convertSource).contains(convertTarget)).isTrue();
    }
}
