package lotto.view;


public class ResultView {

    private ResultView() {
    }

    public static void printView(String str) {
        System.out.println(str);
    }

    public static void printLottoNumberView(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }


}
