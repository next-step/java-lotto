package view;

import java.util.ArrayList;

public class ResultView {
    public static void printLottoNumber(ArrayList<ArrayList<Integer>> lotto){
        System.out.println(lotto.size()+"개를 구매하셨습니다.");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.println(lotto.get(i));
        }
    }
}
