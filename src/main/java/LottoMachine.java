import model.Lotto;
import model.LottoNumberStrategy;
import model.LottoStatistics;
import model.Prize;
import view.InputView;
import view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoMachine {
    public static final int PRICE_OF_A_LOTTO = 1000;

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int totalPrice;
    private List<List<Integer>> lottoNumbers;

    public LottoMachine(
            List<Integer> winningNumbers,
            int totalPrice,
            List<List<Integer>> lottoNumbers
    ) {
        this.winningNumbers = winningNumbers;
        this.totalPrice = totalPrice;
        this.lottoNumbers = lottoNumbers;
        this.lottos = this.lottoNumbers.stream()
                .map(Lotto::new)
                .peek(it -> it.calPrize(this.winningNumbers))
                .collect(Collectors.toList());
        this.lottos.forEach(it -> it.calPrize(this.winningNumbers));
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
        return this.totalPrice / PRICE_OF_A_LOTTO;
    }

    public LottoStatistics getStatistics() {
        List<Prize> prizes = getPrizes(this.lottos);
        Map<Integer, Integer> counts = getCounts(prizes);
        return new LottoStatistics(counts, this.totalPrice);
    }

    private Map<Integer, Integer> getCounts(List<Prize> prizes) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(3, 0);
        counts.put(4, 0);
        counts.put(5, 0);
        counts.put(6, 0);
        for (Prize prize : prizes) {
            counts.put(prize.getMatched(), counts.get(prize.getMatched()) + 1);
        }
        return counts;
    }

    private List<Prize> getPrizes(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getPrize)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int money = InputView.getPaidMoney();
        ResultView.printNumberOfLotto(money, PRICE_OF_A_LOTTO);

        LottoNumberStrategy lottoNumberStrategy = new LottoNumberStrategy() {
        };
        List<List<Integer>> lottoNumbers = lottoNumberStrategy.create(money, PRICE_OF_A_LOTTO);
        ResultView.printLottoNumbers(lottoNumbers);

        List<Integer> winningNumbers = InputView.getWinningNumbers();

        LottoMachine lottoMachine = new LottoMachine(
                winningNumbers,
                money,
                lottoNumbers
        );

        ResultView.printLottoStatistics(lottoMachine.getStatistics());
    }
}
