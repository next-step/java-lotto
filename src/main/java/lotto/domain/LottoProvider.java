package lotto.domain;

import lotto.StringUtils;

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

    public static WinningLotto createWinningLotto(String numberText, int bonusNumber) {
        return createWinningLotto(StringUtils.convertToNumbers(numberText), bonusNumber);
    }

    public static Lotto createLotto(Integer... numbers) {
        return createLotto(Arrays.asList(numbers));
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(new LottoNumbers(toLottoNumbers(numbers)));
    }

    public static List<Lotto> createLottos(List<String> lottoTexts) {
        List<Lotto> lottos = new ArrayList<>();

        for (String lottoText : lottoTexts) {
            createLotto(StringUtils.convertToNumbers(lottoText));
        }

        return lottos;
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

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
