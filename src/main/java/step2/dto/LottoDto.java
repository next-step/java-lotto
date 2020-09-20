package step2.dto;

import java.util.List;

public class LottoDto {
    private int purchaseMoney;
    private String winningLottoNumber;
    private String bonusNumber;
    private List<String> nonAutoLottoNumberList;

    private LottoDto(Builder builder) {
        purchaseMoney = builder.purchaseMoney;
        winningLottoNumber = builder.winningLottoNumber;
        bonusNumber = builder.bonusNumber;
        nonAutoLottoNumberList = builder.nonAutoLottoNumberList;
    }

    public static class Builder {

        public List<String> nonAutoLottoNumberList;
        private int purchaseMoney;
        private String winningLottoNumber;
        private String bonusNumber;

        public Builder purchaseMoney(int val) {
            purchaseMoney = val;
            return this;
        }

        public Builder winningLottoNumber(String val) {
            winningLottoNumber = val;
            return this;
        }

        public Builder bonusNumber(String val) {
            bonusNumber = val;
            return this;
        }

        public Builder nonAutoLottoNumberList(List<String> val) {
            nonAutoLottoNumberList = val;
            return this;
        }

        public LottoDto build() {
            return new LottoDto(this);
        }
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public String getWinningLottoNumber() {
        return winningLottoNumber;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }

    public List<String> getNonAutoLottoNumberList() {
        return nonAutoLottoNumberList;
    }
}
