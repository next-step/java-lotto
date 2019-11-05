package step2;

import java.util.ArrayList;

public class ReviewLotto {

  private static final String LOTTO_WINNER_NUMBER_SPLIT = ",";
  private int totalEarnAmount = 0;
  private String inputLottoWinnerNumber;
  private ArrayList<ArrayList<String>> lottoNumberTicketArr;

  public int getTotalEarnAmount() {
    return this.totalEarnAmount;
  }

  public ReviewLotto(String inputLottoWinnerNumber,
      ArrayList<ArrayList<String>> lottoNumberTicketArr) {
    this.inputLottoWinnerNumber = inputLottoWinnerNumber;
    this.lottoNumberTicketArr = lottoNumberTicketArr;
  }

  public int getLottoMatchCount(int num, int amount) {
    int returnValue = 0;
    for (ArrayList<String> lottoNumberTicket : lottoNumberTicketArr) {
      returnValue += checkLottoNumberMatch(num, lottoNumberTicket);
    }
    totalEarnAmount += (returnValue * amount);
    return returnValue;
  }

  private int checkLottoNumberMatch(int num, ArrayList<String> lottoNumberTicket) {
    int matchCount = 0;
    String[] inputLottoWinnerNumberArr = inputLottoWinnerNumber.split(LOTTO_WINNER_NUMBER_SPLIT);
    for (int i = 0; i < inputLottoWinnerNumberArr.length; i++) {
      matchCount += checkLottoWinnerNumberArrInLottoNumberTicket(lottoNumberTicket, inputLottoWinnerNumberArr[i]);
    }
    if (matchCount == num) {
      return 1;
    }
    return 0;
  }

  private int checkLottoWinnerNumberArrInLottoNumberTicket(ArrayList<String> lottoNumberTicket,
      String inputLottoWinnerNumber) {
    if (lottoNumberTicket.contains(inputLottoWinnerNumber)) {
      return 1;
    }
    return 0;
  }

}
