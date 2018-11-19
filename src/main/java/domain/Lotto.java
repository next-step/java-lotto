package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1000;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private Set<Integer> numbers;

    private Lotto() {
        numbers = new HashSet<>(getRandomNumbers());
    }

    private Lotto(String values) {
        String[] lottoNumbers = split(values);
        if (!isLottoSize(lottoNumbers)) {
            throw new IllegalArgumentException("잘못된 로또 사이즈입니다.");
        }

        if (!isLottoNumber(toInts(lottoNumbers))) {
            throw new IllegalArgumentException("잘못된 로또 번호입니다. (1~45 범위초과)");
        }

        numbers = new HashSet<>(toInts(lottoNumbers));

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("중복값이 있습니다.");
        }
    }

    public static Lotto auto() {
        return new Lotto();
    }

    public static Lotto manual(String values) {
        return new Lotto(values);
    }

    private boolean isLottoNumber(List<Integer> numbers) {
        List<Integer> lottoNumbers = numbers.stream()
                .filter(number -> number >= MIN_NUMBER && number <= MAX_NUMBER)
                .collect(Collectors.toList());

        return lottoNumbers.size() == LOTTO_NUMBER_COUNT;
    }

    private boolean isLottoSize(String[] values) {
        return values.length == LOTTO_NUMBER_COUNT;
    }

    private List<Integer> toInts(String[] values) {
        List<Integer> numbers = new ArrayList<>(values.length);
        for (String value : values) {
            numbers.add(Integer.parseInt(value.trim()));
        }
        return numbers;
    }

    private String[] split(String lottoNumbers) {
        return lottoNumbers.split(",");
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> shuffledNumbers = shuffle(getLottoAllNumbers());
        for (int i = 0; i < LOTTO_NUMBER_COUNT ; i++) {
            numbers.add(shuffledNumbers.get(i));
        }
        Collections.sort(numbers);
        return numbers;
    }

    private List<Integer> shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    private List<Integer> getLottoAllNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }

    public Rank getMatchRank(WinningLotto winningLotto) {
        return winningLotto.getRank(this);
    }

    public int getMatchNumber(Lotto winningNumbers) {
        int sameCount = 0;
        for (int number: numbers) {
            if(winningNumbers.hasNumber(number)) {
                sameCount += 1;
            }
        }
        return sameCount;
    }

    boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
