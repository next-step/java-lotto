package study.step4.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private Set<LottoNumber> lottoNumbers = new TreeSet<>();

    public Lotto(String[] numbers) {
        this(Arrays.stream(numbers)
            .map(i -> LottoNumber.of(i.trim()))
            .collect(toList()));
    }

    public Lotto(List<LottoNumber> collect) {
        lottoNumbers = new TreeSet<>(collect);
        valid();
    }

    private void valid() {
        if(lottoNumbers.size() != LOTTO_SIZE ) {
            throw new IllegalArgumentException("로또 번호 수는 6개 입니다.");
        }
    }

    public int match(List<LottoNumber> winInput) {
        int matchCount = lottoNumbers.stream()
            .mapToInt(number -> winInput.contains(number) ? 1 : 0).sum();
        return matchCount;
    }

    public boolean matchBonus(LottoNumber bonusBall) {
        return lottoNumbers.stream()
            .anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Lotto lotto = (Lotto)o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
