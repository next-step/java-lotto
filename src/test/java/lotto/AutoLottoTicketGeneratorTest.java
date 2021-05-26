package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.AutoLottoTicketGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTicketGeneratorTest {

    @DisplayName("싱글톤 객체임을 확인한다")
    @Test
    void check_singleton_pattern() {
        //Given+When
        AutoLottoTicketGenerator firstGenerator = AutoLottoTicketGenerator.start();
        AutoLottoTicketGenerator secondGenerator = AutoLottoTicketGenerator.start();

        //Then
        assertThat(firstGenerator).isSameAs(secondGenerator);
    }

    @DisplayName("숫자 6개를 뽑는다")
    @Test
    void extract_six_random_numbers() {
        //Given+When
        LottoTicket lottoTicket = AutoLottoTicketGenerator.start().extract();
        //Then
        assertThat(lottoTicket.countOfNumbers()).isEqualTo(6);
    }
}
