package step3;

import step3.exception.DuplicatedNumberException;

import java.util.*;


public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        checkDuplicate(numbers);

        lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            lottoNumbers.add(new LottoNumber(numbers.get(i)));
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> dupCheck = new HashSet<>();
        for (int i = 0; i < numbers.size(); ++i) {
            throwDupCheck(numbers, dupCheck, i);
            dupCheck.add(numbers.get(i));
        }
    }

    private void throwDupCheck(List<Integer> numbers, Set<Integer> dupCheck, int i) {
        if (dupCheck.contains(numbers.get(i))) throw new DuplicatedNumberException();
    }


    public Integer findLottoNumByIdx(int idx) {
        return lottoNumbers.get(idx).getNumber();
    }

    public void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public int length() {
        return lottoNumbers.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < lottoNumbers.size() - 1; ++i) {
            sb.append(lottoNumbers.get(i));
            sb.append(", ");
        }
        sb.append(lottoNumbers.get(lottoNumbers.size() - 1));
        sb.append("]");
        return sb.toString();
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

    public void sort() {
        lottoNumbers.sort(Comparator.comparing(LottoNumber::getNumber));
    }
}
