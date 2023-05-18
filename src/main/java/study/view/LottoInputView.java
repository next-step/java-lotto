package study.view;

import java.util.List;
import java.util.Scanner;

public class LottoInputView {
    
    private final int lottoPrice = 1000;
    
    private int amount;
    private int lottoCount;
    private List<Integer> winNumbers;
    
    public void purchase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        this.amount = Integer.parseInt(scanner.nextLine());

        this.lottoCount = this.amount / lottoPrice;
        System.out.println(this.amount + "개를 구매했습니다.");
    }


    public void win() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

    }

    public int getAmount() {
        return this.amount;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public List<Integer> getWinNumbers() {
        return this.winNumbers;
    }

}
