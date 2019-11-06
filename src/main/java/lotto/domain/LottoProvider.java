package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumbers.*;

public class LottoProvider {

    private static final List<Integer> numbers = new ArrayList<>();

    private static List<Integer> getNumbers() {
        if (numbers.isEmpty()) {
            for (int i = 1; i <= MAX_NUMBER; i++) {
                numbers.add(i);
            }
        }

        return numbers;
    }

    private static List<Integer> getShuffledNumbers() {
        List<Integer> shuffledNumbers = LottoProvider.getNumbers();
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers;
    }

    public static Lotto create(List<Integer> numbers, int bonusNumber) {
        return new Lotto(new LottoNumbers(numbers), new BonusNumber(bonusNumber));
    }

    public static List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(LottoProvider.create());
        }
        return lottos;
    }

    private static Lotto create() {
        List<Integer> shuffledNumbers = getShuffledNumbers();
        List<Integer> numbers = shuffledNumbers.stream()
                .limit(NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toList());
        int bonusNumber = shuffledNumbers.get(shuffledNumbers.size() - 1);

        return create(numbers, bonusNumber);
    }
}
