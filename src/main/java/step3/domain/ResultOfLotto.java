package step3.domain;

import step3.domain.lotto.LottoRank;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class ResultOfLotto {

    private static final Integer WIN_COUNT_ZERO = 0;

    private final Map<LottoRank, Integer> resultOfLotto;

    public ResultOfLotto() {
        this(new EnumMap<>(LottoRank.class));
    }

    public ResultOfLotto(Map<LottoRank, Integer> resultOfLotto) {
        this.resultOfLotto = resultOfLotto;
    }

    public Integer sumMoney() {
        return resultOfLotto.keySet()
            .stream()
            .map(lottoNumber -> lottoNumber.getWinMoney() * resultOfLotto.get(lottoNumber))
            .reduce(Integer::sum).orElse(WIN_COUNT_ZERO);
    }

    public void put(LottoRank lottoRank) {
        resultOfLotto.put(lottoRank, resultOfLotto.getOrDefault(lottoRank, WIN_COUNT_ZERO) + 1);
    }

    public Integer winCount(LottoRank lottoRank) {
        if (!resultOfLotto.containsKey(lottoRank)) {
            return WIN_COUNT_ZERO;
        }

        return resultOfLotto.get(lottoRank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultOfLotto that = (ResultOfLotto) o;
        return Objects.equals(resultOfLotto, that.resultOfLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultOfLotto);
    }
}
