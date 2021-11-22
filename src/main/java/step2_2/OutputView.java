package step2_2;

public class OutputView {

    private static final String RESULT_PRINT_MESSAGE = "당첨 통계";
    private static final String LINE = "------------";

    private OutputView() {
    }

    public static void printLottoBundle(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getLottoCount() + "개를 구입하셨습니다");
        System.out.println(lottoBundle);
    }
}
