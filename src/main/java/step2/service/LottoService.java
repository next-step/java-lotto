package step2.service;

import step2.View.UI;
import step2.domain.Judge;
import step2.domain.Lotto;
import step2.domain.Shop;
import step2.dto.JudgeResponse;
import step2.dto.Money;
import step2.dto.ShopResponse;

public class LottoService {

    private final UI ui = new UI();
    private final Shop shop = new Shop();
    private final Judge judge = new Judge();

    public void autoLotto(){
        Money money = ui.getMoneyInput();
        int capacity = shop.calculateLottoCapacity(money);
        ShopResponse shopResponse = shop.buyLotto(money, capacity);
        ui.printLottoAmount(shopResponse);
        ui.printLottoNumbers(shopResponse);
        Lotto winningLotto = ui.getWinningNumbers();
        JudgeResponse judgeResponse = judge.calculateResult(shopResponse, winningLotto);
        ui.printResult(judgeResponse);
    }

}
