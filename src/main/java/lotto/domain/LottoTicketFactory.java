package lotto.domain;

public class LottoTicketFactory {

    private LottoTicketFactory() {
    }

    public static CreatableLottoNumber autoLotto() {
        return new AutoLottoNumber();
    }

    public static CreatableLottoNumber manualLotto(String manualLottoNumber) {
        return new ManualLottoNumber(manualLottoNumber);
    }

}
