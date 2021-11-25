package lotto.domain;

import lotto.utils.RankEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.utils.Constants.NUMBER_ZERO;

public class Lottoes {
    private List<LottoGame> lottoGames;
    private Long totalReward;

    public Lottoes() {
        this.lottoGames = new ArrayList<>();
    }

    public Lottoes(List<LottoGame> lottoGames) {
        this.lottoGames = lottoGames;
    }

    public Lottoes(Long totalReward) {
        this.totalReward = totalReward;
    }

    public void makeLottoes(LottoGameCount lottoGameCount) {
        for (int i = NUMBER_ZERO; i < lottoGameCount.getLottoGameCount(); i++) {
            lottoGames.add(new LottoGame(new LottoNumbers().createAutoLottoNumbers()));
        }
    }

    public Long winRankLottoCount(Long rankCount) {
        return lottoGames.stream()
                .filter(lottoGame -> lottoGame.getMatchedCount() == rankCount)
                .count();
    }

    public void calculateTotalReward() {
        totalReward = RankEnum.RANK_THREE.getReward() * winRankLottoCount(RankEnum.RANK_THREE.getRank());
        totalReward = totalReward + RankEnum.RANK_FOUR.getReward() * winRankLottoCount(RankEnum.RANK_FOUR.getRank());
        totalReward = totalReward + RankEnum.RANK_FIVE.getReward() * winRankLottoCount(RankEnum.RANK_FIVE.getRank());
        totalReward = totalReward + RankEnum.RANK_SIX.getReward() * winRankLottoCount(RankEnum.RANK_SIX.getRank());
    }

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }

    public Long getTotalReward() {
        return totalReward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottoes lottoes = (Lottoes) o;
        return Objects.equals(lottoGames, lottoes.lottoGames) &&
                Objects.equals(totalReward, lottoes.totalReward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGames, totalReward);
    }
}
