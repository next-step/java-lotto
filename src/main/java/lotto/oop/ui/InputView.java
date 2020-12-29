package lotto.oop.ui;

import lotto.oop.domain.LottoNumber;

import java.util.*;

public class InputView {
    public static final int PIRCE_ONE_LOTTO = 1000;
    private int amount;
    private int count;

    private Map<Integer, String> winNumberInfo = new HashMap<>();

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
        winNumberInfo.put(1, numbers);
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = sc.nextLine();
        winNumberInfo.put(2, bonusBall);
    }

    public int getAmount() {
        return amount;
    }
    public int getCount() {
        return count;
    }
    public Map<Integer, String> getWinNumberInfo() {
        return winNumberInfo;
    }
}