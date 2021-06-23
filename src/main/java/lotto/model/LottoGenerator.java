package lotto.model;

import lotto.util.TypeConverter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.Lotto.CORRECT_LOTTO_NUMBERS_SIZE;

public class LottoGenerator {
    private static final String CAN_NOT_INPUT_NULL_MESSAGE = "공백은 입력 할 수 없습니다.";
    private static final List<Integer> numbers =
            IntStream.rangeClosed(1, 45)
                    .boxed()
                    .collect(Collectors.toList());

    private LottoGenerator() {
    }

    public static Lotto makeManualLotto(String inputNumber) {
        validateInputNumber(inputNumber);
        Set<LottoNumber> lottoNumbers = TypeConverter.convertStringToLottoNumberSet(inputNumber);

        return new Lotto(lottoNumbers);
    }

    private static void validateInputNumber(String inputNumber) {
        if (inputNumber == null) {
            throw new IllegalArgumentException(CAN_NOT_INPUT_NULL_MESSAGE);
        }
    }

    public static BunchOfLotto makeBunchOfAutoLotto(int purchasedLottoCount) {
        BunchOfLotto bunchOfLotto = new BunchOfLotto();

        for (int i = 0; i < purchasedLottoCount; i++) {
            bunchOfLotto.addLotto(LottoGenerator.makeAutoLotto());
        }

        return new BunchOfLotto(bunchOfLotto);
    }

    public static Lotto makeAutoLotto() {
        Collections.shuffle(numbers);
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        for (int i = 0; i < CORRECT_LOTTO_NUMBERS_SIZE; i++) {
            lottoNumbers.add(new LottoNumber(numbers.get(i)));
        }

        return new Lotto(lottoNumbers);
    }
}
