package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.LottoPurchases;

import java.util.Scanner;

public class LottoQuestion {

    private final int price;

    public LottoQuestion(int price){
        this.price = price;
    }

    public static LottoQuestion inputLottoPrice(){
        int purchasesMoney = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요.");
        purchasesMoney = new LottoPurchases(sc.nextInt()).getLottoMachineCount();
        return new LottoQuestion(purchasesMoney);
    }

    public int getPrice() {
        return price;
    }
}
