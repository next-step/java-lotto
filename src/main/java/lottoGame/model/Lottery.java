package lottoGame.model;

import lottoGame.WinningRanks;
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
    public void putBoard(List<Integer> winningNum, EnumMap<WinningRanks, Integer> lotteryBoard) {
        for (WinningRanks winningRanks : WinningRanks.values()) {
            lotteryBoard.put(winningRanks, Collections.frequency(findMatchNumber(winningNum), winningRanks.getMatchNum()));
        }
    }
    private List<Integer> findMatchNumber(List<Integer> winningNumer) {
        return lottery.stream()
                .map(lotto -> lotto.isContain(winningNumer))
                .filter(match -> match >= WinningRanks.FOURTH.getMatchNum())
                .collect(Collectors.toList());
    }


}
