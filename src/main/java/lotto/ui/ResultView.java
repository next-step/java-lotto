package lotto.ui;

import java.util.List;

public class ResultView {
    public static void printLottoCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }
    public static void printLottoBundle(List<String> result){
        for(String string : result){
            System.out.println(string);
        }
    }
}
