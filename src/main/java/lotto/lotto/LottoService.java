package lotto.lotto;

public class LottoService {

    public LottoResult createLotto(int price) {
        LottoGeneratorStrategy autoLottoStrategy = new AutoLottoStrategy();
        LottoMachine machine = new LottoMachine(price, autoLottoStrategy);
        machine.createLottos();

        LottoResult result = new LottoResult(machine.getLottos());
        return result;
    }

    public void calculateLotto(String answer, LottoResult result, int bonusNumber) {
        LottoWinning winning = new LottoWinning(answer, bonusNumber);
        result.calculateLotto(winning);
    }

    public LottoMargin calculateMarginRate(int price, LottoResult result) {
        return new LottoMargin(price, result.getResultMap());
    }
}
