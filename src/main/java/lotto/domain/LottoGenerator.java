package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
  private static final int LOTTO_PRICE = 1000;
  private static final int LOTTO_SIZE = 6;
  private static final List<LottoNumber> ALL_LOTTO_NUMBERS =
      IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
          .mapToObj(LottoNumber::new)
          .collect(Collectors.toList());

  public List<Lotto> generate(int money) {
    validateMoney(money);
    int lottoCount = money / LOTTO_PRICE;

    return IntStream.range(0, lottoCount)
        .mapToObj(i -> generateRandomLotto())
        .collect(Collectors.toList());
  }

  private void validateMoney(int money) {
    if (money < LOTTO_PRICE) {
      throw new IllegalArgumentException("로또 구입 금액은 최소 1000원 이상이어야 합니다.");
    }

    if (money % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException("로또 구입 금액은 1000원 단위여야 합니다.");
    }
  }

  private Lotto generateRandomLotto() {
    List<LottoNumber> numbers = new ArrayList<>(ALL_LOTTO_NUMBERS);
    Collections.shuffle(numbers);
    List<LottoNumber> selectedNumbers = numbers.subList(0, LOTTO_SIZE);

    selectedNumbers.sort((ln1, ln2) -> Integer.compare(ln1.getNumber(), ln2.getNumber()));

    return new Lotto(selectedNumbers);
  }
}
