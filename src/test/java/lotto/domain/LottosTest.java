package lotto.domain;

import lotto.utils.RankEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottoes lottoes;
    private List<LottoGame> lottoGames;

    @BeforeEach
    public void setUp() {
        lottoGames = Arrays.asList(new LottoGame(2L),
                new LottoGame(3L), new LottoGame(4L),
                new LottoGame(5L), new LottoGame(6L));
        lottoes = new Lottoes(lottoGames);
    }


    @Test
    @DisplayName("Lottoes 생성자 테스트")
    public void constructor() {
        assertThat(new Lottoes(Arrays.asList(new LottoGame(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList()))))))
                .isEqualTo(new Lottoes(Arrays.asList(new LottoGame(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList()))))));
    }

    @Test
    @DisplayName("몇등에 당첨 됐는지 확인한다.")
    public void winRankLotto() {
        assertThat(lottoes.getLottoGames().stream()
                .filter(lottoGame -> lottoGame.getMatchedCount() == 3)
                .count())
                .isEqualTo(1);
        assertThat(lottoes.getLottoGames().stream()
                .filter(lottoGame -> lottoGame.getMatchedCount() == 4)
                .count())
                .isEqualTo(1);
        assertThat(lottoes.getLottoGames().stream()
                .filter(lottoGame -> lottoGame.getMatchedCount() == 5)
                .count())
                .isEqualTo(1);
        assertThat(lottoes.getLottoGames().stream()
                .filter(lottoGame -> lottoGame.getMatchedCount() == 6)
                .count())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("총상금을 계산한다.")
    public void calculateTotalReward() {
        Long totalReward;
        totalReward = RankEnum.RANK_THREE.getReward() * lottoes.winRankLottoCount(RankEnum.RANK_THREE.getRank());
        totalReward = totalReward + RankEnum.RANK_FOUR.getReward() * lottoes.winRankLottoCount(RankEnum.RANK_FOUR.getRank());
        totalReward = totalReward + RankEnum.RANK_FIVE.getReward() * lottoes.winRankLottoCount(RankEnum.RANK_FIVE.getRank());
        totalReward = totalReward + RankEnum.RANK_SIX.getReward() * lottoes.winRankLottoCount(RankEnum.RANK_SIX.getRank());
        assertThat(totalReward).isEqualTo(2001555000L);
    }
}
