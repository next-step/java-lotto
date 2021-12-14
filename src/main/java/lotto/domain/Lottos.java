package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    public static final int MIN_LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    public static Lottos from(int size) {
        return new Lottos(IntStream.range(0, size)
                .mapToObj(v -> new Lotto())
                .collect(Collectors.toList()));
    }

    public LottoResult lottoResult(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        return new LottoResult(this, winningLotto, bonusLottoNumber);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
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
