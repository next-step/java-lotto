package step2.view;

import step2.model.LottoException;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    public int getAmount(String amount) {
        //빈값 검사
        LottoException.isBlank(amount);

        //숫자인지 검사
        LottoException.isDigit(amount);

        //구매 최소금액 검사
        LottoException.isOverMin(amount);

        int purchaseAmount = Integer.parseInt(amount);
        int lottoCnt = purchaseAmount/LOTTO_PRICE;

        return lottoCnt;
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
