package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("로또 매칭 결과 테스트")
public class LottoStatisticTest {

    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 당첨 확인")
    void lottoMatchTwoTest() {
        // given
        List<LottoNumber> sixMatchLottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new).collect(Collectors.toList());

        List<LottoNumber> fiveMatchLottoNumbers2 = Stream.of(1, 2, 3, 4, 5, 45)
                .map(LottoNumber::new).collect(Collectors.toList());

        List<LottoNumber> FourMatchLottoNumbers3 = Stream.of(1, 2, 3, 4, 44, 45)
                .map(LottoNumber::new).collect(Collectors.toList());


        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(sixMatchLottoNumbers));
        lottoTickets.add(new LottoTicket(fiveMatchLottoNumbers2));
        lottoTickets.add(new LottoTicket(FourMatchLottoNumbers3));

        // when
        LottoStatistic lottoStatistic = lottoTickets.matching(winningNumbers);
        int countMatchSix = lottoStatistic.getRankCount(LottoRank.FIRST_PLACE);
        int countMatchFive = lottoStatistic.getRankCount(LottoRank.SECOND_PLACE);
        int countMatchFour = lottoStatistic.getRankCount(LottoRank.THIRD_PACE);
        int countMatchThree = lottoStatistic.getRankCount(LottoRank.FOURTH_PLACE);

        // then
        assertAll(
                () -> assertThat(countMatchSix).isEqualTo(1),
                () -> assertThat(countMatchFive).isEqualTo(1),
                () -> assertThat(countMatchFour).isEqualTo(1),
                () -> assertThat(countMatchThree).isEqualTo(0)
        );
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
        Double profitRate = lottoStatistic.getProfitRate(10000);
        String actual = String.format("%.2f", profitRate);

        // then
        assertThat(actual).isEqualTo("0.50");
    }
}
