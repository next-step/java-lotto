package Lotto;

import java.util.List;

public class ResultView {

    public static void viewLottoNumbers(List<Lotto> lottoList) {
        int lottoNum = lottoList.size();
        System.out.println(lottoNum + "개를 구매했습니다.");

        for (int i = 0; i < lottoNum; ++i) {
            System.out.print("[");
            showLottoNumbers(lottoList, i);
            System.out.print("]");
            System.out.println();
        }
    }

    private static void showLottoNumbers(List<Lotto> lottoList, int i) {
        for(int k = 0; k < 6; ++k) {
            System.out.print(lottoList.get(i).numbers.get(k));
            if(k < 5)
                System.out.print(", ");
        }
    }
}
