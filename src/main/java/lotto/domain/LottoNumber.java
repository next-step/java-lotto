package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {

  private final int value;
  public LottoNumber(int value) {
    // 생성자에 로직을 넣는 것은 권장되지 않으나, 검증에 관한 것은 괜찮을까요?
    // 로직을 넣을 때는 가능한 정적 팩토리 메서드를 사용하려고 하는데 어떻게 생각하시나요?
    validate(value);
    this.value = value;
  }

  public static LottoNumber from(String value) {
    try {
      return new LottoNumber(Integer.parseInt(value));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자만 입력할 수 있습니다. 입력된 값 : " + value);
    }
  }

  @Override
  public int compareTo(LottoNumber lottoNumber) {
    if (this.value > lottoNumber.value) {
      return 1;
    }

    if (this.value < lottoNumber.value) {
      return -1;
    }

    return 0;
  }

  public int value() {
    return this.value;
  }

  private void validate(int value) {
    if (value < LottoNumbers.LOTTO_NUMBER_INBOUND || value > LottoNumbers.LOTTO_NUMBER_OUTBOUND) {
      throw new IllegalArgumentException(String.format("숫자는 %d ~ %d 사이의 값만 들어올 수 있습니다.", LottoNumbers.LOTTO_NUMBER_INBOUND, LottoNumbers.LOTTO_NUMBER_OUTBOUND));
    }
  }
}
