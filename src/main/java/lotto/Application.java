package lotto;

import lotto.control.input.LottoAnswerInput;
import lotto.control.input.LottoPriceInput;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        LottoPriceInput lottoPrice = new LottoPriceInput(new LottoPriceView());
        LottoAnswerInput lottoAnswer = new LottoAnswerInput(new LottoAnswerView());

        int price = lottoPrice.getValue();
        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = generator.generate(price);

        Printable lottosOutput = new LottosOutput(lottos);
        lottosOutput.print();
    }
}
