package lotto.domain;

import lotto.pattern.LottoNumberGenerateStrategy;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGroup {
    private static final int NO_COUNT = 0;
    private static final int UNIT_COUNT = 1;

    private final List<Lotto> lottos;

    public LottoGroup(List<Lotto> lottos) {
        validateLottos(lottos);
        this.lottos = lottos;
    }

    public static LottoGroup create(int lottoCount, LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        return new LottoGroup(createLottos(lottoCount, lottoNumberGenerateStrategy));
    }

    public static LottoGroup create(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        return new LottoGroup(Stream.concat(manualLottos.stream(), autoLottos.stream()).collect(Collectors.toList()));
    }

    public static List<Lotto> createLottos(int lottoCount, LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        validateLottoCount(lottoCount);
        return IntStream.range(0, lottoCount).mapToObj(i -> new Lotto(lottoNumberGenerateStrategy)).collect(Collectors.toList());
    }

    public LottoGroupResult getLottoGroupResult(WinningLotto winningLotto) {
        final Map<LottoRank, Integer> lottoGroupResult = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : this.lottos) {
            LottoRank lottoRank = lotto.getLottoRank(winningLotto);
            lottoGroupResult.put(lottoRank, lottoGroupResult.getOrDefault(lottoRank, NO_COUNT) + UNIT_COUNT);
        }
        return new LottoGroupResult(lottoGroupResult);
    }

    public List<List<Integer>> getLottoGroupNumber() {
        return lottos.stream().map(Lotto::getNumbers).collect(Collectors.toList());
    }

    private void validateLottos(List<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException("로또 리스트가 null 일 수 없습니다.");
        }
    }

    private static void validateLottoCount(int lottoCount) {
        if (lottoCount < NO_COUNT) {
            throw new IllegalArgumentException(String.format("생성하고자 하는 로또 갯수가 음수일 수 없습니다. 입력한 로또 갯수 : %d", lottoCount));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoGroup that = (LottoGroup) o;

        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return lottos.hashCode();
    }
}
