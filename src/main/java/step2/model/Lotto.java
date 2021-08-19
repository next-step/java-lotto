package step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {

  private final static int LOTTO_PICAKABLE_NUMBERS = 6;
  private final static int LOTTO_LARGEST_NUMBER = 45;
  private final static int LOTTO_4RT_MATCH_NUMBER = 3;
  private final static int LOTTO_3RD_MATCH_NUMBER = 4;
  private final static int LOTTO_2ND_MATCH_NUMBER = 5;
  private final static int LOTTO_1ST_MATCH_NUMBER = 6;

  private List<Integer> lottoNumbers;
  private Random random;
  private int winRank;

  public Lotto() {
    winRank = 0;
    random = new Random();
    lottoNumbers = purchase();
  }

  public Lotto(List<Integer> lottoNumbers) {
    winRank = 0;
    random = new Random();
    this.lottoNumbers = lottoNumbers;
  }

  private List purchase() {
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
      randomNum = random.nextInt(LOTTO_LARGEST_NUMBER) + 1;
    } while (lottoNumbers.contains(randomNum));

    return randomNum;
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers;
  }

  public void countUpWinRank() {
    winRank++;
  }

  public void calculateWin(LottoWin lottoWin) {

    if (winRank == LOTTO_4RT_MATCH_NUMBER) {
      lottoWin.countUpFourthWinner();
    }

    if (winRank == LOTTO_3RD_MATCH_NUMBER) {
      lottoWin.countUpThirdWinner();
    }

    if (winRank == LOTTO_2ND_MATCH_NUMBER) {
      lottoWin.countUpSecondWinner();
    }

    if (winRank == LOTTO_1ST_MATCH_NUMBER) {
      lottoWin.countUpFirstWinner();
    }
  }
}
