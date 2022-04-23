package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 응모권")
class LottoTicketTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() ->
                LottoTicket.from(LottoNumbers.from(
                        IntStream.rangeClosed(1, 6).mapToObj(LottoNumber::from).collect(Collectors.toList())
                )));
    }

    @Test
    @DisplayName("숫자들은 필수")
    void instance_nullNumbers_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> LottoTicket.from(null));
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 6개")
    @MethodSource
    void instance_singleNumber_thrownIllegalArgumentException(List<LottoNumber> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.from(LottoNumbers.from(numbers)));
    }

    public static Stream<Arguments> instance_singleNumber_thrownIllegalArgumentException() {
        return Stream.of(
                Arguments.of(Collections.singletonList(LottoNumber.from(1))),
                Arguments.of(IntStream.rangeClosed(1, 7).mapToObj(LottoNumber::from).collect(Collectors.toList()))
        );
    }
}
