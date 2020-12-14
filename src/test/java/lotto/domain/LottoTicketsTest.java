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

        //when
        LottoTickets lottoTickets = new LottoTickets(money, new RandomTicketMachine());

        //then
        assertThat(lottoTickets).isNotNull();
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
        LottoTicket lastWinningTicket = new LottoTicket(new HashSet<>(lottoNumbers.subList(0, 6)));
        MatchResult result = lottoTickets.match(lastWinningTicket);

        //then
        Map<Integer, Integer> matchResult = new HashMap<>();
        matchResult.put(6, 1);
        matchResult.put(5, 2);
        matchResult.put(4, 0);
        matchResult.put(3, 1);
        MatchResult expected = new MatchResult(matchResult);

        assertThat(result).isEqualTo(expected);
    }
}
