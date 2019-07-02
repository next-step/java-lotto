package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoSet {
    private final List<LottoNumber> lottoNumbers;

    public LottoSet(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoGenerator.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 갯수를 바르게 입력해주세요");
        }

        if(new HashSet<LottoNumber>(lottoNumbers).size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoSet(int... lottoNumbers) {
        if (lottoNumbers.length != LottoGenerator.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        this.lottoNumbers = Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int countOfMatchNumber(LottoSet winningLotto) {
        return (int) winningLotto.lottoNumbers.stream()
                .filter(this::isMatchNumber)
                .count();
    }

    public boolean isMatchNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
