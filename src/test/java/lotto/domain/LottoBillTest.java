package lotto.domain;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoWinningNumber;
import lotto.domain.vo.LottoDrawResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoBillTest {

    private static Stream<Arguments> provideWinningNumbersAndDrawResult() {
        return Stream.of(
                Arguments.of(new LottoWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
                        new LottoDrawResult(6, false)),
                Arguments.of(new LottoWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7), 6),
                        new LottoDrawResult(5, true))
        );
    }

    @DisplayName("로또 티켓과 당첨번호를 비교하여 맞은 개수와 보너스 여부를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideWinningNumbersAndDrawResult")
    void drawLotto(LottoWinningNumber winningNumber, LottoDrawResult lottoDrawResult) {
        LottoTicket lottoTicket = createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoBill lottoBill = new LottoBill(Arrays.asList(lottoTicket));

        assertThat(lottoBill.drawLotto(lottoTicket, winningNumber)).isEqualToComparingFieldByField(lottoDrawResult);
    }

    @DisplayName("모든 로또 티켓과 당첨 번호를 비교하여 추첨 결과의 리스트를 반환한다.")
    @Test
    void drawAllLotto() {
        LottoBill lottoBill = new LottoBill(createLottoTickets(3));

        LottoWinningNumber winningNumber = new LottoWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        List<LottoDrawResult> actualMatchCounts = lottoBill.drawAllLotto(winningNumber);
        assertThat(actualMatchCounts.size()).isEqualToComparingFieldByField(3);
    }

    private List<LottoTicket> createLottoTickets(int numberOfTicket) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int startNumber = 1; startNumber <= numberOfTicket; startNumber++) {
            List<Integer> numbers = IntStream.rangeClosed(startNumber, startNumber + 5)
                    .boxed()
                    .collect(Collectors.toList());
            LottoTicket lottoTicket = createLottoTicket(numbers);
            lottoTickets.add(lottoTicket);
        }

        return lottoTickets;
    }

    private LottoTicket createLottoTicket(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}
