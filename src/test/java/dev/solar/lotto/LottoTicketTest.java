package dev.solar.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTicketTest {
    @DisplayName("입력받은 당첨 번호로 몇개의 번호를 맞췄는지 계산한다.")
    @MethodSource("lottoNumbers")
    @ParameterizedTest
    void check_the_number_of_wins(LottoTicket lottoTicket, int result) {
        Set<LottoNumber> winningNumbers = new TreeSet<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        assertThat(lottoTicket.checkWinningNumbers(winningNumbers)).isEqualTo(result);
    }

    private static Stream<Arguments> lottoNumbers() {
        return Stream.of(Arguments.of(new LottoTicket("1,2,3,4,44,45"), 4),
                         Arguments.of(new LottoTicket("1,2,3,4,5,45"), 5),
                         Arguments.of(new LottoTicket("1,2,3,4,5,6"), 6));
    }
}
