package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또번호 일치 테스트")
public class LottoTicketsTest {

    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("수익률 확인")
    void profitRateTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 11, 12, 13)
                .map(LottoNumber::new).collect(Collectors.toList());

        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(lottoNumbers));

        // when
        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);
        String actual = lottoStatistic.getProfitRate(10000);

        // then
        assertThat(actual).isEqualTo("0.50");
    }

    @Test
    @DisplayName("로또 6개 일치 확인")
    void lottoSixMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new).collect(Collectors.toList());

        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(lottoNumbers));

        // when
        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);
        int actual = lottoStatistic.getRankCount(LottoRank.FIRST_PLACE);

        // then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 5개 일치 확인")
    void lottoFiveMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 45)
                .map(LottoNumber::new).collect(Collectors.toList());

        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(lottoNumbers));

        // when
        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);
        int actual = lottoStatistic.getRankCount(LottoRank.SECOND_PLACE);

        // then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 4개 일치 확인")
    void lottoFourMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 44, 45)
                .map(LottoNumber::new).collect(Collectors.toList());

        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(lottoNumbers));

        // when
        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);
        int actual = lottoStatistic.getRankCount(LottoRank.THIRD_PACE);

        // then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 3개 일치 확인")
    void lottoThreeMatchTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 43, 44, 45)
                .map(LottoNumber::new).collect(Collectors.toList());

        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(lottoNumbers));

        // when
        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);
        int actual = lottoStatistic.getRankCount(LottoRank.FOURTH_PLACE);

        // then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 중복 당첨 확인")
    void lottoMatchOverlapTest() {
        // given
        List<LottoNumber> lottoNumbers1 = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new).collect(Collectors.toList());

        List<LottoNumber> lottoNumbers2 = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new).collect(Collectors.toList());

        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(lottoNumbers1));
        lottoTickets.add(new LottoTicket(lottoNumbers2));

        // when
        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);
        int actual = lottoStatistic.getRankCount(LottoRank.FIRST_PLACE);

        // then
        assertThat(actual).isEqualTo(2);
    }
}
