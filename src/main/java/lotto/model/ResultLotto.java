package lotto.model;

public class ResultLotto {

    private int firstCount;

    private int secondCount;

    private int thirdCount;

    private int fourthCount;

    private int fifthCount;

    public ResultLotto() {
        this.firstCount = 0;
        this.secondCount = 0;
        this.thirdCount = 0;
        this.fourthCount = 0;
        this.fifthCount = 0;
    }

    public void addFirst() {
        firstCount += 1;
    }

    public void addSecond() {
        firstCount += 1;
    }

    public void addThird() {
        firstCount += 1;
    }

    public void addFourth() {
        firstCount += 1;
    }

    public void addFifth() {
        firstCount += 1;
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

    public int getFifthCount() {
        return fifthCount;
    }
}
