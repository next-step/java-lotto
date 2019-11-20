package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private List<LottoNo> lottoNos;

    public Lotto(List<LottoNo> lottoNos) {
        this.lottoNos = Optional.ofNullable(lottoNos)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<LottoNo> getLottoNumber() {
        return this.lottoNos.stream()
                .sorted(Comparator.comparingInt(LottoNo::getNumber))
                .collect(Collectors.toList());
    }

    public boolean isContainsWinNumber(int winLottoNumber) {
        return lottoNos.contains(new LottoNo(winLottoNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNos, lotto.lottoNos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNos);
    }
}
