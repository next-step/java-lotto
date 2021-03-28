package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Constant;

public class LottoNumbers {

  private final List<LottoNumber> numbers;

  public LottoNumbers() {
    LottoNumberStore store = new LottoNumberStore();
    this.numbers = generateLottoNumbers(store.createLottoNumbers());
  }

  public LottoNumbers(List<LottoNumber> numbers) {
    this.numbers = generateLottoNumbers(numbers);
  }

  public LottoNumbers(String inputNumbers) {
    this.numbers = generateLottoNumbers(inputNumbers);
  }

  private List<LottoNumber> generateLottoNumbers(String inputNumbers) {
    List<LottoNumber> lottoNumbers = stringToList(inputNumbers).stream()
        .mapToInt(Integer::parseInt)
        .mapToObj(LottoNumber::of)
        .collect(Collectors.toList());

    validateSize(lottoNumbers);
    validateDuplication(lottoNumbers);
    return lottoNumbers;
  }

  private List<String> stringToList(String text) {
    return Arrays.asList(splitString(text));
  }

  private String[] splitString(String text) {
    return text.split(Constant.BASIC_REGEX);
  }

  public List<LottoNumber> generateLottoNumbers(List<LottoNumber> numbers) {
    validateSize(numbers);
    validateDuplication(numbers);
    return numbers;
  }

  public List<LottoNumber> numbers() {
    return Collections.unmodifiableList(numbers);
  }

  public void validateSize(List<LottoNumber> numbers) {
    if (numbers.size() != Constant.LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
  }

  public void validateDuplication(List<LottoNumber> lottoNumbers) {
    HashSet<LottoNumber> numbers = new HashSet<>(lottoNumbers);
    if (numbers.size() != Constant.LOTTO_NUMBER_SIZE) {
      throw new IllegalArgumentException("로또 번호는 중복이 불가능합니다.");
    }
  }

  @Override
  public String toString() {
    return numbers.stream()
        .map(LottoNumber::getLottoNumber)
        .collect(Collectors.toList())
        .toString();
  }
}
