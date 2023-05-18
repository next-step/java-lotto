package model;

import static model.LottoNumberGenerator.LOTTO_NUMBER_COUNT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Lotto {

  private final Set<LottoNo> lotto;

  public Lotto(String input) {
    Set<LottoNo> lotto = new HashSet<>(toLottoNos(toIntegers(split(input))));
    if (isLottsSizeEqualTo(lotto.size())) {
      throw new IllegalArgumentException("로또 번호는 중복되지 않은 숫자로 " + LOTTO_NUMBER_COUNT + "개여야합니다.");
    }
    this.lotto = lotto;
  }

  public Lotto(Set<LottoNo> lotto) {
    this.lotto = lotto;
  }

  public boolean has(LottoNo lottoNo) {
    return lotto.contains(lottoNo);
  }

  public boolean has(BonusBall bonusBall) {
    return lotto.stream().anyMatch(bonusBall::equals);
  }

  public int countMatchesNumber(WinningNumbers winningNumbers) {
    return (int) lotto.stream().filter(winningNumbers::has).count();
  }

  private List<LottoNo> toLottoNos(Integer[] integers) {
    List<LottoNo> winningNumbers = new LinkedList<>();
    for (Integer number : integers) {
      winningNumbers.add(LottoNo.of(number));
    }
    return winningNumbers;
  }

  private Integer[] toIntegers(String[] tokens) {
    if (isLottsSizeEqualTo(tokens.length)) {
      throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야합니다.");
    }

    Integer[] integers = new Integer[LOTTO_NUMBER_COUNT];
    for (int i = 0; i < tokens.length; i++) {
      integers[i] = Integer.parseInt(tokens[i]);
    }
    return integers;
  }

  private boolean isLottsSizeEqualTo(int length) {
    return length != LOTTO_NUMBER_COUNT;
  }

  private String[] split(String lottoNumbers) {
    return lottoNumbers.replace(" ", "").split(",");
  }

  public Set<LottoNo> getLotto() {
    return lotto;
  }

  @Override
  public String toString() {
    return Arrays.toString(lotto.stream().sorted().toArray());
  }
}
