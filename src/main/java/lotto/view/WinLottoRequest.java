package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.*;

public class WinLottoRequest {

    private LottoNumbers lottoNumber;

    public WinLottoRequest(String previousWeekNumber) {
        this.lottoNumber = numberSet(previousWeekNumber);
    }

    public static WinLottoRequest lottoWinNumber() {
        String previousWeekNumber = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        previousWeekNumber = sc.next();

        return new WinLottoRequest(previousWeekNumber);
    }

    public LottoNumbers getLottoNumber() {
        return lottoNumber;
    }

    private static LottoNumbers numberSet(String previousWeekNumber) {
        Set<LottoNumber> numberList = new HashSet<>();
        String[] numberSplit = previousWeekNumber.split(",");

        for (String number : numberSplit) {
            numberList.add(new LottoNumber(Integer.parseInt(number)));
        }

        return new LottoNumbers(numberList);
    }
}
