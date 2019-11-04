package step2;

import step2.io.Input;
import step2.io.Output;
import step2.io.StandardInput;
import step2.io.StandardOutput;
import step2.shop.LottoShop;
import step2.shop.LottoShopFactory;
import step2.view.ManyAutoNumberLottoScenario;

public class Main {
    public static void main(String[] args) {
        final Input input = new StandardInput();
        final Output output = new StandardOutput();
        final LottoShop lottoShop = LottoShopFactory.alwaysSame(1, 2, 3, 4, 5, 6);
        final ManyAutoNumberLottoScenario scenario = new ManyAutoNumberLottoScenario(input, output, lottoShop);

        scenario.execute();
    }
}
