package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottoes implements Iterable<Lotto> {

    private final List<Lotto> lottoes;

    private Lottoes(List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public static Lottoes of(int numberOfCreated, ShuffleStrategy shuffleStrategy) {
        return of(numberOfCreated, shuffleStrategy, new ArrayList<>());
    }

    public static Lottoes of(int numberOfCreated, ShuffleStrategy shuffleStrategy, List<LottoNumbers> manualLottoes) {
        return new Lottoes(makeLottoes(numberOfCreated - manualLottoes.size(), shuffleStrategy, manualLottoes));
    }

    public static Lottoes from(List<Lotto> lottoes) {
        return new Lottoes(lottoes);
    }

    private static List<Lotto> makeLottoes(int numberOfAutoCreated, ShuffleStrategy shuffleStrategy,
            List<LottoNumbers> manualLottoes) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < numberOfAutoCreated; i++) {
            lottoes.add(Lotto.from(shuffleStrategy));
        }
        for (LottoNumbers lottoNumbers : manualLottoes) {
            lottoes.add(Lotto.from(lottoNumbers));
        }
        return lottoes;
    }

    public int numberOfLottoesMatched(Winning winning, WinningNumbers winningNumbers) {
        return lottoes.stream().mapToInt(lotto -> countMatchedLottoes(winning, lotto, winningNumbers)).sum();
    }

    private int countMatchedLottoes(Winning winning, Lotto lotto, WinningNumbers winningNumbers) {
        if (lotto.winning(winningNumbers) == winning) {
            return 1;
        }
        return 0;
    }

    public double yield(WinningNumbers winningNumbers, Price price) {
        return price.yield((double) totalPrize(winningNumbers));
    }

    private long totalPrize(WinningNumbers winningNumbers) {
        return lottoes.stream().mapToLong(lotto -> lotto.prize(winningNumbers)).sum();
    }

    public int autoLottoSize() {
        return (int) lottoes.stream().filter(lotto -> !lotto.isManual()).count();
    }

    public int manualLottoSize() {
        return (int) lottoes.stream().filter(Lotto::isManual).count();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoes.iterator();
    }
}
