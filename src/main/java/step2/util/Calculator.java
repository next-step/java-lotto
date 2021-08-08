package step2.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    static ArrayList<ArrayList> issuedLottolist;
    static final int NUM_OF_LOTTO_NUMBERS = 6;
    static int[] lottoResultArray;
    static ArrayList<Integer> lastWinningLottoNumberArray;

    public Calculator(ArrayList<ArrayList> issuedLottolist, ArrayList<Integer> lastWinningLottoNumberArray) {
        this.issuedLottolist = issuedLottolist;
        this.lastWinningLottoNumberArray = lastWinningLottoNumberArray;
    }

    public void run() {
        lottoResultArray = new int[NUM_OF_LOTTO_NUMBERS+1];
        for (ArrayList<Integer> issuedLotto : issuedLottolist) {
            calcMatchedLottoNum(issuedLotto);
        }
    }

    public void calcMatchedLottoNum(ArrayList<Integer> issuedLotto) {


        List<Integer> matchedLottoList = issuedLotto.stream()
                .filter(num -> lastWinningLottoNumberArray.contains(num))
                .collect(Collectors.toList());
        lottoResultArray[matchedLottoList.size()]++;
    }

    public int[] getLottoResultArray() {
        return lottoResultArray;
    }


}
