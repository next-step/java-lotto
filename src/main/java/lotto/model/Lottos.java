package lotto.model;

import lotto.dto.LottoResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lottos {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;
    private static final int WINNINGS_START = 3;
    private static final int WINNINGS_END = 6;

    private final List<Lotto> lottos;

    public Lottos(int count, LottoGenerator lottoGenerator) {
        this(IntStream.range(0, count)
                .mapToObj(i -> lottoGenerator.get())
                .collect(Collectors.toList()));
    }

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    private void validate(List<Lotto> lottos) {
        Objects.requireNonNull(lottos, "lottos 생성을 위한 입력이 올바르지 않습니다. lottos is null");

        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("lottos 생성을 위한 입력이 올바르지 않습니다. lottos is empty");
        }
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult getLottoResult(Lotto winnerLotto) {
        List<Rank> lottoStatistics = getLottoStatistics(winnerLotto);
        return new LottoResult(lottoStatistics);
    }

    private List<Rank> getLottoStatistics(Lotto winnerLotto) {
        validate(winnerLotto);

        return lottos.stream()
                .map(lotto -> lotto.getRank(winnerLotto))
                .collect(Collectors.toList());
    }

    private static void validate(Lotto winnerLotto) {
        Objects.requireNonNull(winnerLotto, "당첨 로또를 올바르게 입력해주세요. input is null");
    }
}
