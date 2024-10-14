package lotto.domain;

import java.util.Set;

public class WinningNumbers {
    private static final int WINNING_NUMBER_COUNT = 6;

    private final Set<LottoNumber> winningNumbers;
    private final BonusBall bonusBall;

    public static WinningNumbers create(final Set<LottoNumber> numbers, final int bonusBall){
        return new WinningNumbers(numbers, new BonusBall(bonusBall));
    }

    public WinningNumbers(final Set<LottoNumber> winningNumbers, final BonusBall bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
        this.validate();
    }

    private static int parseInt(String number) {
        int lottoNumber;
        try{
            lottoNumber = Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력 가능합니다");
        }
        return lottoNumber;
    }

    //region [validate]
    private void validate() {
        validNumberCount(winningNumbers);
        checkDuplicateFrom(winningNumbers, bonusBall);
    }

    private void validNumberCount(Set<LottoNumber> numbers) {
        if(numbers.size() != WINNING_NUMBER_COUNT){
            throw new IllegalArgumentException("당첨 번호를 6개 입력하세요");
        }
    }

    private void checkDuplicateFrom(Set<LottoNumber> winningNumbers, BonusBall bonusBall) {
        long duplicateCount = winningNumbers.stream()
                .filter((bonusBall::isBonusNumber))
                .count();

        if(duplicateCount > 0){
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됐습니다");
        }
    }
    //endregion

    public int matchWinningNumber(Lotto lotto) {
        return (int)winningNumbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    public boolean matchBonusBall(Lotto lotto){
        return bonusBall.isMatchBonusBallFrom(lotto);
    }
}
