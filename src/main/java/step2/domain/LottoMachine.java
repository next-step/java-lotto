package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private String lastLottoNum;
    private static ArrayList<Integer> lottoArray = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42));
    private static final int COUNT_OF_LOTTO = 6;

    public LottoMachine(String lastLottoNum) {
        this.lastLottoNum = lastLottoNum;
        checkValidInput();
    }

    public LottoMachine() {

    }

    public static int[] issueLotto() {
        Collections.shuffle(lottoArray);
        int[] lotto = new int[COUNT_OF_LOTTO];
        for (int i = 0; i < COUNT_OF_LOTTO; i++) {
            lotto[i] = lottoArray.get(i);
        }
        return lotto;
    }

    private void checkValidInput() {
        String[] lastLottoNumArray = stringSpliter();
        if (lastLottoNumArray.length != COUNT_OF_LOTTO) {
            throw new IllegalArgumentException("로또 당첨번호는 6개를 입력하세요. 당첨번호는 ', '로 구분을 하고 있습니다.");
        }
    }

    private String[] stringSpliter() {
        return lastLottoNum.split(", ");

    }
}
