package lotto.domain;

public class HitNumbers {

  private LottoNumbers hitNumbers;
  private LottoNumber bonusNumber;

  public HitNumbers(String inputHit, int bonusNumber) {
    this.hitNumbers = new LottoNumbers(inputHit);
    this.bonusNumber = generateBonusNumber(bonusNumber);
  }

  public HitNumbers() {
  }

  private LottoNumber generateBonusNumber(int bonusNumber) {
    LottoNumber number = LottoNumber.of(bonusNumber);
    validateBonus(number);
    return number;
  }

  public void validateBonus(LottoNumber number) {
    if (contains(number)) {
      throw new IllegalArgumentException("보너스 번호와 당첨 번호가 같을 수 없습니다.");
    }
  }

  public boolean contains(LottoNumber number) {
    return hitNumbers.numbers().contains(number);
  }

  public boolean containsBonus(LottoNumbers lottoNumbers) {
    return lottoNumbers.numbers().contains(bonusNumber);
  }
}
