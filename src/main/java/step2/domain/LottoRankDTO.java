package step2.domain;

public class LottoRankDTO {
    int threeMatchCount = 0;

    int fourMatchCount = 0;

    int fiveMatchCount = 0;

    int sixMatchCount = 0;

    public void setMatchCount(int matchCount) {
        plusThreeMatchCount(matchCount);
        plusFourMatchCount(matchCount);
        plusFiveMatchCount(matchCount);
        plusSixMatchCount(matchCount);
    }

    public int getThreeMatchCount() {
        return threeMatchCount;
    }

    public void plusThreeMatchCount(int matchCount) {
        if (matchCount == 3) this.threeMatchCount++;
    }

    public int getFourMatchCount() {
        return fourMatchCount;
    }

    public void plusFourMatchCount(int matchCount) {
        if (matchCount == 4) this.fourMatchCount++;
    }

    public int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public void plusFiveMatchCount(int matchCount) {
        if (matchCount == 5) this.fourMatchCount++;
    }

    public int getSixMatchCount() {
        return sixMatchCount;
    }

    public void plusSixMatchCount(int matchCount) {
        if (matchCount == 5) this.sixMatchCount++;
    }

}
