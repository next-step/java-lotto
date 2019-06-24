package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
                    new LottoTicket(overlapNumbers);
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
                    new LottoTicket(lackOfNumbers);
                    new LottoTicket(excessOfNumbers);
                }).withMessageContaining(LottoTicket.AlERT_DIFFERENT_SIZE_OF_NUMBERS);
    }

}
