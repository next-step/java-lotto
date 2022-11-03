package lotto.domain;

import java.security.InvalidParameterException;
import java.util.*;

public class Lotto {
    private int NUMBER_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = generateNumbers();
    }

    public Lotto(String numbers) {
        lottoNumbers = generateLotto(numbers);
    }

    private SortedSet<LottoNumber> generateLotto(String numbers) {
        numbers = preprocessingData(numbers);
        SortedSet<LottoNumber> lottoNumberSet = createLottoNumberSet(numbers);

        if (lottoNumberSet.size() < 6) {
            throw new InvalidParameterException("중복된 번호로 로또가 생성되려 하고 있습니다.");
        }

        return lottoNumberSet;
    }

    private SortedSet<LottoNumber> createLottoNumberSet(String numbers) {
        SortedSet<LottoNumber> lottos = new TreeSet<>();

        for (String number : numbers.split(",")) {
            lottos.add(LottoNumberGenerator.getNumber(parseInt(number)));
        }
        return lottos;
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }

    private String preprocessingData(String numbers) {
        return numbers.replaceAll(" ", "");
    }

    public LottoResult getResult(Lotto winningLotto, LottoNumber bonus) {
        int matchCount = (int) lottoNumbers.stream().filter(w -> winningLotto.contains(w)).count();
        boolean matchBonus = lottoNumbers.contains(bonus);
        return LottoResult.of(matchCount, matchBonus);
    }

    private boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private Set<LottoNumber> generateNumbers() {
        Set<LottoNumber> numbers = new TreeSet<>();
        while (numbers.size() < this.NUMBER_SIZE) {
            LottoNumber number = LottoNumberGenerator.getRandomNumber();
            numbers.add(number);
        }
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
