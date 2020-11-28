package step2;

import java.util.List;

public class Lotto {
    public static List<Integer> numberList;

    public Lotto(Generator lottoGenerator) {
        numberList = lottoGenerator.getLottoNumbers();
    }

    public int checkReward(List<Integer> result) {
        int winningNumber = 0;
        for(int i: result) {
            if(numberList.contains(i)) {
                winningNumber ++;
            }
        }
        return winningNumber;
    }
}
