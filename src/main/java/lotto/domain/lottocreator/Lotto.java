package lotto.domain.lottocreator;

import lotto.domain.LottoNo;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.lottocreator.LottoFactory.LOTTO_NUMBER;

public class Lotto {
    private List<LottoNo> lottoNos;

    public Lotto(List<LottoNo> lottoNos) {
        validate(lottoNos);
        this.lottoNos = lottoNos;
    }

    public void validate(List<LottoNo> lottoNos) {
        if (lottoNos.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException("개수가 6개가 아닙니다.");
        }
    }

    public int getMatchingNumberCount(Lotto lotto) {
        return lottoNos.stream()
                .filter(number -> lotto.contains(number))
                .collect(Collectors.toList())
                .size();
    }

    public boolean contains(LottoNo number) {
        return lottoNos.stream().anyMatch(lottoNumber -> lottoNumber.equals(number));
    }

    @Override
    public String toString() {
        return lottoNos.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", ", "[","]"));
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
