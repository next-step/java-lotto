package step3.domain.lotto;

import step3.domain.money.Cache;
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

    public Cache sumMoney() {
        return new Cache(resultOfLottos.keySet()
            .stream()
            .map(lottoNumber -> lottoNumber.getWinMoney() * resultOfLottos.get(lottoNumber))
            .reduce(Integer::sum).orElse(WIN_COUNT_ZERO));
    }

    public Map<LottoRank, Integer> getResultOfLottos() {
        return resultOfLottos;
    }

    public void put(LottoRank lottoNumber) {
        resultOfLottos.put(lottoNumber, resultOfLottos.getOrDefault(lottoNumber, WIN_COUNT_ZERO) + 1);
    }

    public Integer winCount(LottoRank lottoRank) {
        if (!resultOfLottos.containsKey(lottoRank)) {
            return WIN_COUNT_ZERO;
        }

        return resultOfLottos.get(lottoRank);
    }

    @Override
    public String toString() {
        return "ResultOfLottos{" +
            "resultOfLottos=" + resultOfLottos +
            '}';
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
