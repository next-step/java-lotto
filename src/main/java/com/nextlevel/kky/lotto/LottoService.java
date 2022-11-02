package com.nextlevel.kky.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private final IntegerArrayGenerator integerArrayGenerator;

    public LottoService(IntegerArrayGenerator integerArrayGenerator) {
        this.integerArrayGenerator = integerArrayGenerator;
    }

    public List<Lotto> buyLotto(int amount) {
        int count = amount / LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>(amount);
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(integerArrayGenerator.getIntegerArray()));
        }
        return lottoList;
    }

    public WinningStatistics calculateWinningStatistics(Lotto winningNumbers, List<Lotto> lottoList) {
        WinningStatistics winningStatistics = new WinningStatistics();
        for (Lotto lotto : lottoList) {
            int matchCount = getMatchCount(winningNumbers, lotto);
            int originalCount = winningStatistics.getWinningMap().get(matchCount);
            winningStatistics.getWinningMap().replace(matchCount, ++originalCount);
        }
        return winningStatistics;
    }

    public int getMatchCount(Lotto winningNumbers, Lotto lotto) {
        Stream<Integer> matchStream = lotto.getNumbers().stream()
                .filter(number -> winningNumbers.getNumbers().contains(number));

        return (int) matchStream.count();
    }
}
