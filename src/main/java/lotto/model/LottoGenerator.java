package lotto.model;

import lotto.util.TypeConverter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final String CAN_NOT_INPUT_NULL_MESSAGE = "공백은 입력 할 수 없습니다.";
    private static final int FIRST_LOTTO_NUMBER_INDEX = 0;
    private static final int LAST_LOTTO_NUMBER_INDEX = 6;
    private static final List<LottoNumber> LOTTO_NUMBERS =
            IntStream.rangeClosed(1, 45)
                    .mapToObj(number -> new LottoNumber(number))
                    .collect(Collectors.toList());

    private LottoGenerator() {
    }

    public static Lotto makeManualLotto(String inputNumber) {
        validateInputNumber(inputNumber);
        Set<Integer> lottoNumbersIndex = TypeConverter.convertStringToIntegerSet(inputNumber);
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        for (int index : lottoNumbersIndex) {
            lottoNumbers.add(LOTTO_NUMBERS.get(index));
        }

        return new Lotto(lottoNumbers);
    }

    private static void validateInputNumber(String inputNumber) {
        if (inputNumber == null) {
            throw new IllegalArgumentException(CAN_NOT_INPUT_NULL_MESSAGE);
        }
    }

    public static Lottos makeAutoLottos(int purchasedLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchasedLottoCount; i++) {
            lottos.add(makeAutoLotto());
        }

        return new Lottos(lottos);
    }

    private static Lotto makeAutoLotto() {
        List<LottoNumber> shuffleLottoNumbers = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(shuffleLottoNumbers);
        Set<LottoNumber> lottoNumbers =
                new HashSet<>(
                        shuffleLottoNumbers.subList(FIRST_LOTTO_NUMBER_INDEX, LAST_LOTTO_NUMBER_INDEX)
                );

        return new Lotto(lottoNumbers);
    }
}
