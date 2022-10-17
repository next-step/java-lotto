package lottoGame.model;

import lottoGame.WinningNumbers;
import lottoGame.model.factory.LottoFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class Lottery {
    private final List<Lotto> lottery = new ArrayList<>();

    public List<Lotto> getLottery() {
        return lottery;
    }

    public List<Lotto> create(int lotteryNum, LottoFactory lottoFactory) {
        for (int i = 0; i < lotteryNum; i++) {
            lottery.add(lottoFactory.createLotto());
        }
        return lottery;
    }
    public void putBoard(List<Integer> winningNum, EnumMap<WinningNumbers, Integer> lotteryBoard) {
        for (WinningNumbers winningNumbers : WinningNumbers.values()) {
            lotteryBoard.put(winningNumbers, Collections.frequency(findMatchNumber(winningNum), winningNumbers.getNumberOfWins()));
        }
    }
    private List<Integer> findMatchNumber(List<Integer> winningNumer) {
        return lottery.stream()
                .map(lotto -> lotto.isContain(winningNumer))
                .filter(match -> match >= WinningNumbers.FOURTH.getNumberOfWins())
                .collect(Collectors.toList());
    }


}
