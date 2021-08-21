package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.Ticket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TicketTest {

    @Test
    @DisplayName("로또 번호를 저장한다.")
    void lottoTicket_save() {
        Ticket lottoTicket = new Ticket();

        // 로또 번호 생성
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        lottoTicket.saveLottoNumbers(lottoNumbers);
        List<Integer> getLottoNumbers = lottoTicket.getLottoNumbers();

        assertThat(getLottoNumbers).isEqualTo(lottoNumbers);
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersProvider")
    @DisplayName("입력 숫자가 6개가 아닌경우 Exception 발생한다.")
    void input_count_not_six_exception_test(List<Integer> lottoNumbers) {
        Ticket ticket = new Ticket();

        assertThatThrownBy(() ->
                ticket.saveLottoNumbers(lottoNumbers)
        ).isInstanceOf(IllegalArgumentException.class);

    }

    static Stream<Arguments> lottoNumbersProvider() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                arguments(Arrays.asList(1, 2, 3, 4, 5))
        );
    }

    @Test
    @DisplayName("입력된 숫자가 범위를 초과한 경우 Exception 발생한다.")
    void input_count_not_six_exception_test() {
        Ticket ticket = new Ticket();

        assertThatThrownBy(() ->
                ticket.saveLottoNumbers(Arrays.asList(0, 2, 3, 4, 5, 47))
        ).isInstanceOf(IllegalArgumentException.class);

    }
}
