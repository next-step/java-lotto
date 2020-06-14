package lotto.model;

public class LottoResult {
    private LottoLine winner;
    private int bonusNumber;

    public LottoResult(LottoLine line, int bonusNumber) {
        this.winner = line;
        this.bonusNumber = bonusNumber;
    }

    public PrizeEnum lineResult(LottoLine line) {
        return PrizeEnum.getMatchPrizeEnum(
                line.getMatchingNumbers(winner),
                line.containNumber(bonusNumber));
    }
}
