package lotto.dto;

import lotto.domain.rating.WinningRatingType;

public class WinningStatDto {
    private int firstCount;
    private int secondCount;
    private int thirdCount;
    private int fourthCount;

    public WinningStatDto(int firstCount, int secondCount, int thirdCount, int fourthCount) {
        this.firstCount = firstCount;
        this.secondCount = secondCount;
        this.thirdCount = thirdCount;
        this.fourthCount = fourthCount;
    }

    /**
     * dto 이기 때문에 도메인에 종속적인 관계를 만들어도 괜찮지 않을까..
     */
    public void includeStatCount(WinningRatingType type) {
        if (WinningRatingType.FIRST == type) {
            this.firstCount++;
        } else if (WinningRatingType.SECOND == type) {
            this.secondCount++;
        } else if (WinningRatingType.THIRD == type) {
            this.thirdCount++;
        } else if (WinningRatingType.FOURTH == type) {
            this.fourthCount++;
        }
    }

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }
}
