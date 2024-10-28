package lotto.lotto;

public class LottoService {

    public LottoMachine createLottoMachine(int price, int manualCnt) {
        LottoMachine lottoMachine = new LottoMachine(price, manualCnt);
        return lottoMachine;
    }

    public Lottos createLotto(LottoMachine lottoMachine, String[] inputLottos) {
        LottoParameters lottoParameters = new LottoParameters(inputLottos, lottoMachine.getAutoCnt());

        Lottos autoLottos = lottoMachine.createLottos(new AutoLottoStrategy(), lottoParameters);
        Lottos manuaLottos = lottoMachine.createLottos(new ManualLottoStrategy(), lottoParameters);

        return new Lottos(autoLottos.getLottos(), manuaLottos.getLottos());
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
