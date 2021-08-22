package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoStore {

  private static final int LOTTO_PICAKABLE_NUMBERS = 6;
  private static final int LOTTO_LARGEST_NUMBER = 45;
  private static final int LOTTO_PRICE = 1000;

  public Lottos purchase(int userAmount) {
    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      lottos.add(new Lotto(getLottoRandomNumbers()));
    }

    return new Lottos(lottos);
  }

  public Lottos purchase(int userAmount, List<Integer> lottoNumbers) {
    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      lottos.add(new Lotto(lottoNumbers));
    }

    return new Lottos(lottos);
  }

  private List<Integer> getLottoRandomNumbers() {
    List lottoNumbers = new ArrayList();
    for (int i = 0; i < LOTTO_PICAKABLE_NUMBERS; i++) {
      lottoNumbers.add(getRandomNum(lottoNumbers));
    }

    Collections.shuffle(lottoNumbers);
    Collections.sort(lottoNumbers);

    return lottoNumbers;
  }

  private int getRandomNum(List<Integer> lottoNumbers) {
    int randomNum;
    do {
      randomNum = new Random().nextInt(LOTTO_LARGEST_NUMBER) + 1;
    } while (lottoNumbers.contains(randomNum));

    return randomNum;
  }

  public LottoWin draw(Lottos lottos, String[] lottowinningNumbers) {
    LottoWin lottoWin = new LottoWin(lottowinningNumbers);
    return lottoWin.draw(lottos);
  }
}
