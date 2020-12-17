package lotto.domain;

import lotto.util.NumberUtil;

import java.util.List;

public class LottoMachine {
    private LottoBucket lottoBucket;

    public LottoMachine(){
        lottoBucket = new LottoBucket();
    }

    private static final int LOTTO_PRICE = 1000;
    public int exchangeNumberOfLotto(String money) {
        long calcuratableMoney = NumberUtil.stringTolong(money);
        long numberOfLotto = calcuratableMoney / LOTTO_PRICE;
        int lottos = createLottos(numberOfLotto);
        return lottos;
    }

    protected int createLottos(long numberOfLotto) {
        for(int i = 0; i < numberOfLotto; i++){
            lottoBucket.createLotto();
        }
        return lottoBucket.checkNumberOfLottos();
    }

    public LottoBucket getLottoBuckets() {
        return this.lottoBucket;
    }

    public WinningLottos checkWinningNumbers(String lastWinnerNumber) {
        List<Lotto> lottos = lottoBucket.getLottos();
        WinningLottos winningLottos = new WinningLottos();

        for(int i = 0; i < lottos.size(); i++) {
            int matchNumber = lottos.get(i).checkLastWinningNumber(lastWinnerNumber);
            winningLottos.addMatchingNumber(matchNumber);
        }
        return winningLottos;
    }
}
