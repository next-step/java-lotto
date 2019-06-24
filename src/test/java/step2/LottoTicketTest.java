package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {

    @Test
    void 로또복권의_로또번호가_중복될_경우_예외가_발생한다() {
        //Given
        List<Integer> overlapNumbers = Arrays.asList(1, 1, 3, 4, 5, 6);

        //When
        //Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoTicket(overlapNumbers
                            .stream()
                            .map(LottoNumber::from)
                            .collect(Collectors.toList()));
                }).withMessageContaining(LottoTicket.ALERT_NUMBER_OVERLAP);
    }

    @Test
    void 로또복권의_로또번호가_6개보다_작거나_클_경우_예외가_발생한다() {
        //Given
        List<Integer> lackOfNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> excessOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //When
        //Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new LottoTicket(lackOfNumbers.stream()
                            .map(LottoNumber::from)
                            .collect(Collectors.toList()));
                    new LottoTicket(excessOfNumbers.stream()
                            .map(LottoNumber::from)
                            .collect(Collectors.toList()));
                }).withMessageContaining(LottoTicket.AlERT_DIFFERENT_SIZE_OF_NUMBERS);
    }

    @Test
    void 당첨번호와_비교하여_같은_숫자의_개수를_반환한다() {
        //Given
        List<Integer> testLuckyNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> testLottoTicket = Arrays.asList(1, 3, 5, 7, 9, 11);
        LuckyNumber luckyNumber = LuckyNumber.from(testLuckyNumber);
        LottoTicket lottoTicket = new LottoTicket(LottoTicketGenerator.pickLottoBalls(testLottoTicket));

        //When
        long result = lottoTicket.getNumberOfMatchedLuckyNumber(luckyNumber);

        //Then
        assertThat(result).isEqualTo(3);
    }
}
