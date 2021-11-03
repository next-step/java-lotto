package lotto.views;

public class ResultView {

    public static void printLottoCount(int lottosCnt) {
        StringBuilder sb = new StringBuilder(lottosCnt);
        sb.append(" 개를 구매했습니다.");

        System.out.println(sb.toString());
    }

}
