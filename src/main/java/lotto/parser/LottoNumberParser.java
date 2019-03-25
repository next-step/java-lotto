package lotto.parser;

import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberParser {
    private LottoNumberParser() {
    }

    public static WinningLotto parseWinningLotto(String lottoNumbersString, String bonusNumber) {
        return new WinningLotto(parseLottoNumbers(lottoNumbersString), parseLottoNumber(bonusNumber));
    }
    static LottoNumber parseLottoNumber(String bonusNumber) {
        return LottoNumber.getInstance(parseInt(bonusNumber));
    }

    static List<LottoNumber> parseLottoNumbers(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                    .map(LottoNumberParser::parseLottoNumber)
                    .collect(Collectors.toList());
    }

    private static int parseInt(String source) {
        return Integer.parseInt(source.trim());
    }
}
