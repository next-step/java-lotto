import model.Lotto;
import model.LottoNumberStrategy;

import java.util.List;

public class LottoMachine {
    public static final int PRICE_OF_A_LOTTO = 1000;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int totalPrice;
    private int numberOfLotto;
    private LottoNumberStrategy lottoNumberStrategy;

    public LottoMachine(
            List<Lotto> lottos,
            List<Integer> winningNumbers,
            int totalPrice,
            LottoNumberStrategy lottoNumberStrategy
    ) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.totalPrice = totalPrice;
        this.lottoNumberStrategy = lottoNumberStrategy;
        this.numberOfLotto = totalPrice / PRICE_OF_A_LOTTO;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public LottoNumberStrategy getLottoNumberStrategy() {
        return lottoNumberStrategy;
    }
}
