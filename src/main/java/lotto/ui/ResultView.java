package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseQuantity;

public class ResultView {

    private static int manual;

    private ResultView(){}

    public static void printPurchaseCount(PurchaseQuantity all, PurchaseQuantity manual){
        System.out.println("수동으로 "+ manual.find()+"장, 자동으로 "+(all.find()-manual.find())+"개를 구매했습니다.");
    }

    public static void printLottoList(Lottos lottos){
        for(Lotto lotto : lottos.find()){
            System.out.println(lotto.find());
        }
    }
}
