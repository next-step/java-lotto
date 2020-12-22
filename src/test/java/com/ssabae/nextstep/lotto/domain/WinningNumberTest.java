package com.ssabae.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.ssabae.nextstep.lotto.domain.lotto.LottoNumber;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", "7");

        List<LottoNumber> winningNumberList = winningNumber.getWinningNumberList();

        assertAll(
                () -> assertThat(winningNumberList).isNotNull().isNotEmpty(),
                () -> assertThat(winningNumberList.size()).isEqualTo(6),
                () -> assertThat(winningNumberList).containsExactly(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6)
                )
        );
    }

    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("로또 당첨 번호 생성 실패 Test")
    @CsvSource(value = {"-1, 2, 3, 4, 5, 6:7", "0, 2, 3, 4, 5, 6:7", "1, 2, 3, 4, 5, 46:7", "1, 2:7"}, delimiter = ':')
    void shouldBeExceptionInGenerateWinningNumberTest(String value, String bonusNumber) {
        assertThatThrownBy(() -> new WinningNumber(value, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
