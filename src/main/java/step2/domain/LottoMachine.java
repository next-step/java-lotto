package step2.domain;

import step2.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LottoMachine {
    private static String[] lastLottoNumArray;
    private static ArrayList<String> lottoNumberList = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42"));
    private static final int COUNT_OF_LOTTO = 6;
    private static int numOfLotto;
    private static int[] matchedLottoRecordArray = new int[COUNT_OF_LOTTO+1];
    private static ResultView resultView = new ResultView();

    public LottoMachine(String lastLottoNum, int numOfLotto) {
        this.lastLottoNumArray = checkValidInput(lastLottoNum);
        this.numOfLotto = numOfLotto;
    }

    public LottoMachine() {
    }

    public void run() {
        for (int i = 0; i < numOfLotto; i++) {
            issueLotto();
        }
        resultView.printMatchedLottoRecord(matchedLottoRecordArray, numOfLotto);
    }

    public static int compareLottoWithLastLottoNumber(String issuedLotto ) {
        int isMatch = 0;
        for (String lastLottoNumber: lastLottoNumArray) {
//            isMatch += isEqual(issuedLotto, lastLottoNumber);
            isMatch += isEqual(issuedLotto, lastLottoNumber);
        }
        return isMatch;
    }

    public static int isEqual(String issuedLottoNumer, String lastLottoNumber) {
        if (issuedLottoNumer.equals(lastLottoNumber)) {
            return 1;
        }
        return 0;
    }

    public static String[] issueLotto() {
        int matchedNumber = 0;
        Collections.shuffle(lottoNumberList);
        String[] lotto = new String[COUNT_OF_LOTTO];
        for (int i = 0; i < COUNT_OF_LOTTO; i++) {
            String issuedLottoNum = lottoNumberList.get(i);
            lotto[i] = issuedLottoNum;
            matchedNumber += compareLottoWithLastLottoNumber(issuedLottoNum);
        }
        resultView.printIssuedLottoNumber(lotto);
        matchedLottoRecordArray[matchedNumber]++;
        System.out.println(matchedNumber);
        return lotto;
    }

    private String[] checkValidInput(String lastLottoNum) {
        String[] lastLottoNumArray = stringSpliter(lastLottoNum);
        if (lastLottoNumArray.length != COUNT_OF_LOTTO) {
            throw new IllegalArgumentException("로또 당첨번호는 6개를 입력하세요. 당첨번호는 ', '로 구분을 하고 있습니다.");
        }
        return lastLottoNumArray;
    }

    private String[] stringSpliter(String lastLottoNum) {
        return lastLottoNum.split(", ");
    }
}
