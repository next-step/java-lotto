package lotto;

public class WinningNumbers {

  private static final String ERROR_DUPLICATE_BONUS = "보너스 번호와 당첨 번호는 중복 불가합니다";

  private final Lotto winningNumbers;
  private final LottoNumber bonusNumber;

  public WinningNumbers(String numbers, int bonus) {
    this(new Lotto(numbers), new LottoNumber(bonus));
  }

  public WinningNumbers(Lotto winningNumber, LottoNumber bonusNumber) {
    validateDuplicate(winningNumber, bonusNumber);
    this.winningNumbers = winningNumber;
    this.bonusNumber = bonusNumber;
  }

  public boolean contains(LottoNumber number) {
    return winningNumbers.contains(number);
  }

  boolean contains(int number) {
    return contains(new LottoNumber(number));
  }

  public boolean hasBonus(LottoNumber number) {
    return bonusNumber.equals(number);
  }

  boolean hasBonus(int number) {
    return hasBonus(new LottoNumber(number));
  }

  public LottoRank matchingRank(Lotto lotto) {
    int count = (int) lotto.numbers().stream()
        .filter(winningNumbers::contains)
        .count();

    boolean hasBonus = lotto.contains(bonusNumber);

    return LottoRank.of(count, hasBonus);
  }

  private void validateDuplicate(Lotto winningNumber, LottoNumber bonusNumber) {
    if (winningNumber.contains(bonusNumber)) {
      throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS);
    }
  }

}
