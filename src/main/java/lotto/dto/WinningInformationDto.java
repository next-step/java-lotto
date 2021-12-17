package lotto.dto;

public class WinningInformationDto {
    private int numberOfMatching;
    private int prizeMoney;
    private int numberOfLotto;

    public WinningInformationDto(int numberOfMatching, int prizeMoney, int numberOfLotto) {
        this.numberOfMatching = numberOfMatching;
        this.prizeMoney = prizeMoney;
        this.numberOfLotto = numberOfLotto;
    }

    public int getNumberOfMatching() {
        return numberOfMatching;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }
}
