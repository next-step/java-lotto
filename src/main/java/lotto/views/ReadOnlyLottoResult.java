package lotto.views;

import lotto.Rank;

public interface ReadOnlyLottoResult {

  int getNumRanks();

  Rank getRank(int i);

  int getCount(Rank rank);
}
