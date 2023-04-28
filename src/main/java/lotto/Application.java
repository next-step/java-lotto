package lotto;

import lotto.control.input.IntegerInput;
import lotto.control.input.LottoInput;
import lotto.control.input.NumberInput;
import lotto.control.output.LottoStatisticsOutput;
import lotto.control.output.LottosOutput;
import lotto.control.output.Printable;
import lotto.model.Number;
import lotto.model.*;
import lotto.model.dto.LottoPlaceCounterDto;
import lotto.model.dto.LottoStatisticsDto;
import lotto.model.dto.LottosDto;
import lotto.view.input.*;

public class Application {

    public static void main(String[] args) {
        IntegerInput lottoPrice = new IntegerInput(new LottoPriceView());
        IntegerInput manualCount = new IntegerInput(new LottoManualCountView());

        int price = lottoPrice.getValue();
        int count = manualCount.getValue();

        LottoInput manualLottos = new LottoInput(new LottoManualsView());
        Lottos manuals = Lottos.of(manualLottos.getValues(count));

        LottoGenerator generator = new LottoGenerator();
        Lottos autos = generator.generate(price - manuals.price());

        Printable lottosOutput = new LottosOutput(lottoDtos);
        lottosOutput.print();

        LottoInput lottoAnswer = new LottoInput(new LottoAnswerView());
        NumberInput lottoBonus = new NumberInput(new LottoBonusView());
        Lotto answer = lottoAnswer.getValue();
        Number bonus = lottoBonus.getValue();

        LottoPlaceCounter counter = new LottoPlaceCounter(answer, bonus);
        counter.countAll(lottos);

        LottoRewardStatistics statistics = new LottoRewardStatistics(counter);

        LottoStatisticsDto statisticsDto = new LottoStatisticsDto(statistics.profit(), LottoPlaceCounterDto.from(counter));
        Printable statisticsOutput = new LottoStatisticsOutput(statisticsDto);
        statisticsOutput.print();
    }
}
