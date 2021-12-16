package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos {
    public static final int MIN_LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos of(int automatedSize, List<Lotto> manualLottos) {
        return lottos(automatedLottos(automatedSize), manualLottos);
    }

    private static Lottos lottos(List<Lotto> automatedLottos, List<Lotto> manualLottos) {
        return new Lottos(Stream.concat(automatedLottos.stream(), manualLottos.stream())
                .collect(Collectors.toList()));
    }

    private static List<Lotto> automatedLottos(int automatedSize) {
        return IntStream.range(0, automatedSize)
                .mapToObj(v -> new Lotto())
                .collect(Collectors.toList());
    }

    public LottoResult lottoResult(WinningLotto winningLotto) {
        return new LottoResult(this, winningLotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<LottoRank> lottoRanks(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }

    private void validate(List<Lotto> lottos) {
        if (Objects.isNull(lottos)) {
            throw new IllegalArgumentException("lottos가 null입니다.");
        }
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("lottos의 사이즈가 0입니다.");
        }
    }
}
