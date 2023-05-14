package lottoauto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final List<Integer> LOTTO_NUMBER_RANGE = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    private static final int LOTTO_LIMIT_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto() {
        List<Integer> lottoNumbers = new ArrayList<>(LOTTO_NUMBER_RANGE);
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, 6);
        lottoValidation(lottoNumbers);
        Collections.sort(lottoNumbers);

        this.numbers = lottoNumbers;
    }
    private void lottoValidation(List<Integer> lottoNumber) {
        if (lottoNumber.size() != LOTTO_LIMIT_SIZE) {
            throw new IllegalStateException("로또의 숫자가 6개가 아닙니다.");
        }

        HashSet<Integer> distinctNumbers = new HashSet<>(lottoNumber);
        if (distinctNumbers.size() != LOTTO_LIMIT_SIZE) {
            throw new IllegalStateException("중복되는 숫자가 있습니다.");
        }
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
