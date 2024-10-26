package lotto.lotto;

public class LottoService {

    public Lottos createLotto(int price) {
        LottoGeneratorStrategy autoLottoStrategy = new AutoLottoStrategy();
        LottoMachine lottoMachine = new LottoMachine(price, autoLottoStrategy);
        return lottoMachine.createLottos();
    }

    public LottoResult calculateLottoRank(String answer, Lottos lottos, int bonusNumber) {
        LottoWinning winning = new LottoWinning(answer, bonusNumber);
        LottoResult result = new LottoResult();

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = winning.matchCount(lotto);
            boolean isBonusMatch = lotto.containNumber(winning.getBonusNumber());
            LottoRank rank = LottoRank.findWinPrice(matchCount, isBonusMatch);
            result.updateResult(rank);
        }
        return result;
    }

    public LottoMargin calculateMarginRate(int price, LottoResult result) {
        return new LottoMargin(price, result.getResultMap());
    }
}
