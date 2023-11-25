package domain.lotto;

import domain.lotto.domain.LottoNumber;
import util.StringParser;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoUtils {
    private LottoUtils() {
    }

    public static Set<LottoNumber> parseLottoNumbers(String lottoLineString) {
        String[] lottoNumbers = StringParser.parseComma(lottoLineString);
        return Arrays.stream(lottoNumbers)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toSet());
    }
}
