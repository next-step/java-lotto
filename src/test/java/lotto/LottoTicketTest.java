package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("당첨번호와 티켓번호가 비교결과 테스트")
    @Test
    void check_match_result() {
        //Given
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1,2,3,4,5,6});
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(11), new LottoNumber(12),
                                                  new LottoNumber(13), new LottoNumber(14),
                                                  new LottoNumber(17), new LottoNumber(18)
                                                );
        LottoTicket lottoTicket = new LottoTicket(numbers);

        //When
        MatchStatus matchStatus = lottoTicket.matchResultWith(winningNumbers);

        //
        assertThat(matchStatus).isEqualTo(MatchStatus.ZERO);
    }
}
