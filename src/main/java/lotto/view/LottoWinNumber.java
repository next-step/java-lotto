package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoWinNumber {

    private LottoNumbers lottoNumber;

    public LottoWinNumber(String previousWeekNumber){
        this.lottoNumber = numberSet(previousWeekNumber);
    }

    public static LottoWinNumber lottoWinNumber(){
        String previousWeekNumber = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        previousWeekNumber = sc.next();

        return new LottoWinNumber(previousWeekNumber);
    }

    public LottoNumbers getLottoNumber() {
        return lottoNumber;
    }

    private static LottoNumbers numberSet(String previousWeekNumber){
        List<Integer> numberList = new ArrayList<>();
        String[] numberSplit = previousWeekNumber.split(",");

        for(String number : numberSplit){
            numberList.add(Integer.parseInt(number));
        }

        return new LottoNumbers(numberList);
    }
}
