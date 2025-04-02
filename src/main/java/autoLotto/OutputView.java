package autoLotto;

public class OutputView {
    void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계\n" + "---------\n" + lottoResult);
    }
}
