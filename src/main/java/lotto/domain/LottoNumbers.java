package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers implements Iterable<LottoNumber> {

    private static final int MAX_LOTTO_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers generate() {
        List<LottoNumber> lottoNumbers = LottoNumber.ofAll();
        Collections.shuffle(lottoNumbers);
        return new LottoNumbers(lottoNumbers.stream()
                .limit(MAX_LOTTO_COUNT)
                .collect(Collectors.toSet()));
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("로또번호를 입력해 주세요.");
        }
        if (lottoNumbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("로또번호는 " + MAX_LOTTO_COUNT + " 개의 숫자로 이루어져야 합니다.");
        }
    }

    public int matchCount(LottoNumbers matchTarget) {
        return (int) lottoNumbers.stream()
                .filter(matchTarget.lottoNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
}
