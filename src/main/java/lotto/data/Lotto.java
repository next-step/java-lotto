package lotto.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    static final int LOTTO_PRICE = 1_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> numbers;

    public Lotto() {
        this.numbers = makeNumbers();
    }

    public Lotto(List<Integer> numbers) {
        validateInputLottoNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static List<Lotto> getNewLottoList(LottoCount amount) {
        List<Lotto> newLottoList = new ArrayList<>();
        for (int i = 0; i < amount.getCount(); i++) {
            newLottoList.add(new Lotto());
        }

        return newLottoList;
    }

    public List<Integer> makeNumbers() {
        final int FROM_INDEX = 0;
        final int TO_INDEX = 6;

        final List<Integer> lotteNumbers = makeLottoNumberPool();
        Collections.shuffle(lotteNumbers);

        return lotteNumbers.subList(FROM_INDEX, TO_INDEX);
    }


    public static List<Integer> makeLottoNumberPool() {
        List<Integer> lottoNumberPool = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumberPool.add(i);
        }
        return lottoNumberPool;
    }

    public static void validateInputLottoNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요.");
        }

        for (int number : lottoNumbers) {
            validateNumberRange(number);
        }

        if (lottoNumbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    public static void validateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        for (int number : winningNumbers.getNumbers()) {
            validateNumberRange(number);
        }

        for (int winningNumber : winningNumbers.getNumbers()) {
            if (winningNumber == bonusNumber) {
                throw new IllegalArgumentException("중복된 번호가 있습니다.");
            }
        }
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("숫자 1~45 사이로 입력해주세요.");
        }
    }

}
