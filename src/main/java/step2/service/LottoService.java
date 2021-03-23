package step2.service;

import step2.domain.Judge;
import step2.domain.LottoMachine;
import step2.domain.MoneyMachine;
import step2.domain.Shop;
import step2.dto.JudgeResponseDTO;
import step2.dto.LottoDTO.WinningLottoDTO;
import step2.dto.MoneyDTO;
import step2.dto.ShopResponseDTO;

public class LottoService {

    private final Shop shop = new Shop();
    private final Judge judge = new Judge();

    private final LottoMachine lottoMachine = new LottoMachine();
    private final MoneyMachine moneyMachine = new MoneyMachine();

    public ShopResponseDTO buyManualLotto(int rawAmount) {
        MoneyDTO money = convertRawAmountToMoney(rawAmount);
        int capacity = shop.calculateLottoCapacity(money);
        return shop.buyLotto(money, capacity);
    }

    public JudgeResponseDTO getLottoResult(ShopResponseDTO shopResponse, String rawNumberString, int rawBonusNumber) {
        WinningLottoDTO winningLotto = convertRawNumberStringToLotto(rawNumberString, rawBonusNumber);
        return judge.calculateResult(shopResponse, winningLotto);
    }

    private MoneyDTO convertRawAmountToMoney(int rawAmount) {
        return moneyMachine.money(rawAmount);
    }

    private WinningLottoDTO convertRawNumberStringToLotto(String rawNumberString, int rawBonusNumber) {
        return lottoMachine.lotto(rawNumberString, rawBonusNumber);
    }
}
