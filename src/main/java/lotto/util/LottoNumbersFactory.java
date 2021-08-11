package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumbersFactory {
    private static final String DELIMITER = ",";

    private static final List<Integer> lottoNumbers = IntStream
            .rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .collect(toList());

    public static LottoNumbers makeAutoLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> lottoNumbers = pickLottoNumbers();
        return new LottoNumbers(lottoNumbers);
    }

    private static List<LottoNumber> pickLottoNumbers() {
        List<Integer> randomLottoNumbers = lottoNumbers.subList(0, LottoNumbers.LOTTO_NUMBERS_SIZE);
        Collections.sort(randomLottoNumbers);
        return randomLottoNumbers
                .stream()
                .map(LottoNumber::new)
                .collect(toList());
    }

    public static LottoNumbers makeLottoNumbers(String inputLottoNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String lottoNumber : inputLottoNumbers.split(DELIMITER)) {
            lottoNumber = lottoNumber.trim();
            checkIsInteger(lottoNumber);
            lottoNumbers.add(Integer.parseInt(lottoNumber));
        }
        return new LottoNumbers(toLottoNumbers(lottoNumbers));
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(toList());
    }

    private static void checkIsInteger(String input) {
        if (input == null || !input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력된 값에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}