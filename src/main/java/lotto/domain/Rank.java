package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    private static Rank valueOf(int countOfMatch) {
        return Arrays.stream(Rank.values())
                .filter(r -> r.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    public static Rank getRank(LottoNumbers lottoNumbers, LottoNumbers winnerLottoNumbers) {
        int count = getCount(lottoNumbers, winnerLottoNumbers);

        if (count == THIRD.getCountOfMatch()) {
            return lottoNumbers.getLottoNumberList().contains(winnerLottoNumbers.getBonusNumber()) ? Rank.SECOND : Rank.THIRD;
        }

        return valueOf(count);
    }

    private static int getCount(LottoNumbers lottoNumbers, LottoNumbers winnerLottoNumbers) {
        return (int) lottoNumbers.getLottoNumberList()
                .stream()
                .filter(winnerLottoNumbers.getLottoNumberList()::contains)
                .count();
    }
}
