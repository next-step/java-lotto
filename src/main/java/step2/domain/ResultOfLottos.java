package step2.domain;

import step2.domain.lotto.LottoNumber;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class ResultOfLottos {

    private static final Integer WIN_COUNT_ZERO = 0;

    private final Map<LottoNumber, Integer> resultOfLottos;

    public ResultOfLottos() {
        this(new EnumMap<>(LottoNumber.class));
    }

    public ResultOfLottos(Map<LottoNumber, Integer> resultOfLottos) {
        this.resultOfLottos = resultOfLottos;
    }

    public Integer sumMoney() {
        return resultOfLottos.keySet()
            .stream()
            .map(lottoNumber -> lottoNumber.getWinMoney() * resultOfLottos.get(lottoNumber))
            .reduce(Integer::sum).orElse(WIN_COUNT_ZERO);
    }

    public void put(LottoNumber lottoNumber) {
        resultOfLottos.put(lottoNumber, resultOfLottos.getOrDefault(lottoNumber, WIN_COUNT_ZERO) + 1);
    }

    public Integer winCount(LottoNumber lottoNumber) {
        if (!resultOfLottos.containsKey(lottoNumber)) {
            return WIN_COUNT_ZERO;
        }

        return resultOfLottos.get(lottoNumber);
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
