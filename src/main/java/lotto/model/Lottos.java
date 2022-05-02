package lotto.model;

import lotto.dto.LottoResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
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
        Map<Rank, Integer> lottoStatistics = getLottoStatistics(winnerLotto);
        long winningsSum = getWinningsSum(lottoStatistics);
        return new LottoResult(lottoStatistics, winningsSum);
    }

    private Map<Rank, Integer> getLottoStatistics(Lotto winnerLotto) {
        validate(winnerLotto);

        Map<Rank, Integer> result = initMap();

        for (Lotto lotto : lottos) {
            Rank key = Rank.of(lotto.getMatchCount(winnerLotto));
            result.put(key, result.getOrDefault(key, DEFAULT_VALUE) + ADD_COUNT);
        }
        return result;
    }

    private TreeMap<Rank, Integer> initMap() {
        return new TreeMap<>(new Comparator<Rank>() {
            @Override
            public int compare(Rank rank, Rank t1) {
                return rank.matchCount() - t1.matchCount();
            }
        });
    }

    private static void validate(Lotto winnerLotto) {
        Objects.requireNonNull(winnerLotto, "당첨 로또를 올바르게 입력해주세요. input is null");
    }

    private static long getWinningsSum(Map<Rank, Integer> statistics) {
        long result = 0;
        for (int i = WINNINGS_START; i <= WINNINGS_END; i++) {
            Rank rank = Rank.of(i);
            int count = statistics.getOrDefault(rank, DEFAULT_VALUE);
            result += count * rank.winnings();
        }
        return result;
    }
}
