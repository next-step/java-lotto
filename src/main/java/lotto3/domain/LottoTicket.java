package lotto3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
  private final LottoNumbers numbers;

  /**
   * 주 생성자
   * - 유효성 검사 진행
   * - 초기화를 수행
   */
  public LottoTicket(LottoNumbers numbers) {
    this.numbers = numbers;
  }

  /**
   * 부 생성자
   * - 주 생성자의 타입에 맞게 변환 시도 (다양한 타입을 받을 수 있도록 한다.)
   * - 주 생성자를 호출
   */
  public LottoTicket(List<Integer> numbers) {
    this(new LottoNumbers(numbers));
  }

  public List<Integer> getNumbers() {
    return numbers.getLottoNumbers().stream()
        .map(LottoNumber::getNumber)
        .collect(Collectors.toList());
  }


  private int matchCount(LottoNumbers winningNumbers) {
    return numbers.countMatch(winningNumbers);
  }

  private boolean contains(LottoNumber bonusNumber) {
    return numbers.contains(bonusNumber);
  }

  public Prize getLottoPrize(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
    int matchCount = matchCount(winningNumbers);
    boolean containsBonusNumber = contains(bonusNumber);
    return Prize.valueOfMatchCountAndBonusNumber(matchCount, containsBonusNumber);
  }
}
