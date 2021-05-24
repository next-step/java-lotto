package step3.domain;

import step3.exception.DuplicatedNumberException;

import java.util.*;
import java.util.stream.Collectors;


public class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(TreeSet<Integer> numbers) {
        checkDuplicate(numbers);

        lottoNumbers = new TreeSet<>(Comparator.comparing(LottoNumber::valueOf));
        lottoNumbers.addAll(numbers.stream().map(LottoNumber::new)
                .collect(Collectors.toCollection(() -> new TreeSet<LottoNumber>(Comparator.comparing(LottoNumber::valueOf)))));
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

    @Override
    public String toString() {
        List<LottoNumber> copy = shuffledLottoList();

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LottoNumber lottoNumber : copy) {
            sb.append(lottoNumber);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private List<LottoNumber> shuffledLottoList() {
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
