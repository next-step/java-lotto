package lotto.domain;

import lotto.constant.Rank;

import java.util.EnumMap;

public class LottoGame {
    private final Lottoes lottoes;
    private final WinningNumbers winningNumbers;

    public LottoGame(Lottoes lottoes, WinningNumbers winningNumbers) {
        this.lottoes = lottoes;
        this.winningNumbers = winningNumbers;
    }

    public LottoGameResult getResult() {
        EnumMap<Rank, Integer> result = initEnumMap();
        for (LottoNumbers lottoNumber : lottoes.getValue()) {
            Rank rank = winningNumbers.getRank(lottoNumber);
            int rankCount = result.get(rank);
            result.put(rank, rankCount + 1);
        }
        return new LottoGameResult(result);
    }

    private EnumMap<Rank, Integer> initEnumMap() {

        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);

        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);

        return result;
    }
}
