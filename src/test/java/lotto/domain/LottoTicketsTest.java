package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @DisplayName("객체생성 - 최소금액 충족")
    @Test
    void create() {
        //given
        int money = 1_000;
        FixedTicketMachine ticketMachine = new FixedTicketMachine();

        //when
        LottoTickets lottoTickets = new LottoTickets(money, ticketMachine);

        //then
        LottoTickets expected = new LottoTickets(ticketMachine.issue(1));

        assertThat(lottoTickets).isNotNull();
        assertThat(lottoTickets).isEqualTo(expected);
    }

    @DisplayName("객체생성 - 최소금액 부족")
    @Test
    void create_lowMoney() {
        //given
        int money = 999;

        //when, then
        assertThatIllegalArgumentException()
              .isThrownBy(() -> new LottoTickets(money, new RandomTicketMachine()))
              .withMessage("금액이 부족합니다.");
    }

    @DisplayName("당첨번호 매치 결과")
    @Test
    void match() {
        //given
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 45)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toList());

        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(
              new LottoTicket(new HashSet<>(lottoNumbers.subList(0, 6))) // 6개일치
              , new LottoTicket(new HashSet<>(lottoNumbers.subList(1, 7))) // 5개일치
              , new LottoTicket(new HashSet<>(lottoNumbers.subList(1, 7))) // 5개일치
              , new LottoTicket(new HashSet<>(lottoNumbers.subList(3, 9))) // 3개일치
              , new LottoTicket(new HashSet<>(lottoNumbers.subList(4, 10))) // 2개일치
        ));

        //when
        WinningTicket lastWinningTicket = new WinningTicket(new HashSet<>(lottoNumbers.subList(0, 6)), new LottoNumber(45));
        MatchResult result = lottoTickets.match(lastWinningTicket);

        //then
        Map<MatchCount, Integer> matchMap = new HashMap<MatchCount, Integer>() {{
            put(MatchCount.FORTH, 1);
            put(MatchCount.THIRD, 0);
            put(MatchCount.SECOND, 2);
            put(MatchCount.SECOND_WITH_BONUS, 0);
            put(MatchCount.FIRST, 1);
        }};
        MatchResult expected = new MatchResult(matchMap, 5);

        assertThat(result).isEqualTo(expected);
    }
}
