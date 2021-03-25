package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Constant;

public class HitNumbers {

  private LottoNumbers hitNumbers;
  private LottoNumber bonusNumber;

  public HitNumbers(String inputHit, int bonusNumber) {
    this.hitNumbers = generateHitNumbers(inputHit);
    this.bonusNumber = generateBonusNumber(bonusNumber);
  }

  public HitNumbers() {
  }

  private LottoNumbers generateHitNumbers(String inputHit) {
    List<String> inputNumbers = stringToList(inputHit);
    validateSize(inputNumbers);
    validateDuplication(inputNumbers);

    return new LottoNumbers(inputNumbers
        .stream()
        .mapToInt(Integer::parseInt)
        .mapToObj(LottoNumber::new)
        .collect(Collectors.toList()));
  }

  private LottoNumber generateBonusNumber(int bonusNumber) {
    LottoNumber number = new LottoNumber(bonusNumber);
    validateBonus(number);
    return number;
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
