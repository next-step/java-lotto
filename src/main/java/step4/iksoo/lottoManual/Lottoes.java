package step4.iksoo.lottoManual;

import java.util.*;
import java.util.stream.IntStream;

public class Lottoes {
    private final int PRICE_OF_LOTTO = 1000;

    private List<Lotto> lottoes;

    Lottoes() {
        this.lottoes = new ArrayList<>();
    }

    Lottoes(int orderPrice, List<String> manualLotto) {
        this.lottoes = buyManualLotto(manualLotto);
        add(buyAutoLotto(orderPrice / PRICE_OF_LOTTO - manualLotto.size()));
    }

    private List<Lotto> buyManualLotto(List<String> orderManualLotto) {
        List<Lotto> lottoManual = new ArrayList<>();
        IntStream.range(0, orderManualLotto.size())
                .boxed()
                .map(manualCount -> new LottoManualSplit(orderManualLotto.get(manualCount)))
                .forEach(lottoManualSplit -> lottoManual.add(new Lotto(lottoManualSplit.getLottoNumbers())));
        return lottoManual;
    }

    private List<Lotto> buyAutoLotto(int orderCount) {
        List<Lotto> lottoAuto = new ArrayList<>();
        IntStream.range(0, orderCount)
                .boxed()
                .forEach(n -> lottoAuto.add(new Lotto()));
        return lottoAuto;
    }

    public void add(List<Lotto> lottoes) {
        lottoes.stream()
                .forEach(this.lottoes::add);
    }

    public Map<Rank, Integer> checkLotteryWin(Lotto winnerNumbers, LottoNo bonusBall) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottoes lottoes1 = (Lottoes) o;
        return PRICE_OF_LOTTO == lottoes1.PRICE_OF_LOTTO &&
                Objects.equals(lottoes, lottoes1.lottoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PRICE_OF_LOTTO, lottoes);
    }
}
