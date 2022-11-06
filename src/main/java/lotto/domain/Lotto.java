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
        lottoNumbers = createLottoNumberSet(numbers);
    }

    private SortedSet<LottoNumber> createLottoNumberSet(String numbers) {
        SortedSet<LottoNumber> lottos = new TreeSet<>();

        for (String number : numbers.split(",")) {
            lottos.add(LottoNumberGenerator.getNumber(parseInt(number)));
        }

        if(lottos.size() < 6){
            throw new InvalidParameterException("중복된 숫자가 들어왔습니다.");
        }

        return lottos;
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }


    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int hitCount(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(number -> lotto.contains(number))
                .count();
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
