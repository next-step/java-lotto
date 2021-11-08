package lotto.domains;

import java.util.Objects;

public class LottoResult {

    private final int matchCnt;

    private final int prize;

    private int numOfLotto;

    public LottoResult(int matchCnt, int prize) {
        this.matchCnt = matchCnt;
        this.prize = prize;
        this.numOfLotto = 0;
    }

    public LottoResult(int matchCnt, int prize, int numOfLotto) {
        this.matchCnt = matchCnt;
        this.prize = prize;
        this.numOfLotto = numOfLotto;
    }

    public void addWinner(int matchCnt) {
        if (this.matchCnt == matchCnt) {
            numOfLotto++;
        }
    }

    public String detailedInfo() {
        return new StringBuilder()
                .append(matchCnt)
                .append("개 일치 (")
                .append(prize)
                .append("원)- ")
                .append(numOfLotto)
                .append("개")
                .toString();
    }


    public int prizeSum() {
        return prize * numOfLotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return matchCnt == that.matchCnt && prize == that.prize && numOfLotto == that.numOfLotto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCnt, prize, numOfLotto);
    }
}
