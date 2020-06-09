package lotto.domain.lotto;

public class BonusBall {

    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    private int bonusBall;

    public BonusBall(int bonusBall, LottoNumbers lottoNumbers) {
        checkDuplicate(bonusBall, lottoNumbers);
        checkInRange(bonusBall);
        this.bonusBall = bonusBall;
    }

    public static BonusBall create(int bonusBall, LottoNumbers lottoNumbers) {
        return new BonusBall(bonusBall, lottoNumbers);
    }

    private void checkInRange(int bonusBall) {
        if (isInRange(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼이 유효하지 않습니다");
        }
    }

    private boolean isInRange(int bonusBall) {
        return bonusBall < START_RANGE || bonusBall > END_RANGE;
    }

    private void checkDuplicate(int bonusBall, LottoNumbers lottoNumbers) {
        if (lottoNumbers.getLottoNumbers().contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼과 당첨 번호가 중복 됩니다");
        }
    }
}
