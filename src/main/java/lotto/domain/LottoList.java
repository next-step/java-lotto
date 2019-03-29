package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoList {

    private List<Lotto> lottos;

    public LottoList() {
        this.lottos = new ArrayList<>();
    }

    public LottoList(final int lottoSize) {
        if (lottoSize < 1) {
            throw new IllegalArgumentException("1 OR MORE");
        }

        lottos = new ArrayList<>(lottoSize);

        IntStream.range(0, lottoSize)
            .forEach(i -> lottos.add(new Lotto()));
    }

    public LottoList(List<Lotto> manualLottos) {
        this.lottos = manualLottos;
    }

    public LottoList(int totalLottoSize, LottoList manualLottos) {
        int manualLottoSize = manualLottos.size();

        if (totalLottoSize < manualLottoSize) {
            throw new IllegalArgumentException("TOO MANY LOTTO");
        }

        lottos = new ArrayList<>(totalLottoSize);
        lottos.addAll(manualLottos.lottos);

        IntStream.range(0, totalLottoSize - manualLottoSize)
            .forEach(i -> lottos.add(new Lotto()));
    }

    public int size() {
        return lottos.size();
    }

    int count(Rank targetRank, WinningLotto winningLotto) {
        int count = 0;

        for (Lotto lotto : lottos) {
            if (winningLotto.determineRank(lotto) == targetRank) {
                count++;
            }
        }

        return count;
    }

    public void forEach(Consumer<Lotto> printConsumer) {
        lottos.forEach(printConsumer);
    }

    public boolean add(Lotto lotto) {
        return lottos.add(lotto);
    }

    public long sizeOfManuals() {
        return lottos.stream()
            .filter(Lotto::isManual)
            .count();
    }

    public long sizeOfAutos() {
        return lottos.stream()
            .filter(Lotto::isAuto)
            .count();
    }

    @Override
    public String toString() {
        return String.valueOf(lottos);
    }

    private Stream<Lotto> stream() {
        return lottos.stream();
    }

    public static LottoList merge(LottoList lottoList1, LottoList lottoList2) {
        return new LottoList(Stream.concat(lottoList1.stream(), lottoList2.stream())
            .collect(Collectors.toList()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
