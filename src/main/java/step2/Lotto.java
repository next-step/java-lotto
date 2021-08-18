package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {

  final static int LOTTO_PICAKABLE_NUMBERS = 6;
  final static int LOTTO_LARGEST_NUMBER = 45;

  private List<Integer> lottoNumbers;
  private Random random;

  public Lotto() {
    lottoNumbers = new ArrayList();
    random = new Random();
  }

  public void draw() {

    for (int i = 0; i < LOTTO_PICAKABLE_NUMBERS; i++) {
      lottoNumbers.add(getRandomNum(lottoNumbers));
    }

    Collections.shuffle(lottoNumbers);
    Collections.sort(lottoNumbers);
  }

  private int getRandomNum(List<Integer> lottoNumbers) {

    int randomNum;
    do {
      randomNum = random.nextInt(LOTTO_LARGEST_NUMBER) + 1;
    } while (lottoNumbers.contains(randomNum));

    return randomNum;
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers;
  }
}
