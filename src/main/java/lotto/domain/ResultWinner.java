package lotto.domain;

import java.util.EnumMap;

public class ResultWinner {

    public EnumMap<Rank, Integer> countOfWinner(Lottos lottos, WinningNumber winningNumber) {
        EnumMap<Rank, Integer> resultMap = makeResultMap();
        for (int i = 0; i < lottos.getLottosSize(); i++) {
            Rank rank = getAnswerCount(lottos.getLottoIndex(i), winningNumber);
            resultMap.compute(rank, (key, value) -> value + 1);
        }
        return resultMap;
    }

    private EnumMap<Rank, Integer> makeResultMap() {
        EnumMap<Rank, Integer> resultMap = new EnumMap<>(Rank.class);
        for (Rank constant : Rank.values()) {
            resultMap.put(constant, 0);
        }
        return resultMap;
    }

    private Rank getAnswerCount(Lotto buyLotto, WinningNumber winningNumber) {
        int matchCount = winningNumber.matchNumbers(buyLotto);
        boolean checkBonusNumber = winningNumber.matchBonusNumber(buyLotto);

        return Rank.valueOf(matchCount, checkBonusNumber);
    }

}
