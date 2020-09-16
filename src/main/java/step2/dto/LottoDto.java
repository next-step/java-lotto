package step2.dto;

public class LottoDto {
    private int purchaseMoney;
    private String winningLottoNumber;

    public LottoDto(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public LottoDto(String winningLottoNumber) {
        this.winningLottoNumber = winningLottoNumber;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public String getWinningLottoNumber() {
        return winningLottoNumber;
    }
}
