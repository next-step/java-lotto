package step2.service;

import step2.domain.Judge;
import step2.domain.LottoGenerator;
import step2.domain.MoneyGenerator;
import step2.domain.Shop;
import step2.dto.JudgeResponseDTO;
import step2.dto.LottoDTO;
import step2.dto.MoneyDTO;
import step2.dto.ShopResponseDTO;

public class LottoService {

    private final Shop shop = new Shop();
    private final Judge judge = new Judge();

    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final MoneyGenerator moneyGenerator = new MoneyGenerator();

    public ShopResponseDTO buyManualLotto(int rawAmount) {
        MoneyDTO money = convertRawAmountToMoney(rawAmount);
        int capacity = shop.calculateLottoCapacity(money);
        return shop.buyLotto(money, capacity);
    }

    public JudgeResponseDTO getLottoResult(ShopResponseDTO shopResponse, String rawNumberString) {
        LottoDTO winningLotto = convertRawNumberStringToLotto(rawNumberString);
        return judge.calculateResult(shopResponse, winningLotto);
    }

    private MoneyDTO convertRawAmountToMoney(int rawAmount) {
        return moneyGenerator.generateMoney(rawAmount);
    }

    private LottoDTO convertRawNumberStringToLotto(String rawNumberString) {
        return lottoGenerator.generateLotto(rawNumberString);
    }
}
