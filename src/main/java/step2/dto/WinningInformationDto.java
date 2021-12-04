package step2.dto;

public class WinningInformationDto {
    public int numberOfMatching;
    public int prizeMoney;
    public int numberOfLotto;

    public WinningInformationDto(int numberOfMatching, int prizeMoney, int numberOfLotto) {
        this.numberOfMatching = numberOfMatching;
        this.prizeMoney = prizeMoney;
        this.numberOfLotto = numberOfLotto;
    }
}
