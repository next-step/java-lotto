package lotto.view;

public class OutputView {
    private int lottoCount = 0;
    private int threeWinCount = 0;
    private int fourWinCount = 0;
    private int fiveWinCount = 0;
    private int sixWinCount = 0;

    public OutputView() {

    }

    public OutputView(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void printLottoCnt() {
        System.out.println(this.lottoCount + "개를 구매했습니다.");
    }


    public void printLottoResult(int threeWinCount, int fourWinCount, int fiveWinCount, int sixWinCount) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치(5,000원)- " + threeWinCount + "개");
        System.out.println("4개 일치(50,000원)- " + fourWinCount + "개");
        System.out.println("5개 일치(1,500,000원)- " + fiveWinCount + "개");
        System.out.println("6개 일치(2,000,000,000원)- " + sixWinCount + "개");
    }

    public void printRate(float rate) {
        System.out.println("총 수익률은 " + rate);
    }

}
