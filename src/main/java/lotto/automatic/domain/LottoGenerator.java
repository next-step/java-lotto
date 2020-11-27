package lotto.automatic.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private final List<Integer> lottoNum;
    private final ShuffleStrategy strategy;

    public LottoGenerator(ShuffleStrategy strategy) {
        this.strategy = strategy;
        this.lottoNum = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            lottoNum.add(i);
        }
    }

    public List<Lotto> generateLotto(int countOfLotto) {

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < countOfLotto; i++) {
            strategy.shuffle(lottoNum);
            lottoList.add(new Lotto(lottoNum.stream()
                    .limit(6)
                    .collect(Collectors.toList())));
        }

        return lottoList;
    }

}
