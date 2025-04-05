package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenerateNumber {
    private static final int BOUND = 45;
    private static final List<LottoNumber> numbers = new ArrayList<>();

    private static final GenerateNumber INSTANCE = new GenerateNumber();

    static {
        for (int i = 1; i < BOUND; i++) {
            numbers.add(new LottoNumber(i));
        }
    }

    private GenerateNumber() {}

    public static GenerateNumber getInstance() {
        return INSTANCE;
    }
    public List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber> shuffledNumbers = new ArrayList<>(numbers);
        Collections.shuffle(shuffledNumbers);
        List<LottoNumber> randoms = shuffledNumbers.subList(0, 6);
        randoms.sort(Comparator.comparing(LottoNumber::getNumber));

        return randoms;
    }

    public List<Integer> generateNumbers(List<Integer> numbers) {
        return numbers.subList(0,6);
    }
}
