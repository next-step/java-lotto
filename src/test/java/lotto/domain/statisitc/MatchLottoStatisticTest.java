package lotto.domain.statisitc;

import lotto.domain.item.LottoTicket;
import lotto.domain.item.MatchLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

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
}
