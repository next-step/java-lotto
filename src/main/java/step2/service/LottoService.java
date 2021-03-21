package step2.service;

import step2.domain.Judge;
import step2.domain.LottoGenerator;
import step2.domain.Shop;
import step2.dto.JudgeResponseDTO;
import step2.dto.LottoDTO;
import step2.dto.MoneyDTO;
import step2.dto.ShopResponseDTO;

public class LottoService {

    private final Shop shop = new Shop();
    private final Judge judge = new Judge();

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public ShopResponseDTO buyManualLotto(MoneyDTO money) {
        int capacity = shop.calculateLottoCapacity(money);
        return shop.buyLotto(money, capacity);
    }

    public JudgeResponseDTO getLottoResult(ShopResponseDTO shopResponse, LottoDTO winningLotto) {
        return judge.calculateResult(shopResponse, winningLotto);
    }

    public MoneyDTO convertRawAmountToMoney(int rawAmount) {
        return new MoneyDTO(rawAmount);
    }

    public LottoDTO convertRawNumberStringToLotto(String rawNumberString) {
        return lottoGenerator.generateLotto(rawNumberString);
    }
}
