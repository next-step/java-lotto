package app.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private List<LottoNum> numbers;

    private Lotto(List<LottoNum> numbers) {
        List<LottoNum> inputList = new ArrayList<>(numbers);
        validation(inputList);
        this.numbers = inputList;
    }

    public static Lotto from(List<Integer> list) {
        return new Lotto(list.stream()
                .map(LottoNum::of)
                .collect(Collectors.toList()));
    }

    public static Lotto from(String list) {
        return new Lotto(Arrays.stream(list.split(","))
                .map(str -> LottoNum.of(str.trim()))
                .collect(Collectors.toList()));
    }
//    public static Lotto from(List<Integer> list){
//        return new Lotto(list.stream().map(LottoNum::of).collect(Collectors.toList()));
//    }

    private void validation(List<LottoNum> list) {
        if (list.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 길이는 %d개 이어야 합니다.", LOTTO_SIZE));
        }
        if (isDuplicate(list)) {
            throw new IllegalArgumentException("숫자가 중복 되어있습니다.");
        }
    }


    private boolean isDuplicate(List<LottoNum> list) {
        Set<LottoNum> set = new HashSet<>(list);
        return set.size() != LOTTO_SIZE;
    }

    public List<LottoNum> getNumbers() {
        arrangeNumbers();
        return new ArrayList<LottoNum>(this.numbers);
    }

    private void arrangeNumbers() {
        this.numbers = numbers.stream().sorted((n1, n2) -> n1.compareTo(n2)).collect(Collectors.toList());
    }

    public int matchLotto(Lotto winner) {
        int count = 0;
        for (LottoNum number : this.getNumbers()) {
            if (winner.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }
    public boolean contains(LottoNum bonus){
        return numbers.contains(bonus);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        for (LottoNum num : lotto.getNumbers()) {
            if (!this.numbers.contains(num)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        arrangeNumbers();
        return this.numbers.toString();
    }
}
