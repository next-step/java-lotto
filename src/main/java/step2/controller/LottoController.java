package step2.controller;

import step2.domain.LottoMachine;
import step2.domain.Lottos;
import step2.dto.LottosDto;
import step2.view.LottoView;

public class LottoController {

    private final LottoView lottoView;
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoView = new LottoView();
        this.lottoMachine = new LottoMachine();
    }

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        Lottos lottos = lottoController.paymentMoney();
        lottoController.lottoInfoPirnt(lottos);
    }

    public void lottoInfoPirnt(Lottos lottos) {
        LottosDto lottosDto = createLottosDto(lottos);
        lottoView.lottoInfoPirnt(lottosDto);
    }

    public Lottos paymentMoney() {
        int money = lottoView.paymentMoney();
        return lottoMachine.createLotto(money);
    }

    public LottosDto createLottosDto(Lottos lotto) {
        return new LottosDto(lotto);
    }
}
