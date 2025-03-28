package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 서로 다른 숫자여야 합니다.");
        }
        if (isNotAscendingSorted(numbers)) {
            throw new IllegalArgumentException("로또 번호는 오름차순으로 정렬되어야 합니다.");
        }
        this.numbers = numbers;
    }

    private boolean isNotAscendingSorted(List<LottoNumber> numbers) {
        for (int i = 0; i < numbers.size() - 2; i++) {
            if (numbers.get(i).get() > numbers.get(i + 1).get()) {
                return true;
            }
        }
        return false;
    }

    public static Lotto createRandomly() {
        List<LottoNumber> participants = IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
        Collections.shuffle(participants);
        List<LottoNumber> selectedNumbers = participants.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(selectedNumbers);
        return new Lotto(selectedNumbers);
    }

    /**
     * numbers는 아래 제약 조건들을 만족해야 한다
     * @param numbers
     * 1. 6개의 숫자로 이루어져야 한다
     * 2. 각 숫자는 1이상 45이하의 숫자여야 한다
     * 2. 중복된 숫자가 있으면 안된다
     * 3. 숫자는 오름차순으로 정렬되어야 한다
     * @return
     */
    public static Lotto create(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public int getMatchCount(Lotto winningLotto) {
        return winningLotto.numbers.stream()
                .mapToInt(number -> numbers.contains(number) ? 1 : 0)
                .sum();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
