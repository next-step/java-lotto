package lotto.models.enums;

import lotto.models.IssuedLotto;
import lotto.models.Lotto;
import lotto.models.WinningLotto;
import lotto.models.request.LottoNumberRequest;
import lotto.models.request.WinningLottoRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    private static final List<IssuedLotto> lottos = new ArrayList<>();
    private static final String WINNING_NUMBER = "1, 2, 3, 4, 5, 6";
    private static final int BONUS_NUMBER = 7;
    private static WinningLotto winningLotto;

    @BeforeAll
    static void setLotto() {
        List<LottoNumberRequest> lottoNumberRequest = new ArrayList<>();
        lottoNumberRequest.add(LottoNumberRequest.of("1, 2, 3, 4, 5, 6"));
        lottoNumberRequest.add(LottoNumberRequest.of("1, 2, 3, 4, 5, 7"));
        lottoNumberRequest.add(LottoNumberRequest.of("1, 2, 3, 4, 5, 10"));
        lottoNumberRequest.add(LottoNumberRequest.of("1, 2, 3, 4, 10, 11"));
        lottoNumberRequest.add(LottoNumberRequest.of("1, 2, 3, 10, 11, 12"));
        lottoNumberRequest.add(LottoNumberRequest.of("1, 2, 10, 11, 12, 13"));
        lottoNumberRequest.add(LottoNumberRequest.of("1, 10, 11, 12, 13, 14"));
        lottoNumberRequest.add(LottoNumberRequest.of("10, 11, 12, 13, 14, 15"));

        lottoNumberRequest.forEach(req -> lottos.add(IssuedLotto.from(req)));
    }

    @BeforeAll
    static void setWinningLotto() {
        WinningLottoRequest winningLottoRequest = WinningLottoRequest.of(LottoNumberRequest.of(WINNING_NUMBER), BONUS_NUMBER);
        winningLotto = WinningLotto.from(winningLottoRequest);
    }

    @ParameterizedTest
    @CsvSource({"0, FIRST", "1, SECOND", "2, THIRD", "3, FOURTH", "4, FIFTH", "5, OTHER", "6, OTHER", "7, OTHER"})
    @DisplayName("맞춘 숫자에 따라 알맞는 Rank enum을 생성한다.")
    void getRank1(int index, Rank rank) {
        assertThat(Rank.findRank(winningLotto, lottos.get(index))).isEqualTo(rank);
    }
}
