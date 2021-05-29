package study.lotto.util;

import study.lotto.domain.LottoGame;
import study.lotto.domain.LottoNumber;
import study.lotto.exception.WrongLottoSizeException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    private static final String NUMBER_DELIMITER = ", |,";

    public static List<LottoNumber> randomNumbers() {
        List<Integer> allNumbers = LottoGame.AVAILABLE_LOTTONUMBERS;
        Collections.shuffle(allNumbers);
        return allNumbers.stream().limit(LottoGame.MARK_SIZE).map(LottoNumber::new).sorted().collect(Collectors.toList());
    }
    
    public static List<LottoNumber> markedNumbers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
        validateSize(lottoNumbers);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public static List<LottoNumber> markedNumbers(String stringNumbers) {
        List<LottoNumber> lottoNumbers = convertToLottoNumbers(stringNumbers);
        validateSize(lottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }


    private static List<LottoNumber> convertToLottoNumbers(String stringNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String stringNumber : stringNumbers.split(NUMBER_DELIMITER)) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(stringNumber)));
        }
        return lottoNumbers;
    }

    private static void validateSize(List<LottoNumber> markedLottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(markedLottoNumbers);
        if (lottoNumberSet.size() != LottoGame.MARK_SIZE) {
            throw new WrongLottoSizeException();
        }
    }

}
