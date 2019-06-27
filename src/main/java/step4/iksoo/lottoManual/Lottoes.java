package step4.iksoo.lottoManual;

import java.util.*;
import java.util.stream.IntStream;

public class Lottoes {
    private final int PRICE_OF_LOTTO = 1000;

    private List<Lotto> lottoes;

    Lottoes(int orderPrice, int orderManualLotto) {
        this.lottoes = buyLotto(orderPrice, orderManualLotto);
    }

    private List<Lotto> buyLotto(int orderPrice, int orderManualLotto) {
        List<Lotto> lottoBox = buyManualLotto(orderManualLotto);

        IntStream.range(0, (orderPrice / PRICE_OF_LOTTO) - orderManualLotto)
                .boxed()
                .forEach(n -> lottoBox.add(new Lotto()));

        //OutputView.printOrderCheck(lottoBox.size(), orderManualLotto);
        return lottoBox;
    }

    private List<Lotto> buyManualLotto(int orderManualLotto) {
        List<Lotto> lottoManual = new ArrayList<Lotto>();
        OutputView.printAskManualNumbers();

        IntStream.range(0, orderManualLotto)
                .boxed()
                .map(n -> new LottoManualSplit(InputView.inputText()))
                .forEach(lottoManualSplit -> lottoManual.add(new Lotto(lottoManualSplit.getLottoNumbers())));
        return lottoManual;
    }

    public void add(Lotto lotto) {
        this.lottoes.add(lotto);
    }

    public Map<Rank, Integer> checkLotteryWin(List<Integer> winnerNumbers, int bonusBall) {
        Map<Rank, Integer> matchResult = new HashMap<>();

        Arrays.stream(Rank.values())
                .forEach(rank -> matchResult.put(rank, 0));

        this.lottoes
                .stream()
                .map(lotto -> lotto.checkNumberOfMatches(winnerNumbers, bonusBall))
                .filter(rank -> rank.getCountOfMatch() >= Rank.FIFTH.getCountOfMatch())
                .forEach(rank -> matchResult.put(rank, matchResult.get(rank) + 1));

        return matchResult;
    }

    public List<Lotto> getLottoes() {
        return this.lottoes;
    }
}
