package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Constant;

public class HitNumber {

  private LottoNumbers hitNumber;

  public HitNumber(String text) {
    this.hitNumber = generateHitNumber(text);
  }

  public HitNumber() {
  }

  private LottoNumbers generateHitNumber(String text) {
    List<String> inputNumber = stringToList(text);
    validateSize(inputNumber);
    validateDuplication(inputNumber);

    return new LottoNumbers(inputNumber
        .stream()
        .mapToInt(Integer::parseInt)
        .mapToObj(Number::new)
        .collect(Collectors.toList()));
  }

  public List<String> stringToList(String text) {
    return Arrays.asList(splitString(text));
  }

  private String[] splitString(String text) {
    return text.split(Constant.BASIC_REGEX);
  }

  public void validateSize(List<String> list) {
    if (list.size() != Constant.LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
    }
  }

  public void validateDuplication(List<String> list) {
    HashSet<String> numbers = new HashSet<>(list);
    if (numbers.size() != Constant.LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("로또 번호는 중복이 불가능합니다.");
    }
  }

  public void validateRange(List<String> list) {
    list.forEach(number -> isRange(Integer.parseInt(number)));
  }

  private void isRange(int number) {
    if (number > Constant.MAX_NUM || number < Constant.MIN_NUM) {
      throw new IllegalArgumentException("로또 번호는 1에서 45 사이 값만 가합니다.");
    }
  }

  public boolean contains(Number number) {
    return hitNumber.numbers().contains(number);
  }
}
