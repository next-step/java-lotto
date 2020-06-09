package lotto.domain.lotto;

public class BonusBall {

    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    private int bonusBall;

    public BonusBall(int bonusBall, LottoNumbers lottoNumbers) {
        checkDuplicate(bonusBall, lottoNumbers);
        checkRange(bonusBall);
        this.bonusBall = bonusBall;
    }

    public static BonusBall create(int bonusBall, LottoNumbers lottoNumbers) {
        return new BonusBall(bonusBall, lottoNumbers);
    }

    private void checkRange(int bonusBall) {
        if (bonusBall < START_RANGE || bonusBall > END_RANGE) {
            throw new IllegalArgumentException("보너스 볼이 유효하지 않습니다");
        }
    }

    private void checkDuplicate(int bonusBall, LottoNumbers lottoNumbers) {
        if (lottoNumbers.getLottoNumbers().contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼과 당첨 번호가 중복 됩니다");
        }
    }
}
