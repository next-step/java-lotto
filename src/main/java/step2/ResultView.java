package step2;

public class ResultView {

  private LottoMachine lottoMachine;
  private ReviewLotto reviewLotto;

  public ResultView(LottoMachine lottoMachine, ReviewLotto reviewLotto) {
    this.lottoMachine = lottoMachine;
    this.reviewLotto = reviewLotto;
  }

  public void statistics() {
    System.out.println("");
    System.out.println("당첨통계");
    System.out.println("----");
    System.out.println("3개 일치 (5000원)-" + reviewLotto.getLottoMatchCount(3, 5000) + "개");
    System.out.println("4개 일치 (50000원)-" + reviewLotto.getLottoMatchCount(4, 50000) + "개");
    System.out.println("5개 일치 (1500000원)-" + reviewLotto.getLottoMatchCount(5, 1500000) + "개");
    System.out
        .println("6개 일치 (2000000000원)-" + reviewLotto.getLottoMatchCount(6, 2000000000) + "개");

  }

  public void printEarnSummary() {
    //이 시점에서 전체 얻은 금액과 구매한 금액을 알고 있어야함
    double earnPercent = (double)reviewLotto.getTotalEarnAmount() / lottoMachine.inputAmount;

    System.out.println("총 수익율은 " + Math.round(earnPercent*100) / 100.0 + "입니다.");

  }
}
