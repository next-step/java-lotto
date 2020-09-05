package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLottoNumbers(String inputWinningNumber, String inputBonusNumber) {
        validationWinningNumbers(inputWinningNumber);
        int bonusNumber = validationBonusNumber(inputBonusNumber);

        this.winningNumbers = changeToList(inputWinningNumber);
        this.bonusNumber = LottoNumber.of(bonusNumber);

        validationOverLapping(winningNumbers, this.bonusNumber);

    }

    private void validationWinningNumbers(String inputWinningNumber) {
        if (inputWinningNumber == null || inputWinningNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("입력하신 당첨번호가 올바르지 않습니다.");
        }
    }

    private int validationBonusNumber(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("보너스 번호를 정확하게 입력해 주세요.");
        }
    }

    private void validationOverLapping(List<LottoNumber> inputWinningNumber, LottoNumber inputBonusNumber) {
        if (inputWinningNumber.contains(inputBonusNumber)) {
            throw new IllegalArgumentException("보너스번호가 중복되었습니다.");
        }
    }

    private List<LottoNumber> changeToList(String inputWinningNumber) {
        List<LottoNumber> lottoNumbers =
                Arrays.stream(inputWinningNumber.split(LOTTO_NUMBER_DELIMITER))
                        .map(Integer::parseInt)
                        .map(LottoNumber::of)
                        .collect(Collectors.toList());

        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨번호 갯수를 확인해주세요.");
        }
        return lottoNumbers;
    }

    public LottoRank getWinningRank(Lotto lotto) {
        long matchCount = lotto.getMatchCountWith(winningNumbers);
        boolean matchBonus = lotto.getMatchWith(bonusNumber);

        return LottoRank.of(matchCount, matchBonus);
    }
}
