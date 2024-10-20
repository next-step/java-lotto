package lotto.lotto;

public class LottoService {

    public LottoResult createLotto(int price) {
        LottoGenerator generator = new Lotto();
        LottoMachine machine = new LottoMachine(price, generator);
        machine.createLottos();

        LottoResult result = new LottoResult(machine.getLottos());
        return result;
    }

    public void calculateLotto(String answer, LottoResult result) {
        LottoWinning winning = new LottoWinning(answer);
        result.calculateLotto(winning);
    }

    public LottoMargin calculateMarginRate(int price, LottoResult result) {
        return new LottoMargin(price, result.getResultMap());
    }
}
