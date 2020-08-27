package nextstep.lotto.utils;

import nextstep.lotto.dto.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberUtil {

    private static final int LOTTO_MINIMUM_BOUND = 1;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private LottoNumberUtil() {
    }

    public static List<LottoNumber> generator() {
        List<LottoNumber> lottoNumbers = getSixNumbers();

        return lottoNumbers;
    }

    public static List<LottoNumber> transStringNumberToLottoNumber(List<String> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String number : numbers) {
            lottoNumbers.add(LottoNumber.createByString(number.trim()));
        }

        return lottoNumbers;
    }

    private static List<LottoNumber> getSixNumbers() {
        List<LottoNumber> lottoEntryNumbers = allLottoNumbers();
        Collections.shuffle(lottoEntryNumbers);

        return lottoEntryNumbers.subList(0, LOTTO_NUMBER_COUNT);
    }

    private static List<LottoNumber> allLottoNumbers() {
        return IntStream.range(LOTTO_MINIMUM_BOUND, LOTTO_MAXIMUM_BOUND)
                .boxed()
                .map(LottoNumber::create)
                .collect(Collectors.toList());
    }
}

