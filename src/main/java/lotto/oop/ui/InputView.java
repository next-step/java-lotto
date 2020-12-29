package lotto.oop.ui;

import lotto.oop.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class InputView {
    public static final int PIRCE_ONE_LOTTO = 1000;
    private int amount;
    private int count;

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

    public String winngNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        return numbers;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }
}