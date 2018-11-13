package lotto.domain;

import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BundleLotto {
    private List<Lotto> lottos;

    public BundleLotto() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<LottoDto> getLottoResult(Map<Rank, Integer> lottoRankMap, WinningLotto winningNumbers) {
        List<LottoDto> lottoDtos = new ArrayList<>();

        for (Lotto lotto : this.lottos) {
            int count = 0;
            Rank rank = getRank(winningNumbers, lotto, count);

            makeLottoRankMap(lottoRankMap, rank);
        }

        for (Rank key : lottoRankMap.keySet()) {
            lottoDtos.add(makeLottoDto(lottoRankMap.get(key), key));
        }

        return lottoDtos;
    }

    private LottoDto makeLottoDto(int countResult, Rank rank) {
        LottoDto lottoDto = new LottoDto(rank, countResult, rank.getWinningMoney() * countResult);
        return lottoDto;
    }

    private void makeLottoRankMap(Map<Rank, Integer> lottoRankMap, Rank rank) {
        if (!rank.isMiss()) {
            lottoRankMap.put(rank, lottoRankMap.get(rank)+1);
        }
    }

    private Rank getRank(WinningLotto winningNumbers, Lotto lotto, int count) {
        boolean matchBonus = false;
        count = winningNumbers.getRankCount(lotto, count);

        if (Rank.FOURTH.equals(count) && lotto.isBonusBallInLotto(winningNumbers.getBonusBall())) {
            count++;
            matchBonus = true;
        }

        return Rank.valueOf(count, matchBonus);
    }
}
