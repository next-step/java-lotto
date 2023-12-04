package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers() {
        List<Integer> seedNumbers = new ArrayList<>();
        for (int i = 0; i < 45; ++i) {
            seedNumbers.add(i + 1);
        }
        Collections.shuffle(seedNumbers);
        seedNumbers.subList(0, 6).forEach(n -> {
            this.lottoNumbers.add(new LottoNumber(n));

        });
        this.validateDigit();
    }

    public LottoNumbers(Integer... numbers) {
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        this.validateDigit();
    }

    public LottoNumbers(String numbers) {
        String[] strArr = numbers.split(", ");
        for (String s : strArr) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(s)));
        }
        this.validateDigit();
    }

    public int matchCount(LottoNumbers winningNumbers) {
        return (int) this.lottoNumbers.stream()
            .filter(winningNumbers.lottoNumbers::contains)
            .count();
    }

    public Optional<Rank> rank(LottoNumbers winningNumbers) {
        return Arrays.stream(Rank.values())
            .filter(r -> r.matchCount() == (int) this.lottoNumbers.stream()
                .filter(winningNumbers.lottoNumbers::contains)
                .count()).findFirst();
    }

    private void validateDigit() {
        Set<LottoNumber> numbers = new HashSet<>(this.lottoNumbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 숫자 6개로 구성되어야 합니다.");
        }
    }

    @Override
    public String toString() {
        return this.lottoNumbers.stream().map(n -> n.number()).collect(Collectors.toSet())
            .toString();
    }
}
