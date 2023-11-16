package lotto;

public class LottoResult {

    private final int tree;
    private final int four;
    private final int five;
    private final int six;
    private final double rateOfReturn;

    public LottoResult(int tree, int four, int five, int six, double rateOfReturn) {
        this.tree = tree;
        this.four = four;
        this.five = five;
        this.six = six;
        this.rateOfReturn= rateOfReturn;
    }

    @Override
    public String toString() {
        String rateOfReturnMessage = "입니다.(기준이 0이기 때문에 결과적으로 손해라는 의미임)";
        if(this.rateOfReturn == 0){
            rateOfReturnMessage = "입니다.(기준이 0이기 때문에 결과적으로 본전임)";
        }
        if(this.rateOfReturn > 0){
            rateOfReturnMessage = "입니다.(기준이 0이기 때문에 결과적으로 수익이라는 의미임)";
        }
        return "당첨 통계" + "\n" +
                "---------" + "\n" +
                "3개 일치 (5000원)- " + this.tree + "\n" +
                "4개 일치 (50000원)- " + this.four + "\n" +
                "5개 일치 (1500000원)- " + this.five + "\n" +
                "6개 일치 (2000000000)- " + this.six + "\n" +
                "총 수익률은 " + this.rateOfReturn +
                rateOfReturnMessage;
    }
}
