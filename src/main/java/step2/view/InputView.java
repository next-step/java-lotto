package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_AMOUNT = 1000;
    private static final int MIN_CNT = 6;

    private void isDigit(String input) {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private void isBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }
    }

    private void isOverMin(String amount) {
        if (Integer.parseInt(amount) < MIN_AMOUNT) {
            throw new IllegalArgumentException("로또를 사기에 부족한 금액입니다. 1000원이상 입력해주세요.");
        }
    }

    private void checkCnt(String winningNo) {
        String[] numbers = winningNo.split(",");
        if (numbers.length < MIN_CNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 입력해주셔야합니다.");
        }
    }

    public String ask(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }

    public int getLottoCnt(String amount) {
        //빈값 검사
        isBlank(amount);

        //숫자인지 검사
        isDigit(amount);

        //구매 최소금액 검사
        isOverMin(amount);

        int purchaseAmount = getPurchaseAmount(amount);
        int lottoCnt = purchaseAmount/LOTTO_PRICE;

        return lottoCnt;
    }

    public int getPurchaseAmount(String amount) {
        return Integer.parseInt(amount);
    }

    public List<Integer> getWinningNo(String winningNo) {
        //빈값 검사
        isBlank(winningNo);

        //6개인지 검사
        checkCnt(winningNo);

        String[] numbers = winningNo.split(",");
        for (String number : numbers) {
            //숫자인지 검사
            isDigit(number);
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
