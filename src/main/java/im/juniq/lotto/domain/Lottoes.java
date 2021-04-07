package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lottoes implements Iterable<Lotto> {

    private final List<Lotto> lottoes;
    private final int autoLottoSize;
    private final int manualLottoSize;

    private Lottoes(List<Lotto> lottoes, int autoLottoSize, int manualLottoSize) {
        this.lottoes = lottoes;
        this.autoLottoSize = autoLottoSize;
        this.manualLottoSize = manualLottoSize;
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

    public Lotto lotto(int index) {
        return lottoes.get(index);
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
        return autoLottoSize;
    }

    public int manualLottoSize() {
        return manualLottoSize;
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoes.iterator();
    }
}
