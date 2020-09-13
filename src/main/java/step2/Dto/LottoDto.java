package step2.Dto;

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

    public void setPurchaseMoney(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public String getWinningLottoNumber() {
        return winningLottoNumber;
    }

    public void setWinningLottoNumber(String winningLottoNumber) {
        this.winningLottoNumber = winningLottoNumber;
    }
}
