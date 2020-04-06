package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    // TODO: 더 좋은 변수명 찾기
    private static final int LOTTO_NUMBER_LIMIT = 6;
    private static List<Integer> numbers;
    // TODO: 객체로 포장
    private final Set<Integer> lottoNumbers;

    static {
        numbers = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            numbers.add(i);
        }
    }

    public Lotto() {
        this.lottoNumbers = createNumbers();
    }

    public Lotto(Integer... numbers) {
        validateSize(numbers);
        Set<Integer> lottoNumbers = new TreeSet<>();
        for(Integer number : numbers) {
            validateNumber(number);
            lottoNumbers.add(number);
        }
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumber(Integer number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지만 가능합니다.");
        }
    }

    private void validateSize(Integer[] numbers) {
        if (numbers.length != LOTTO_NUMBER_LIMIT) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_LIMIT) {
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }

    private Set<Integer> createNumbers() {
        Collections.shuffle(numbers);
        Set<Integer> lottoNumbers = new TreeSet<>();
        for (int i = 0; i < LOTTO_NUMBER_LIMIT; i++) {
            lottoNumbers.add(numbers.get(i));
        }
        return lottoNumbers;
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int match(Lotto winningLotto) {
        int match = 0;
        for(Integer winningNumber : winningLotto.lottoNumbers) {
            match += contains(winningNumber);
        }
        return match;
    }

    private int contains(Integer winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }
}
