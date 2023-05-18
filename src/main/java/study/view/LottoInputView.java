package study.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {
    
    private final int lottoPrice = 1000;
    
    private int amount;
    private int lottoCount;
    private List<Integer> winNumbers = new ArrayList<>();
    
    public void purchase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        this.amount = Integer.parseInt(scanner.nextLine());

        this.lottoCount = this.amount / lottoPrice;
        System.out.println(this.lottoCount + "개를 구매했습니다.");
    }


    public void inputWinNumber() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String winnerNumbers = scanner.nextLine();

        for (String number : winnerNumbers.split(", ")) {
            winNumbers.add(Integer.parseInt(number));
        }
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
