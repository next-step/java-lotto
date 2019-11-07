package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumbers.MAX_NUMBER;
import static lotto.domain.LottoNumbers.NUMBERS_SIZE;

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

    public static WinningLotto createWinningLotto(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(createLotto(numbers), new BonusNumber(bonusNumber));
    }

    public static Lotto createLotto(Integer[] numbers) {
        return createLotto(Arrays.asList(numbers));
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(new LottoNumbers(numbers));
    }

    public static List<Lotto> createLottos(int count) {
        if (count <= 0) {
            return Collections.emptyList();
        }
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(LottoProvider.createLotto());
        }
        return lottos;
    }

    private static Lotto createLotto() {
        List<Integer> shuffledNumbers = getShuffledNumbers();
        List<Integer> numbers = shuffledNumbers.stream()
                .limit(NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toList());

        return createLotto(numbers);
    }
}
