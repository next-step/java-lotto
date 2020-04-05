package Lotto;

public class ResultView {

    private final int FIFTH_PRIZE = 5_000;
    private final int FOURTH_PRIZE = 50_000;
    private final int THIRD_PRIZE = 1_500_000;
    private final int FIRST_PRIZE = 2_000_000_000;

    public void showQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void showLottoNumbers(LottoBundle lottoBundle) {
        for (int i = 0; i < lottoBundle.getSize(); i++) {
            LottoPaper tempPaper = lottoBundle.getLottoPaper(i);
            lottoNumberShower(tempPaper);
            System.out.println("");
        }
    }

    public void lottoNumberShower(LottoPaper paper) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < paper.getSize(); i++) {
            builder.append(paper.getNumber(i));
            builder.append(",");
        }
        String temp = builder.toString();
        temp = temp.substring(0, temp.length() - 1);
        System.out.print(temp + "]");
    }

    public void showWinner(int[] winnerArray, Amount amount) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (int i = 0; i < winnerArray.length; i++) {
            System.out.println(winnerArray[i]);
        }

        System.out.println("3개 일치 (5000원) - " + winnerArray[3]+"개");
        System.out.println("4개 일치 (50000원) - " + winnerArray[4]+"개");
        System.out.println("5개 일치 (1500000원) - " + winnerArray[5]+"개");
        System.out.println("6개 일치 (2000000000원) - " + winnerArray[6]+"개");
        double winPrize = winnerArray[3] * FIFTH_PRIZE + winnerArray[4] * FOURTH_PRIZE
                + winnerArray[5] * THIRD_PRIZE + winnerArray[6] * FIRST_PRIZE;
        double rate = winPrize == 0 ? 0 : Math.round(((winPrize / amount.getAmount()) * 100)/100.0);
        System.out.println("총 수익률은 " + rate + "입니다.");

    }
}
