package edu.nextstep.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-22 01:17
 */
public class SplitUtilsTest {

    @DisplayName(" ',' ':' 을 기준으로 나누기")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void commonSplit(String inputData) {

        assertThat(SplitUtils.commonSplit(inputData).contains("1")).isTrue();
    }

    @DisplayName("커스텀 구분자를 기준으로 나누기")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//-\n1-2-3"})
    void customSplit(String inputData) {

        assertThat(SplitUtils.customSplit(inputData).contains("1")).isTrue();
    }

    @DisplayName("커스텀, 일반 모두 포함된 구분자를 기준으로 나누기")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "//;\n1;2;3", "//-\n1-2-3"})
    void intputDataSplit(String inputData) {

        assertThat(SplitUtils.inputDataSplit(inputData).contains("1")).isTrue();
    }

}
