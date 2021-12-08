package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankingBoardTest {
    @Test
    @DisplayName("로또 리스트와 당첨번호가 주어졌을 때 로또의 당첨 통계를 반환한다")
    void testGetLottoRankings() {
        // Given
        LottoRankingBoard lottoRankingBoard = new LottoRankingBoard();
        Lotto winningLotto = new Lotto(buildLottoNumbers(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(buildLottoNumbers(1, 2, 3, 4, 5, 6)),
                new Lotto(buildLottoNumbers(1, 2, 3, 4, 5, 36)),
                new Lotto(buildLottoNumbers(1, 2, 3, 4, 35, 36)),
                new Lotto(buildLottoNumbers(1, 2, 3, 4, 35, 36)),
                new Lotto(buildLottoNumbers(1, 2, 3, 34, 35, 36)),
                new Lotto(buildLottoNumbers(1, 2, 33, 34, 35, 36)));

        // When
        EnumMap<Rank, Integer> result = lottoRankingBoard.getLottoRankings(lottoList, winningLotto);

        // Then
        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(2);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.get(Rank.NOTHING)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등 1개, 3등 2개, 4등 1개 당첨인 경우 총 1,605,000 원을 반환한다")
    void testGetTotalReward() {
        // Given
        LottoRankingBoard lottoRankingBoard = new LottoRankingBoard();
        Lotto winningLotto = new Lotto(buildLottoNumbers(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(buildLottoNumbers(1, 2, 3, 4, 5, 36)),
                new Lotto(buildLottoNumbers(1, 2, 3, 4, 35, 36)),
                new Lotto(buildLottoNumbers(1, 2, 3, 4, 35, 36)),
                new Lotto(buildLottoNumbers(1, 2, 3, 34, 35, 36)));
        EnumMap<Rank, Integer> result = lottoRankingBoard.getLottoRankings(lottoList, winningLotto);

        // When
        long totalReward = lottoRankingBoard.getTotalReward(result);

        // Then
        assertThat(totalReward).isEqualTo(1_605_000);
    }

    private static LottoNumbers buildLottoNumbers(int... numbers) {
        return new LottoNumbers(
                Arrays.stream(numbers)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toList()));
    }
}
