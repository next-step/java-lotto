package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<LottoNumbers> lotto;

    public Lotto(int count, LottoGenerator lottoGenerator){
        List<LottoNumbers> lotto = new ArrayList<>();

        for(int i = 0; i < count; i++){
            lotto.add(new LottoNumbers(lottoGenerator.randomNumber()));
        }

        this.lotto = lotto;
    }

    public Lotto(List<LottoNumbers> lotto){
        this.lotto = lotto;
    }

    public List<LottoNumbers> lotto() { return lotto; }

    public int count() { return lotto.size(); }

    public Map<Integer, Integer> match(List<Integer> lastWinningNumbers){
        Map<Integer, Integer> winningCounts = new HashMap<>();

        for(LottoNumbers lottoNumbers : lotto){
            int matchCount = lottoNumbers.matchCount(lastWinningNumbers);
            winningCounts.merge(matchCount, 1, Integer::sum);
        }

        return winningCounts;
    }
}
