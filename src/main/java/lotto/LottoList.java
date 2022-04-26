package lotto;

import static util.Validator.validateArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class LottoList {

  private static final String ERROR_MESSAGE_FOR_INVALID_AMOUNT = "Lotto를 생성할 숫자는 0보다 커야합니다.";
  private static final String LOTTO_DELIMITER = "\n";
  private final List<Lotto> lottoList = new ArrayList<>();


  LottoList(int amount) {
    validateAmount(amount);
    for (int i = 0; i < amount; i++) {
      lottoList.add(new Lotto());
    }
  }

  LottoList(List<Lotto> lottoList) {
    this.lottoList.addAll(lottoList);
  }

  public int getMatchedLottoCount(int matchedCount, Lotto otherLotto) {
    return (int) lottoList.stream()
        .filter(lotto -> lotto.matches(matchedCount, otherLotto))
        .count();
  }

  public int getTotalLottoCount() {
    return lottoList.size();
  }

  @Override
  public String toString() {
    StringJoiner joiner = new StringJoiner(LOTTO_DELIMITER);
    lottoList.forEach(lotto -> joiner.add(lotto.toString()));
    return joiner.toString();
  }

  private void validateAmount(int amount) {
    validateArgument(
        amount,
        (arg) -> amount > 0,
        ERROR_MESSAGE_FOR_INVALID_AMOUNT
    );
  }
}
