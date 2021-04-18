package lotto.dto;

public class InfoDto {
    int correctNum;
    int winningPrice;
    int lottoNumWithCorrectNum;

    public InfoDto(int correctNum, int winningPrice, int lottoNumWithCorrectNum) {
        this.correctNum = correctNum;
        this.winningPrice = winningPrice;
        this.lottoNumWithCorrectNum = lottoNumWithCorrectNum;
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getLottoNumWithCorrectNum() {
        return lottoNumWithCorrectNum;
    }
}