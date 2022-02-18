package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class User {
    
    private final int autoCount;
    private final int manualCount;
    private final List<Lotto> lottos;
    private final Statistics statistics;
    
    public User(int count, List<Lotto> manualLottos) {
        this.manualCount = manualLottos.size();
        this.autoCount = count - manualCount;
        for (int i = 0; i < autoCount; i++) {
            manualLottos.add(new Lotto(makeRandomNumbers()));
        }
        this.lottos = manualLottos;
        this.statistics = new Statistics();
    }
    
    private List<Integer> makeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> lottoNum = LottoRules.getLottoNums();
        Collections.shuffle(lottoNum);
        for (int i = 0; i < LottoRules.LOTTO_COUNT; i++) {
            numbers.add(lottoNum.get(i));
        }
        Collections.sort(numbers);
        return numbers;
    }
    
    public List<Lotto> getLottos() {
        return this.lottos;
    }
    
    public Map<Rank, Integer> getRanks() {
        return statistics.getRanks();
    }
    
    public void setRanks(WinningNumber winningNumber) {
        statistics.setRanks(winningNumber, lottos);
    }
    
    public int getLottoCount() {
        return manualCount + autoCount;
    }
    
}
