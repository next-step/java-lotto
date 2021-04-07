package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lottoes implements Iterable<Lotto> {

    private final List<Lotto> lottoes;

    private Lottoes(List<Lotto> lottoes, int autoLottoSize, int manualLottoSize) {
        this.lottoes = lottoes;
    }

    public static Lottoes of(int numberOfCreated, ShuffleStrategy shuffleStrategy, List<LottoNumbers> manualLottoes) {
        int manualLottoesSize = manualLottoes.size();
        int autoLottoSize = numberOfCreated - manualLottoesSize;
        List<Lotto> lottos = makeLottoes(manualLottoes);
        lottos.addAll(makeLottoes(autoLottoSize, shuffleStrategy));
        return new Lottoes(lottos, autoLottoSize, manualLottoesSize);
    }

    public static Lottoes of(int numberOfCreated, ShuffleStrategy shuffleStrategy) {
        return of(numberOfCreated, shuffleStrategy, new ArrayList<>());
    }

    public static Lottoes of(Lotto... lottoes) {
        return new Lottoes(Arrays.asList(lottoes), 0, 0);
    }

    public static Lottoes of(List<Lotto> lottoes) {
        return new Lottoes(lottoes, 0, 0);
    }

    private static List<Lotto> makeLottoes(int numberOfCreated, ShuffleStrategy shuffleStrategy) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < numberOfCreated; i++) {
            lottoes.add(Lotto.of(shuffleStrategy));
        }
        return lottoes;
    }

    private static List<Lotto> makeLottoes(List<LottoNumbers> manualLottoes) {
        List<Lotto> lottoes = new ArrayList<>();
        for (LottoNumbers lottoNumbers : manualLottoes) {
            lottoes.add(Lotto.of(lottoNumbers));
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
