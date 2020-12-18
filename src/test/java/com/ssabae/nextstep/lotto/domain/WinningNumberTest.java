package com.ssabae.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
@DisplayName("로또 당첨 번호 Test Class")
class WinningNumberTest {

    @Test
    @DisplayName("로또 당첨 번호 생성 Test")
    void generateWinningNumberTest() {
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");

        List<Integer> winningNumberList = winningNumber.getWinningNumberList();

        assertThat(winningNumberList).isNotNull().isNotEmpty();
        assertThat(winningNumberList.size()).isEqualTo(6);
        assertThat(winningNumberList).containsExactly(1, 2, 3, 4, 5, 6);
    }


    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("로또 당첨 번호 생성 실패 Test")
    @ValueSource(strings = {"-1, 2, 3, 4, 5, 6", "0, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 46", "1, 2"})
    void shouldBeExceptionInGenerateWinningNumberTest(String value) {
        assertThatThrownBy(() -> new WinningNumber(value))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
