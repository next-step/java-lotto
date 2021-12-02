package lotto.domain;

import lotto.validator.WinningLottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final List<LottoNumber> winningLotto;

    private WinningLotto(String winningLottoString) {
        List<LottoNumber> winningLotto = parseIntWinningLotto(winningLottoString);
        WinningLottoValidator.checkSize(winningLotto);
        this.winningLotto = winningLotto;
    }

    public static WinningLotto ofString(String winningLottoString) {
        return new WinningLotto(winningLottoString);
    }

    public static WinningLotto ofStringAndBonusBall(String winningLottoString, LottoNumber bonusBall) {
        WinningLottoValidator.bonusBallDuplicateCheck(bonusBall, parseIntWinningLotto(winningLottoString));
        return new WinningLotto(winningLottoString);
    }


    private static List<LottoNumber> parseIntWinningLotto(String winningLottoString) {
        WinningLottoValidator.checkNumeric(winningLottoString);
        List<LottoNumber> winningLotto = Arrays.asList(winningLottoString.split(",")).stream()
                .map(Integer::parseInt)
                .map(LottoNumber::ofInt)
                .collect(Collectors.toList());
        return winningLotto;
    }


    public boolean checkContainNumber(LottoNumber lottoNumber) {
        return winningLotto.contains(lottoNumber);
    }
}
