package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {

    public static final int FIRST_PRIZE  = 2000000000;
    public static final int FIRST_COUNT  = 6;
    public static final int SECOND_PRIZE = 1500000;
    public static final int SECOND_COUNT = 5;
    public static final int THIRD_PRIZE  = 50000;
    public static final int THIRD_COUNT  = 4;
    public static final int FOURTH_PRIZE = 5000;
    public static final int FOURTH_COUNT = 3;

    private List<String[]> resultLottoNumbers = new ArrayList<>();
    private List<LottoResult> winnerResult = new ArrayList<>();

    public List<String[]> getLottoNumbers(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            resultLottoNumbers.add(LottoNumberGenerator.getNumber());
        }
        return resultLottoNumbers;
    }

    public int checkWinnerNumber(String[] winnerNumber, String[] userLottoNumber) {
        int matchingCount = 0;
        for (int i = 0; i < winnerNumber.length; i++) {
            matchingCount += (Arrays.asList(userLottoNumber).contains(winnerNumber[i])) ? 1 : 0;
        }
        return matchingCount;
    }

    public static int getLottoPrize(int matchingNumber){
        if(matchingNumber == FOURTH_COUNT) {
            return FOURTH_PRIZE;
        }
        if(matchingNumber == THIRD_COUNT) {
            return THIRD_PRIZE;
        }
        if(matchingNumber == SECOND_COUNT) {
            return SECOND_PRIZE;
        }
        if(matchingNumber == FIRST_COUNT) {
            return FIRST_PRIZE;
        }
        return 0;
    }

    public List<LottoResult> getLottoResult(List<String[]> lottoNumbers, String[] lastLottoNumber) {
        for (String[] lottoNumber : lottoNumbers) {
            setWinnerResult(checkWinnerNumber(lastLottoNumber, lottoNumber));
        }
        return winnerResult;
    }

    private void setWinnerResult(int matchingResult){
        int prize = getLottoPrize(matchingResult);
        if (prize > 0) {
            winnerResult.add(new LottoResult(prize, matchingResult));
        }
    }

}
