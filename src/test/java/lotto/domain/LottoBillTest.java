package lotto.domain;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoBillTest {

    @DisplayName("로또 티켓과 당첨번호를 비교하여 맞은 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "10,11,12,22,33,44:0"}, delimiter = ':')
    void drawLotto(String winningNumber, int matchCount) {
        LottoTicket lottoTicket = createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<LottoNumber> winningNumbers = Stream.of(winningNumber.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        LottoBill lottoBill = new LottoBill(Arrays.asList(lottoTicket));

        assertThat(lottoBill.drawLotto(lottoTicket, winningNumbers)).isEqualTo(matchCount);
    }

    @DisplayName("모든 로또 티켓과 당첨 번호를 비교하여 맞은 개수의 리스트를 반환한다.")
    @Test
    void drawAllLotto() {
        LottoBill lottoBill = new LottoBill(createLottoTickets(3));

        List<LottoNumber> winningNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        List<Integer> actualMatchCounts = lottoBill.drawAllLotto(winningNumbers);
        assertThat(actualMatchCounts).contains(6, 5, 4);
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
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}
