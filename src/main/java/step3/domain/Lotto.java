package step3.domain;

import step3.exception.DuplicatedNumberException;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(TreeSet<Integer> numbers) {
        checkDuplicate(numbers);

        lottoNumbers = new TreeSet<>(Comparator.comparing(LottoNumber::valueOf));
        lottoNumbers.addAll(numbers.stream().map(LottoNumber::new).collect(toCollection(TreeSet::new)));
    }

    private void checkDuplicate(TreeSet<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new DuplicatedNumberException();
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean findLottoNum(LottoNumber number) {
        return lottoNumbers.contains(number);
    }



    public List<LottoNumber> shuffledLottoList() {
        List<LottoNumber> copy = new ArrayList<>(lottoNumbers);
        Collections.shuffle(copy);
        return copy;
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
