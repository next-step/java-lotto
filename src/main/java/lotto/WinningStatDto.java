package lotto;

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

    public void plusFirst() {
        this.firstCount++;
    }

    public void plusSecond() {
        this.secondCount++;
    }

    public void plusThird() {
        this.thirdCount++;
    }

    public void plusFourth() {
        this.fourthCount++;
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
