package lotto.domains;

public class LottoResult {

    private final int matchCnt;

    private final int prize;

    private int numOfLottos;


    public LottoResult(int matchCnt, int prize) {
        this.matchCnt = matchCnt;
        this.prize = prize;
        this.numOfLottos = 0;
    }

    public void addWinner() {
        numOfLottos++;
    }

    public boolean match(int matchCnt) {
        return this.matchCnt == matchCnt;
    }

    public String detailedInfo() {
        return new StringBuilder()
                .append(matchCnt)
                .append("개 일치 (")
                .append(prize)
                .append("원)- ")
                .append(numOfLottos)
                .append("개")
                .toString();
    }


    public int totalPrizeAmount() {
        return prize * numOfLottos;
    }
}
