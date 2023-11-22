package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lotto.domain.LottoNo.LOTTO_MAX;
import static lotto.domain.LottoNo.LOTTO_MIN;

public class Lotto {

    public static final int LOTTO_COUNT = 6;
    private final List<LottoNo> lottoNumber;

    public Lotto(List<LottoNo> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
        if (numbers.stream().distinct().count() < LOTTO_COUNT) {
            throw new IllegalArgumentException("중복된 번호는 입력할 수 없습니다.");
        }
        this.lottoNumber = numbers;
    }

    public Lotto() {
        lottoNumber = randomNumbers();
    }

    private List<LottoNo> randomNumbers() {
        List<LottoNo> numbers = new ArrayList<>();
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            LottoNo lottoNo = new LottoNo(i);
            numbers.add(lottoNo);
        }

        Collections.shuffle(numbers);
        List<LottoNo> selectedNumbers = numbers.subList(0, 6);
        Collections.sort(selectedNumbers);

        return selectedNumbers;
    }

    private List<LottoNo> lottoNumber() {
        return lottoNumber;
    }

    public boolean contains(LottoNo lottoNo) {
        return lottoNumber.contains(lottoNo);
    }

    public int matchCount(Lotto winningLotto) {
        return (int) lottoNumber.stream()
                .filter(n -> winningLotto.lottoNumber().stream()
                        .anyMatch(Predicate.isEqual(n)))
                .count();
    }

    public int size() {
        return lottoNumber.size();
    }

    public List<Integer> toInteger() {
        return lottoNumber.stream().map(LottoNo::lottoNo)
                .collect(Collectors.toList());
    }
}
