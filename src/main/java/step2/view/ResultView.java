package step2.view;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultView {
    static int[] charge = {0,0,0,5000,50000,1500000,2000000000};
    public void printIssuedLottoNumber(String[] lotto) {
        System.out.println(Arrays.toString(lotto));
    }

    public void printMatchedLottoRecord(int[] matchedLottoRecordArray, int numOfLotto) {
        int totalRevenue = 0;
        System.out.println("당첨 통계");
        System.out.println("-------");
        for (int i = 1; i <= 6; i++) {
            System.out.printf("%s 개 일치 (%s) %s개\n",i,charge[i],matchedLottoRecordArray[i]);
            totalRevenue += charge[i] * matchedLottoRecordArray[i];
        }

        double yield =  totalRevenue / (double)(numOfLotto * 1000);
        printResultMessage(yield);

    }

    private void printResultMessage(double yield) {
        if (yield < 1) {
            System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",yield);
            return;
        }
        if (yield >= 1) {
            System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 이익이라는 의미임)",yield);
            return;
        }

    }

    public void printIssuedLottoList(ArrayList<ArrayList> issuedLottolist) {
        issuedLottolist.stream()
                .forEach(issuedLotto -> System.out.println(issuedLotto));
    }
}
