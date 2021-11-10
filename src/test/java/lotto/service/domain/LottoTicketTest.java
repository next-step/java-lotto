package lotto.service.domain;

import lotto.service.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("해당 번호가 로또복권에 포함되어 있는지 확인")
    void isContains(Integer number) {
        LottoTicket lottoTicket = LottoTicket.from(
                Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));

        assertThat(lottoTicket.isContains(LottoNumber.from(number))).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1      |2      |3      |4      |5      |6      |6",
            "11     |2      |3      |4      |5      |6      |5",
            "11     |12     |3      |4      |5      |6      |4",
            "11     |12     |13     |4      |5      |6      |3",
            "11     |12     |13     |14     |5      |6      |2",
            "11     |12     |13     |14     |15     |6      |1",
            "11     |12     |13     |14     |15     |16      |0"
    }, delimiter = '|')
    @DisplayName("해당 번호가 로또복권에 포함되어 있는지 확인")
    void getCountOfMatch(Integer number1, Integer number2, Integer number3,
                         Integer number4, Integer number5, Integer number6,
                         Integer countOfMatch) {
        LottoTicket winningLottoTicket = LottoTicket.from(
                Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));

        LottoTicket purchaseLottoTicket = LottoTicket.from(
                Arrays.asList(LottoNumber.from(number1), LottoNumber.from(number2), LottoNumber.from(number3),
                              LottoNumber.from(number4), LottoNumber.from(number5), LottoNumber.from(number6)));

        assertThat(winningLottoTicket.getCountOfMatch(purchaseLottoTicket)).isEqualTo(countOfMatch);
    }

    @Test
    @DisplayName("로또번호가 없는 경우 예외 발생")
    void exception() {
        assertThatNullPointerException().isThrownBy(() -> LottoTicket.from(null));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("로또번호 갯수가 1보다 작거나 6보다 큰 경우 예외 발생 검증")
    void exception2(List<LottoNumber> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.from(numbers));
    }

    private static Stream<Arguments> exception2() {
        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of(
                        Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                                      LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6),
                                      LottoNumber.from(7))));
    }
}
