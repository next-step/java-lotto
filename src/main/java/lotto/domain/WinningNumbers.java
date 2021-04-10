package lotto.domain;

import lotto.common.LottoConstants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusBall;

    public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusBall) {
        normalSize(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public WinningNumbers(String number, LottoNumber bonusBall) {
        this(winningNumber(number), bonusBall);
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    private static List<LottoNumber> winningNumber(String lottoNumber) {
        return Arrays.stream(lottoNumber.replace(" ", "").split(","))
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toList());
    }

    private void normalSize(List<LottoNumber> lottoNumbers) {
        if (!(new HashSet<>(lottoNumbers).size() == LottoConstants.LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException("당첨 번호 생성에 실패 했습니다.");
        }
    }
}
