package step3.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public int size() {
        return lottos.size();
    }

    public LinkedHashMap<LottoRank, Integer> matchingResult(WinningNumbers winningNumbers) {
        LinkedHashMap<LottoRank, Integer> result = new LinkedHashMap<>();
        for(Lotto lotto: lottos){
            int matchCount = winningNumbers.matchCount(lotto);
            boolean matchBonus = winningNumbers.containBonus(lotto);
            LottoRank lottoRank = LottoRank.valueOf(matchCount, matchBonus);
            result.put(lottoRank, result.getOrDefault(lottoRank, 0) + 1);
        }
        return result;
    }
}
