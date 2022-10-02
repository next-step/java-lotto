package lotto.domain;

import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultTest {

    private LottoGame lottoGame;

    @BeforeEach
    void before() {
        lottoGame = new LottoGame(Arrays.asList(
                new Lotto("1,2,3,4,5,6".split(",")),
                new Lotto("1,2,3,4,5,45".split(",")),
                new Lotto("1,2,3,4,44,45".split(",")),
                new Lotto("1,2,3,43,44,45".split(",")),
                new Lotto("1,2,42,43,44,45".split(","))));
    }

    @Test
    @DisplayName("로또 등수별 갯수 구하기")
    void count_group_by_rank() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6".split(","));
        //when
        LottoResult result = lottoGame.getWinningResult(winningNumbers);
        //then
        assertAll(
                () -> assertThat(result.getCount(LottoRank.FIRST)).isEqualTo(1),
                () -> assertThat(result.getCount(LottoRank.SECOND)).isEqualTo(1),
                () -> assertThat(result.getCount(LottoRank.THIRD)).isEqualTo(1),
                () -> assertThat(result.getCount(LottoRank.FOURTH)).isEqualTo(1)
        );
    }

}
