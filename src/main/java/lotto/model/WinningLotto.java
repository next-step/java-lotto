package lotto.model;

public class WinningLotto {

  private static final String LAST_WINNIG_NUMBER_NULL_OR_EMPTY_ERROR_MESSAGE = "지난 주 당첨 번호가 null이거나 empty입니다.";

  private final Lotto winningLotto;
  private final LottoNumber bonusLottoNumber;

  public WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
    this.winningLotto = winningLotto;
    this.bonusLottoNumber = bonusLottoNumber;
  }

  public static WinningLotto create(String winningLotto, int bonusLottoNumber) {
    validateNullOrEmpty(winningLotto);
    return new WinningLotto(Lotto.create(winningLotto), LottoNumber.create(bonusLottoNumber));
  }

  private static void validateNullOrEmpty(String winningLotto) {
    if(winningLotto == null || winningLotto.isEmpty()) {
      throw new IllegalArgumentException(LAST_WINNIG_NUMBER_NULL_OR_EMPTY_ERROR_MESSAGE);
    }
  }

  public int matchWinningLottoNumbers(Lotto lotto) {
    return lotto.matchWinningLottoNumbers(winningLotto);
  }

  public Lotto getWinningLottoNumbers() {
    return winningLotto;
  }

  public boolean isWinningBonusLottoNumber(Lotto lotto) {
    return lotto.getLottoNumbers().contains(bonusLottoNumber);
  }
}
