package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.exception.WrongLottoTicketException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTicketTest {

    @ParameterizedTest
    @MethodSource("provideValidLottoNumbers")
    @DisplayName("로또티켓이 6숫자를 가지고, 중복되는 숫자가 없으면 예외를 던지지 않는다.")
    void validate_lotto_ticket_ok(List<LottoNumber> lottoNumbers) {

        assertThatCode(() -> new LottoTicket(lottoNumbers))
            .doesNotThrowAnyException();

    }


    @ParameterizedTest
    @MethodSource("provideWrongSizeTicket")
    @DisplayName("로또티켓이 6개의 숫자를 가지지 않을때 예외를 던진다.")
    void validate_lotto_ticket_size_ng(List<LottoNumber> lottoNumbers) {

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
            .isInstanceOf(WrongLottoTicketException.class);

    }


    @ParameterizedTest
    @MethodSource("provideDuplicateNumberTicket")
    @DisplayName("로또티켓이 중복된 숫자를 가질때 예외를 던진다.")
    void validate_lotto_ticket_duplicate_ng(List<LottoNumber> lottoNumbers) {

        LottoNumber number1 = new LottoNumber(5);
        LottoNumber number2 = new LottoNumber(5);

        System.out.println(number1.equals(number2) );

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
            .isInstanceOf(WrongLottoTicketException.class);

    }


    private static Stream<Arguments> provideValidLottoNumbers() {

        return Stream.of(
            Arguments.of(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
            Arguments.of(Arrays.asList(
                new LottoNumber(14), new LottoNumber(22), new LottoNumber(34),
                new LottoNumber(40), new LottoNumber(44), new LottoNumber(45)))
        );
    }


    private static Stream<Arguments> provideWrongSizeTicket() {

        return Stream.of(
            Arguments.of(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5))),
            Arguments.of(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6),
                new LottoNumber(7)))
        );
    }


    private static Stream<Arguments> provideDuplicateNumberTicket() {

        return Stream.of(
            Arguments.of(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(5)))
        );
    }

}