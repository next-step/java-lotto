package lotto.vo;

public class LottoMatchCount {
    private int firstCnt;
    private int secondCnt;
    private int thirdCnt;
    private int forthCnt;
    private int fifthCnt;

    public LottoMatchCount() {
        firstCnt = 0;
        secondCnt = 0;
        thirdCnt = 0;
        forthCnt = 0;
        fifthCnt = 0;
    }

    public LottoMatchCount(int firstCnt, int secondCnt, int thirdCnt, int forthCnt, int fifthCnt) {
        this.firstCnt = firstCnt;
        this.secondCnt = secondCnt;
        this.thirdCnt = thirdCnt;
        this.forthCnt = forthCnt;
        this.fifthCnt = fifthCnt;
    }

    public void incrementFirstCount() {
        firstCnt++;
    }

    public void incrementSecondCount() {
        secondCnt++;
    }

    public void incrementThirdCount() {
        thirdCnt++;
    }

    public void incrementForthCount() {
        forthCnt++;
    }

    public void incrementFifthCount() {
        fifthCnt++;
    }

    public int getFirstCnt() {
        return firstCnt;
    }

    public int getSecondCnt() {
        return secondCnt;
    }

    public int getThirdCnt() {
        return thirdCnt;
    }

    public int getForthCnt() {
        return forthCnt;
    }

    public int getFifthCnt() {
        return fifthCnt;
    }
}
