package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * WinningAmount 객체(상금관리) 생성 및 기능 테스트
 */
public class WinningAmountTest {

    @ParameterizedTest
    @CsvSource(value = {"3,5000", "4,50000", "5,1500000", "6,2000000000"})
    @DisplayName("상금 출력 확인")
    void get_amount(int matchingNumber, Long amount) {
        // given
        WinningAmount winningAmount = new WinningAmount();

        // when
        Long resultAmount = winningAmount.getAmount(matchingNumber);

        // then
        assertThat(resultAmount).isEqualTo(amount);
    }

    @Test
    @DisplayName("객체 생성")
    void create() {
        // given
        WinningAmount winningAmount = new WinningAmount();

        // when
        int size = winningAmount.size();

        // then
        assertThat(size).isEqualTo(4);
    }
}
