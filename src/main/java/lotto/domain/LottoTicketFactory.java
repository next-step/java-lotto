package lotto.domain;

public class LottoTicketFactory {

    public static CreatableLottoNumber LottoTicketFactory() {
        return new AutoLottoNumber();
    }

    public static CreatableLottoNumber LottoTicketFactory(String manualLottoNumber) {
        return new ManualLottoNumber(manualLottoNumber);
    }

}
