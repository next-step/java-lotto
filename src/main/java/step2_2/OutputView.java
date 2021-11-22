package step2_2;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoBundle(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.lottoCount() + "개를 구입하셨습니다");
        System.out.println(lottoBundle);
    }
}
