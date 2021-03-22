package step2.dto;

public class ShopResponseDTO {

    private final int originMoney;
    private final int lottoCount;
    private final LottoListDTO lottoList;
    private final int change;

    public ShopResponseDTO(int originMoney, int lottoCount, LottoListDTO lottos, int change) {
        this.originMoney = originMoney;
        this.lottoCount = lottoCount;
        this.lottoList = lottos;
        this.change = change;
    }

    public int getChange() {
        return change;
    }

    public int getOriginMoney() {
        return originMoney;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public LottoListDTO getLottoList() {
        return lottoList;
    }
}
