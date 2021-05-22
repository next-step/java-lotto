package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketsTest {

    @DisplayName("구매액을 로또가격으로 나눈 값이 정수가 아닐 경우, IllegalArgumentException 발생")
    @Test
    void throw_exception_when_mod_is_not_zero() {
        //Given
        int purchaseAmount = 15400;
        //When + Then
        assertThatThrownBy(() -> new LottoTickets(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoTickets.ERROR_AMOUNT_CANNOT_BE_DIVIDED);
    }


    @DisplayName("유효하지 않은 값을 구매액으로 입력한 경우, Exception을 발생시킨다")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @ValueSource(strings = {"0", "100001", "-1"})
    void throw_exception_when_invalid_purchase_amount(String input) {
        //Given
        int purchaseAmount = Integer.parseInt(input);

        //When + Then
        assertThatThrownBy(() -> new LottoTickets(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoTickets.ERROR_AMOUNT_OUT_OF_RANGE);
    }

    @DisplayName("모든 티켓을 당첨번호와 비교한 결과 확인한다")
    @Test
    void match_all_tickets_with_winning_numbers() {
        //Given
        List<LottoNumber> firstNumbers = Arrays.asList(new LottoNumber(11), new LottoNumber(12),
                new LottoNumber(13), new LottoNumber(17),
                new LottoNumber(21), new LottoNumber(22));
        List<LottoNumber> secondNumbers = Arrays.asList(new LottoNumber(11), new LottoNumber(12),
                new LottoNumber(13), new LottoNumber(33),
                new LottoNumber(34), new LottoNumber(35));
        List<LottoTicket> lottoTicketList = Arrays.asList(new LottoTicket(firstNumbers),
                new LottoTicket(secondNumbers));
        //When
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{11, 12, 13, 17, 44, 45});
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);

        //Then
        LottoResult lottoResult = lottoTickets.matchingResultWith(winningNumbers);
        assertThat(lottoResult.getResultCount(MatchStatus.THREE)).isEqualTo(1);
        assertThat(lottoResult.getResultCount(MatchStatus.FOUR)).isEqualTo(1);
    }
}
