package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

  private static final int LOTTO_PRICE = 1000;
  private final List<Integer> CANDIDATE_NUMBERS = initCandidateNumbers();
  private final List<Lotto> lottos = new ArrayList<>();

  public LottoGame(int money) {
    checkMoney(money);
    generateLottos(money / LOTTO_PRICE);
  }

  public List<Lotto> getLotto() {
    return lottos;
  }

  private void generateLottos(int cnt) {
    for (int i = 0; i < cnt; i++) {
      lottos.add(new Lotto(selectedNumbers()));
    }
  }

  private List<Integer> selectedNumbers() {
    Collections.shuffle(CANDIDATE_NUMBERS);
    return CANDIDATE_NUMBERS.subList(0, Lotto.NUMBER_SIZE);
  }

  private List<Integer> initCandidateNumbers() {
    return IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
        .boxed().collect(Collectors.toList());
  }

  private void checkMoney(int money) {
    if (money < LOTTO_PRICE) {
      throw new IllegalArgumentException("최소 구매 금액은 " + LOTTO_PRICE + "원 입니다.");
    }
  }
}
