package lotto.domain;

import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.GenerateLottoNumber;

public class Lotties {

  List<Lotto> lotties = new ArrayList<>();

  public Lotties() {
  }

  public Lotties(int count, GenerateLottoNumber generateLottoNumber) {
    createLotties(count, generateLottoNumber);
  }

  public List<Lotto> getLotties() {
    return lotties;
  }

  public void createLotties(int count, GenerateLottoNumber generateLottoNumber) {
    range(0, count).forEach(i -> lotties.add(new Lotto(generateLottoNumber)));
  }

  public int getMatchLotties(Lotto lotty, Lotto winLotto) {
    int count = 0;
    for (LottoNumber lottoNumber : lotty.getLotto()) {
      if (winLotto.getWinLotto().contains(lottoNumber)) {
        count++;
      }
    }
    return count;
  }

  public static Lotto getWinningLotto(String[] inputValues) {
    return new Lotto(inputValues);
  }
}
