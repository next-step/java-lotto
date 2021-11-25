package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryCompany {

  private static final String ALREADY_REGISTERED_ROUND = "이미 당첨번호가 등록된 회차입니다.";
  private static final String WINNING_LOTTO_NOT_FOUND = "당첨번호가 등록되지 않은 회차입니다.";

  private static Map<Integer, List<LottoNumber>> winningLottoNumbersEachRound = new HashMap();

  private LotteryCompany() { }

  public List<LottoNumber> getWinningLottoByRound(int round) {
    List<LottoNumber> winningLottoNumbers = LotteryCompany.winningLottoNumbersEachRound.get(round);
    if (winningLottoNumbers.isEmpty()) {
      throw new IllegalArgumentException(WINNING_LOTTO_NOT_FOUND);
    }
    return winningLottoNumbers;
  }

  public void putWinningLotto(int round, List<LottoNumber> winningLottoNumbers) {
    if (winningLottoNumbersEachRound.get(round) != null) {
      throw new IllegalArgumentException(ALREADY_REGISTERED_ROUND);
    }
    winningLottoNumbersEachRound.put(round, winningLottoNumbers);
  }

}
