package lotto.domain;

import lotto.strategy.MakeLottoNumber;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private List<LottoNumber> lottoNumbers;

    public Lotto(MakeLottoNumber makeLottoNumber){
        this.lottoNumbers = makeLottoNumber.getLottoNumber();
    }

    public Lotto(String winLottoNumbers) {
        String[] splitWinLottoNumbers = winLottoNumbers.trim().split(",");
        this.lottoNumbers = Stream.of(splitWinLottoNumbers)
                .map(m -> new LottoNumber((Integer.parseInt(m))))
                .collect(Collectors.toList());
    }

    public Lotto(List<LottoNumber> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int matchCountLotto(List<LottoNumber> winLottoNumbers) {
        Long matchCount = lottoNumbers.stream()
                .filter(number -> comp(number, winLottoNumbers))
                .count();
        return Long.valueOf(matchCount).intValue();
    }

    private boolean comp(LottoNumber number, List<LottoNumber> winNumbers) {
        return winNumbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
