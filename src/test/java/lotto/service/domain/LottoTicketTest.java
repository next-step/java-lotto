package lotto.service.domain;

import lotto.service.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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
