package lotto.domain;

import lotto.strategy.CreationLottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final int DEFAULT_LOTTO_COUNT = 6;
    private static final String DEFAULT_SPLIT_CHARACTER = ",";
    private static final String DEFAULT_WHITE_SPACE_CHARACTER = " ";
    private static final String DEFAULT_CHARACTER = "";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(CreationLottoNumber creationLottoNumber){
        this(creationLottoNumber.automatic());
    }

    public Lotto(String winLottoNumbers) {
        this.lottoNumbers = Stream.of(winLottoNumbers(winLottoNumbers))
                                        .map(m -> new LottoNumber((Integer.parseInt(m))))
                                        .collect(Collectors.toList());
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private String[] winLottoNumbers(String winLottoNumbers) {
        String[] splitWinLottoNumbers = winLottoNumbers.replaceAll(DEFAULT_WHITE_SPACE_CHARACTER, DEFAULT_CHARACTER)
                                                            .split(DEFAULT_SPLIT_CHARACTER);
        if(splitWinLottoNumbers.length != DEFAULT_LOTTO_COUNT){
            throw new IllegalArgumentException("로또 번호 개수가 정확하지 않습니다.");
        }
        return splitWinLottoNumbers;
    }

    public int matchCountLottoNumbers(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                                .filter(lottoNumber -> containLottoNumber(winLotto, lottoNumber))
                                .count();
    }

    private boolean containLottoNumber(Lotto winLotto, LottoNumber lottoNumber) {
        return winLotto.getLottoNumbers().contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
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
}
