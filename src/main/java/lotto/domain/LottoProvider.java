package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.MAX_NUMBER;
import static lotto.domain.LottoNumber.MIN_NUMBER;
import static lotto.domain.LottoNumbers.NUMBERS_SIZE;

public class LottoProvider {

    private static final List<LottoNumber> numbers = new ArrayList<>();

    private static List<LottoNumber> getNumbers() {
        if (numbers.isEmpty()) {
            for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
                numbers.add(new LottoNumber(i));
            }
        }

        return numbers;
    }

    private static List<LottoNumber> getShuffledNumbers() {
        List<LottoNumber> shuffledNumbers = new ArrayList<>(LottoProvider.getNumbers());

        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers;
    }

    public static WinningLotto createWinningLotto(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(createLotto(numbers), new LottoNumber(bonusNumber));
    }

    public static Lotto createLotto(Integer... numbers) {
        return createLotto(Arrays.asList(numbers));
    }

    public static Lotto createLotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new Lotto(new LottoNumbers(lottoNumbers));
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
        List<LottoNumber> numbers = getShuffledNumbers()
                .stream()
                .limit(NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(new LottoNumbers(numbers));
    }
}
