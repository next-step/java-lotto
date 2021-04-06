package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> lottoNumberList;

    public Lotto(int[] lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumberList = Arrays.stream(lottoNumbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

    public int[] getLottoNumbers() {
        return lottoNumberList.stream().mapToInt(LottoNumber::getLottoNumber).sorted().toArray();
    }

    public LottoRank inquiryRank(int[] winNumbers, int bonusNumber) {
        validateBonusNumber(winNumbers, bonusNumber);
        return LottoRank.inquiryRank(matchSum(winNumbers), matchBonus(bonusNumber));
    }

    private void validateBonusNumber(int[] winNumbers, int bonusNumber) {
        LottoNumber.validateLottoNumber(bonusNumber);
        Arrays.stream(winNumbers).forEach(winNumber -> checkDuplicateBonusNumber(winNumber, bonusNumber));
    }

    private void checkDuplicateBonusNumber(int winNumber, int bonusNumber) {
        if (winNumber == bonusNumber) {
            throw new IllegalArgumentException("보너스 번호와 당첨번호가 중복됩니다. 보너스 번호를 다시 확인해 주세요.");
        }
    }

    private int matchSum(int[] winNumbers) {
        return lottoNumberList.stream()
                .mapToInt(lottoNumber -> matchCount(lottoNumber, winNumbers))
                .sum();
    }

    private int matchCount(LottoNumber lottoNumber, int[] winNumbers) {
        return (int) Arrays.stream(winNumbers).filter(lottoNumber::match).count();
    }

    private boolean matchBonus(int bonusNumber) {
        return lottoNumberList.stream().anyMatch(lottoNumber -> lottoNumber.match(bonusNumber));
    }

    public static void validateLottoNumbers(int[] winNumbers) {
        if (winNumbers == null || winNumbers.length == 0) {
            throw new IllegalArgumentException("당첨 숫자를 입력해 주세요.");
        }
        if (winNumbers.length != LottoConstant.MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("당첨 숫자는 " + LottoConstant.MAX_LOTTO_COUNT + "개의 수 여야 합니다.");
        }
        if (Arrays.stream(winNumbers).distinct().count() < LottoConstant.MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다. 입력값을 확인해주세요.");
        }
        for (int winNumber : winNumbers) {
            LottoNumber.validateLottoNumber(winNumber);
        }
    }
}
