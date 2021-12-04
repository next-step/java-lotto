package step2.dto;

public class WinningInformation {
    public int numberOfMatches;
    public int winningPrize;
    public int numberOfLotto;
    public WinningInformation(int numberOfMatches,int winningPrize,int numberOfLotto ){
        this.numberOfMatches = numberOfMatches;
        this.winningPrize = winningPrize;
        this.numberOfLotto = numberOfLotto;
    }
}
