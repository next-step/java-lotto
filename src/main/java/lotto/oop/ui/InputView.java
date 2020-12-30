package lotto.oop.ui;

import lotto.oop.domain.LottoNumber;
import lotto.oop.domain.WinNumber;

import java.util.*;

public class InputView {
    public static final String COMMA = ",";
    public static final int PIRCE_ONE_LOTTO = 1000;
    private int amount;
    private int count;

    private WinNumber winNumberInfo;

    public void purchaseInfo() {
        System.out.println("구입금액을 입력해 주세요");
        Scanner sc = new Scanner(System.in);
        this.amount = sc.nextInt();
        this.count = this.amount / PIRCE_ONE_LOTTO;
        System.out.println(this.count + "개를 구매했습니다.");
    }

    public void printLotto(List<LottoNumber> publishLottoList) {
        for (LottoNumber list: publishLottoList) {
            System.out.println(list.getGenerateNumbers());
        }
    }

    public void winngNumbersInfo() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        String[] splitNumbers = numbers.split(COMMA);
        List<Integer> numberList = new ArrayList<>();
        for(String number : splitNumbers) {
            numberList.add(Integer.parseInt(number));
        }
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = sc.nextLine();
        winNumberInfo = new WinNumber(numberList, Integer.parseInt(bonusBall));
    }

    public int getAmount() {
        return amount;
    }
    public int getCount() {
        return count;
    }

    public WinNumber getWinNumberInfo() {
        return winNumberInfo;
    }

}