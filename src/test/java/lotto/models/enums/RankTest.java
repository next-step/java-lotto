package lotto.models.enums;

import lotto.models.Lotto;
import lotto.models.WinningLotto;
import lotto.models.request.WinningLottoRequest;
import lotto.services.LottoStatisticsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    private static final List<Lotto> lottos = new ArrayList<>();
    private static final String WINNING_NUMBER = "1, 2, 3, 4, 5, 6";
    private static final int BONUS_NUMBER = 7;
    private static WinningLotto winningLotto;

    @BeforeAll
    static void setLotto() {
        lottos.add(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.of(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(Lotto.of(List.of(1, 2, 3, 4, 5, 10)));
        lottos.add(Lotto.of(List.of(1, 2, 3, 4, 10, 11)));
        lottos.add(Lotto.of(List.of(1, 2, 3, 10, 11, 12)));
        lottos.add(Lotto.of(List.of(1, 2, 10, 11, 12, 13)));
        lottos.add(Lotto.of(List.of(1, 10, 11, 12, 13, 14)));
        lottos.add(Lotto.of(List.of(10, 11, 12, 13, 14, 15)));
    }

    @BeforeAll
    static void setWinningLotto() {
        WinningLottoRequest winningLottoRequest = new WinningLottoRequest(WINNING_NUMBER, BONUS_NUMBER);
        winningLotto = WinningLotto.from(winningLottoRequest);
    }

    @ParameterizedTest
    @CsvSource({"0, FIRST", "1, SECOND", "2, THIRD", "3, FOURTH", "4, FIFTH", "5, OTHER", "6, OTHER", "7, OTHER"})
    @DisplayName("맞춘 숫자에 따라 알맞는 Rank enum을 생성한다.")
    void getRank1(int index, Rank rank) {
        assertThat(Rank.findRank(winningLotto, lottos.get(index))).isEqualTo(rank);
    }
}
