package lotto.parser;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
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

    public static LottoBundle parseLottoBundle(List<String> lottos) {
        List<Lotto> parsedLottos = lottos.stream()
                .map(LottoNumberParser::parseLotto)
                .collect(Collectors.toList());

        return new LottoBundle(parsedLottos);
    }

    public static Lotto parseLotto(String lottoNumbers) {
        return new Lotto(parseLottoNumbers(lottoNumbers));
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
