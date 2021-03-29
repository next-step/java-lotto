package study.step4.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    private Set<LottoNumber> lottoNumbers = new TreeSet<>();

    public Lotto(String[] numbers) {
        this(Arrays.stream(numbers)
            .map(i -> LottoNumber.of(i.trim()))
            .collect(toList()));
    }

    public Lotto(List<LottoNumber> collect) {
        lottoNumbers = new TreeSet<>(collect);
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
}
