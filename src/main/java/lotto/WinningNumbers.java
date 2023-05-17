package lotto;

import static lotto.LottoNumberGenerator.LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

  private final Set<LottoNo> winningNumbers;

  public WinningNumbers(String input) {
    this.winningNumbers = new HashSet<>();
    this.winningNumbers.addAll(toLottoNos(toIntegers(split(input))));
    if (isLottoNumberCountEqualTo(winningNumbers.size())) {
      throw new IllegalArgumentException("당첨 번호는 중복되지 않은 숫자로 " + LOTTO_NUMBER_COUNT + "개여야합니다.");
    }
  }

  public boolean has(LottoNo lottoNo) {
    return winningNumbers.contains(lottoNo);
  }

  private List<LottoNo> toLottoNos(Integer[] integers) {
    List<LottoNo> winningNumbers = new LinkedList<>();
    for (Integer number : integers) {
      winningNumbers.add(LottoNo.of(number));
    }
    return winningNumbers;
  }

  private Integer[] toIntegers(String[] tokens) {
    if (isLottoNumberCountEqualTo(tokens.length)) {
      throw new IllegalArgumentException("당첨 번호는 " + LOTTO_NUMBER_COUNT + "개여야합니다.");
    }

    Integer[] integers = new Integer[LOTTO_NUMBER_COUNT];
    for (int i = 0; i < tokens.length; i++) {
      integers[i] = Integer.parseInt(tokens[i]);
    }
    return integers;
  }

  private boolean isLottoNumberCountEqualTo(int length) {
    return length != LOTTO_NUMBER_COUNT;
  }

  private String[] split(String winningNumbers) {
    return winningNumbers.replace(" ", "").split(",");
  }

}
