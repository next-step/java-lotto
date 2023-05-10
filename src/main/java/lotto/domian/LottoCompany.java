package lotto.domian;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoCompany {

    private static final String SPLIT_DELIMITER = ",";

    public static WinNumber announce(String answerNumbers) {
        String[] splitedNumbers = splitNumbers(answerNumbers);
        Set<LottoNumber> lottoNumbers = makeLottoNumber(splitedNumbers);
        return new WinNumber(new Lotto(lottoNumbers));
    }

    private static String[] splitNumbers(String winnerNumbers) {
        return winnerNumbers.trim().split(SPLIT_DELIMITER);
    }

    private static Set<LottoNumber> makeLottoNumber(String[] splitedNumbers) {
        return Stream.of(splitedNumbers)
                .map(string -> {
                    string = string.trim();
                    return new LottoNumber(string);
                })
                .collect(Collectors.toSet());
    }
}
