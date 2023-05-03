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
        IntegerInput lottoPriceInput = new IntegerInput(new LottoPriceView());
        IntegerInput manualCountInput = new IntegerInput(new LottoManualCountView());

        int price = lottoPriceInput.getValue();
        Price totalPrice = new Price(price);

        int count = manualCountInput.getValue();
        Count manualCount = new Count(count);

        LottoInput manualLottosInput = new LottoInput(new LottoManualsView());
        Lottos manuals = Lottos.of(manualLottosInput.getValues(manualCount.value()));

        LottoGenerator generator = new LottoGenerator();
        Price autoPrice = totalPrice.minus(manuals.price());
        Count autolottoCount = Count.of(autoPrice);
        Lottos autos = generator.generate(autolottoCount);

        LottosDto manualDtos = LottosDto.from(manuals);
        LottosDto autoDtos = LottosDto.from(autos);
        Printable lottosOutput = new LottosOutput(manualDtos, autoDtos);
        lottosOutput.print();

        LottoInput lottoAnswer = new LottoInput(new LottoAnswerView());
        NumberInput lottoBonus = new NumberInput(new LottoBonusView());
        Lotto answer = lottoAnswer.getValue();
        Number bonus = lottoBonus.getValue();

        LottoPlaceCounter counter = new LottoPlaceCounter(answer, bonus);
        counter.countAll(manuals);
        counter.countAll(autos);

        LottoRewardStatistics statistics = new LottoRewardStatistics(counter);

        LottoStatisticsDto statisticsDto = new LottoStatisticsDto(statistics.profit(), LottoPlaceCounterDto.from(counter));
        Printable statisticsOutput = new LottoStatisticsOutput(statisticsDto);
        statisticsOutput.print();
    }
}
