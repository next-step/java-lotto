package lotto.domain;

import lotto.strategy.CreationLottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final int DEFAULT_LOTTO_COUNT = 6;
    private static final String DEFAULT_WHITE_SPACE_CHARACTER = " ";
    private static final String DEFAULT_CHARACTER = "";
    private static final String DEFAULT_SPLIT_CHARACTER = ",";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(String lottoNumber) {
        List<LottoNumber> lottoNumbers = Stream.of(winLottoNumbers(lottoNumber))
                                                    .map(LottoNumber::from)
                                                    .collect(Collectors.toList());
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(CreationLottoNumber creationLottoNumber) {
        return creationLottoNumber.lottoNumbers(DEFAULT_CHARACTER);
    }

    public static Lotto of(CreationLottoNumber creationLottoNumber, String manualLottoNumbers) {
        return creationLottoNumber.lottoNumbers(manualLottoNumbers);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberGroup = new HashSet<>(lottoNumbers);
        if (lottoNumberGroup.size() != DEFAULT_LOTTO_COUNT) {
            throw new IllegalArgumentException("동일한 번호가 존재합니다.");
        }
    }

    private String[] winLottoNumbers(String winLottoNumbers) {
        String[] splitWinLottoNumbers = winLottoNumbers.replaceAll(DEFAULT_WHITE_SPACE_CHARACTER, DEFAULT_CHARACTER)
                                                            .split(DEFAULT_SPLIT_CHARACTER);
        validateSplitLottoNumbers(splitWinLottoNumbers);
        return splitWinLottoNumbers;
    }

    private void validateSplitLottoNumbers(String[] splitWinLottoNumbers) {
        if (splitWinLottoNumbers.length != DEFAULT_LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호 개수가 정확하지 않습니다.");
        }
    }

    public boolean contain(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int matchCountLottoNumbers(PrizeLotto prizeLotto) {
        return (int) lottoNumbers.stream()
                                    .filter(lottoNumber -> containLottoNumber(prizeLotto, lottoNumber))
                                    .count();
    }

    private boolean containLottoNumber(PrizeLotto prizeLotto, LottoNumber lottoNumber) {
        return prizeLotto.matchNumber(lottoNumber);
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
