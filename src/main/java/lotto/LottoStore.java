package lotto;

import calculator.Operation;

import java.util.List;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;
    private static final String REGEX = ", ";

    private Lotto winningLotto;
    private final LottoStorage lottoStorage;

    public LottoStore(int purchaseAmount) {
        int count = calculate(purchaseAmount);
        this.lottoStorage = LottoStorage.create(count);
    }

    private int calculate(int purchaseAmount) {
        return Operation.DIVIDE.apply(purchaseAmount, LOTTO_PRICE);
    }

    public List<Lotto> getLotto() {
        return lottoStorage.copy();
    }

    public void registerWinningLotto(String winningLottoNumbers) {
        String[] stringLottoNumbers = winningLottoNumbers.split(REGEX);
        List<LottoNumber> lottoNumbers = LottoNumber.from(stringLottoNumbers);
        this.winningLotto = Lotto.from(lottoNumbers);
    }
}
