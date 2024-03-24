package lotto.domian;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {
    private List<LottoNumber> lottoNumbers;
    private LottoTicket ticket ;
    @BeforeEach
    void setUP(){
        lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6));

        ticket = LottoTicket.of(lottoNumbers);
    }
    @Test
    @DisplayName("로또 넘버 List 사이즈는 6이다.")
    void shouldCreateLottoTicketWithSixNumbers(){
        LottoTicket ticket = LottoTicket.of(lottoNumbers);
        assertThat(ticket).isNotNull();
        assertThat(ticket.getLottoNumber()).hasSize(6);
    }

    @Test
    @DisplayName("당첨 번호와 매칭되는 개수를 반환한다")
    void ReturnCorrectMatchCountWithWinnerNumbers(){
        WinnerNumber winnerNumbers = WinnerNumber.of(Set.of(1,2,3,7,8,9),LottoNumber.of(10));
        int matchingCount = ticket.countMatchingNumbers(winnerNumbers);
        assertThat(matchingCount).isEqualTo(3);
    }
}
