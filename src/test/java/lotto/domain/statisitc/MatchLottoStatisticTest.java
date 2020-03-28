package lotto.domain.statisitc;

import lotto.domain.item.LottoTicket;
import lotto.domain.item.MatchLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MatchLottoStatisticTest {

    private List<Integer> numbers;

    private static Stream<Arguments> provideMatchNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 10), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 10, 11), 4),
                Arguments.of(Arrays.asList(1, 10, 11, 12, 13, 14, 15), 1),
                Arguments.of(Arrays.asList(10, 11, 12, 13, 14, 15, 16), 0)
        );
    }

    @DisplayName("매칭된 로또 항목 리스트에 저장 테스트")
    @Test
    public void construtor() throws Exception {
        //given
        MatchLotto lotto = new MatchLotto(0, new LottoTicket());
        MatchLottoStatistic matchLottoStatistic = new MatchLottoStatistic(lotto);

        //when
        matchLottoStatistic.addMatchItem(1, new LottoTicket());
        matchLottoStatistic.addMatchItem(1, new LottoTicket());
        matchLottoStatistic.addMatchItem(1, new LottoTicket());
        matchLottoStatistic.addMatchItem(3, new LottoTicket());

        //then
        assertAll(
                () -> assertThat(matchLottoStatistic.size()).isEqualTo(3),
                () -> assertThat(matchLottoStatistic.getMatchLottos().get(0).getItemsCount()).isEqualTo(1),
                () -> assertThat(matchLottoStatistic.getMatchLottos().get(1).getItemsCount()).isEqualTo(3),
                () -> assertThat(matchLottoStatistic.getMatchLottos().get(2).getItemsCount()).isEqualTo(1)
        );
    }

    @DisplayName("당첨번호에 매칭된 또 정렬해서 저장 확인")
    @Test
    public void lottoCompare() throws Exception {
        //given
        List<Integer> luckyNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoTicket> lottos = new ArrayList<>(Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 10)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 11)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 10, 11)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 10, 12)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 10, 13)),
                new LottoTicket(Arrays.asList(1, 2, 3, 12, 13, 14)),
                new LottoTicket(Arrays.asList(1, 2, 12, 13, 14, 15)),
                new LottoTicket(Arrays.asList(1, 11, 12, 13, 14, 15))
        ));

        MatchLottoStatistic statistic = new MatchLottoStatistic();

        //when
        statistic.collectMatchLotto(lottos, luckyNumber);

        //then
        assertAll(
                () -> assertThat(statistic.findMatchCount3Lottos()).isEqualTo(1),
                () -> assertThat(statistic.findMatchCount4Lottos()).isEqualTo(3),
                () -> assertThat(statistic.findMatchCount5Lottos()).isEqualTo(2),
                () -> assertThat(statistic.findMatchCount6Lottos()).isEqualTo(1)
        );
    }

}
