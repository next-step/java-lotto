package step2.domain;

import step2.domain.lotto.LottoRank;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class ResultOfLottos {

    private static final Integer WIN_COUNT_ZERO = 0;

    private final Map<LottoRank, Integer> resultOfLottos;

    public ResultOfLottos() {
        this(new EnumMap<>(LottoRank.class));
    }

    public ResultOfLottos(Map<LottoRank, Integer> resultOfLottos) {
        this.resultOfLottos = resultOfLottos;
    }

    public Integer sumMoney() {
        return resultOfLottos.keySet()
            .stream()
            .map(lottoRank -> lottoRank.getMoney() * resultOfLottos.get(lottoRank))
            .reduce(Integer::sum).orElse(0);
    }

    public void put(LottoRank lottoRank) {
        resultOfLottos.put(lottoRank, resultOfLottos.getOrDefault(lottoRank, WIN_COUNT_ZERO) + 1);
    }

    public Integer winCount(LottoRank rank) {
        if (!resultOfLottos.containsKey(rank)) {
            return WIN_COUNT_ZERO;
        }

        return resultOfLottos.get(rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultOfLottos that = (ResultOfLottos) o;
        return Objects.equals(resultOfLottos, that.resultOfLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultOfLottos);
    }
}
