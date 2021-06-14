package lotto.util;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.model.Lotto.CANDIDATE_LOTTO_NUMBER_SIZE;
import static lotto.model.Lotto.CORRECT_LOTTO_NUMBERS_SIZE;

public class LottoGenerator {
    private static final String CAN_NOT_INPUT_NULL_MESSAGE = "공백은 입력 할 수 없습니다.";

    private LottoGenerator() {
    }

    public static Lotto makeManualLotto(String inputNumber) {
        validateInputNumber(inputNumber);

        Set<LottoNumber> lottoNumbers =
                Arrays.stream(inputNumber.split(","))
                        .map(splitString -> Integer.parseInt(splitString))
                        .map(splitInteger -> new LottoNumber(splitInteger))
                        .collect(Collectors.toSet());

        return new Lotto(lottoNumbers);
    }

    private static void validateInputNumber(String inputNumber) {
        if (inputNumber == null) {
            throw new IllegalArgumentException(CAN_NOT_INPUT_NULL_MESSAGE);
        }
    }

    public static Lotto makeAutoLotto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() < CORRECT_LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(new LottoNumber(makeRandomNumber()));
        }

        return new Lotto(lottoNumbers);
    }

    private static Integer makeRandomNumber() {
        return (int) (Math.random() * CANDIDATE_LOTTO_NUMBER_SIZE) + 1;
    }
}
