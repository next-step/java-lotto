package lotto.domain;

import java.util.EnumMap;

public class ResultWinner {

    static final int HIT_FICE_LOTTO_NUMBERS = 5;

    public EnumMap<Rank, Integer> countOfWinner(Lottos lottos, WinningNumber winningNumber) {
        EnumMap<Rank, Integer> resultMap = makeResultMap();
        for (int i = 0; i < lottos.getLottosSize(); i++) {
            Rank rank = getAnswerCount(lottos.getLottoIndex(i), winningNumber);
            resultMap.put(rank, resultMap.get(rank) + 1);
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

        Rank second = getRankSecond(matchCount, checkBonusNumber);
        if (second != null) {
            return second;
        }
        return Rank.valueOf(matchCount);
    }

    private Rank getRankSecond(int matchCount, boolean checkBonusNumber) {
        if (matchCount == HIT_FICE_LOTTO_NUMBERS && checkBonusNumber) {
            return Rank.SECOND;
        }
        return null;
    }
}
