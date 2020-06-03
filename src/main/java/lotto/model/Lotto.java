package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {

    public static final int FIRST_PRIZE = 2000000000;
    public static final int SECOND_PRIZE = 1500000;
    public static final int THIRD_PRIZE  = 50000;
    public static final int FOURTH_PRIZE = 5000;

    private List<String[]> resultLottoNumbers = new ArrayList<>();

    public List<String[]> getLottoNumbers(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            resultLottoNumbers.add(NumberGenerator.getNumber());
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

    public int getLottoPrize(int matchingNumber){
        if(matchingNumber == 3) {
            return FOURTH_PRIZE;
        }
        if(matchingNumber == 4) {
            return THIRD_PRIZE;
        }
        if(matchingNumber == 5) {
            return SECOND_PRIZE;
        }
        if(matchingNumber == 6) {
            return FIRST_PRIZE;
        }
        return 0;
    }
}
