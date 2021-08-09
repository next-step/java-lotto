package step2.view;

import step2.model.LottoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    public String ask(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }

    public int getLottoCnt(String amount) {
        //빈값 검사
        LottoException.isBlank(amount);

        //숫자인지 검사
        LottoException.isDigit(amount);

        //구매 최소금액 검사
        LottoException.isOverMin(amount);

        int purchaseAmount = getPurchaseAmount(amount);
        int lottoCnt = purchaseAmount/LOTTO_PRICE;

        return lottoCnt;
    }

    public int getPurchaseAmount(String amount) {
        return Integer.parseInt(amount);
    }

    public List<Integer> getWinningNo(String winningNo) {
        //빈값 검사
        LottoException.isBlank(winningNo);

        //6개인지 검사
        LottoException.checkCnt(winningNo);

        String[] numbers = winningNo.split(",");
        for (String number : numbers) {
            //숫자인지 검사
            LottoException.isDigit(number);
        }

        List<Integer> winNoList = new ArrayList<>();
        for (String number : numbers) {
            int winNo = Integer.parseInt(number);
            //같은 숫자 포함 여부 검사
            containSameNo(winNoList, winNo);
        }

        return winNoList;

    }

    private void containSameNo(List<Integer> winNoList, int winNo) {
        if (winNoList.contains(winNo)) {
            throw new IllegalArgumentException("당첨번호가 중복되었습니다. 다시 입력해주세요");
        }

        winNoList.add(winNo);
    }
}
