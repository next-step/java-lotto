package lotto.views;

import lotto.Rank;

public interface ROLottoResult {

  int getNumRanks();

  Rank getRank(int i);

  int getCount(Rank rank);
}
