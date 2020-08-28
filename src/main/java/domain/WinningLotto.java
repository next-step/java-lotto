package domain;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int WINNING_LOTTO_NUMBER = 6;

    private final Set<LottoNumber> winningLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public static WinningLotto of(String winningLottoNumberString, String bonusLottoNumberString) {
        Set<LottoNumber> winningLottoNumbers = getWinningLottoNumberFromString(winningLottoNumberString);
        LottoNumber bonusLottoNumber = LottoNumber.getLottoNumber(Integer.parseInt(bonusLottoNumberString));

        return new WinningLotto(winningLottoNumbers, bonusLottoNumber);
    }

    private static TreeSet<LottoNumber> getWinningLottoNumberFromString(String winningLottoNumberStringWithComma) {
        return Arrays.stream(winningLottoNumberStringWithComma.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public WinningLotto(Set<LottoNumber> winningLottoNumbers, LottoNumber bonusLottoNumber) {
        validateWinningLottoNumber(winningLottoNumbers);
        checkDuplicateBonusNumber(winningLottoNumbers, bonusLottoNumber);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void checkDuplicateBonusNumber(Set<LottoNumber> winningLottoNumbers, LottoNumber bonusLottoNumber) {
        boolean isExist = winningLottoNumbers.contains(bonusLottoNumber);
        if (isExist) {
            throw new IllegalArgumentException("보너스 번호는 로또 숫자와 중복되면 안 됩니다");
        }
    }

    private void validateWinningLottoNumber(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != WINNING_LOTTO_NUMBER) {
            throw new IllegalArgumentException("당첨 번호는 6개의 다른 값 이여야 합니다.");
        }
    }

    public boolean isMatchBonusNumber(LottoNumber lottoNumber) {
        return lottoNumber.equals(bonusLottoNumber);
    }

    public boolean isContainInWinningNumber(LottoNumber lottoNumber) {
        return winningLottoNumbers.contains(lottoNumber);
    }
}
