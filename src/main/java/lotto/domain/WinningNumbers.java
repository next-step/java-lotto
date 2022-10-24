package lotto.domain;

public class WinningNumbers {
    private static final String DUPLICATED_BONUS_NUMBER_MESSAGE = "보너스 번호는 먼저 뽑힌 로또번호와 중볼될 수 없습니다.";

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String numbers, String bonus) {
        this(new Lotto(numbers), new LottoNumber(bonus));
        validateBonusNumber(bonus);
    }

    public WinningNumbers(Lotto lotto, LottoNumber bonus) {
        this.winningLotto = lotto;
        this.bonusNumber = bonus;
    }

    private void validateBonusNumber(String bonus) {
        if (isDuplicated(new LottoNumber(bonus))) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_MESSAGE);
        }
    }

    private boolean isDuplicated(LottoNumber bonus) {
        return winningLotto.toIntSet().contains(bonus.getNumber());
    }

    Lotto getWinningLotto() {
        return winningLotto;
    }

    LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
