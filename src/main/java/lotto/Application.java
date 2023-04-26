package lotto;

import lotto.control.input.LottoAnswerInput;
import lotto.control.input.LottoBonusInput;
import lotto.control.input.LottoPriceInput;
import lotto.control.output.LottoStatisticsOutput;
import lotto.control.output.LottosOutput;
import lotto.control.output.Printable;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoPlaceCounter;
import lotto.model.LottoRewardStatistics;
import lotto.model.dto.LottoDto;
import lotto.model.dto.LottoPlaceCounterDto;
import lotto.model.dto.LottoStatisticsDto;
import lotto.view.input.LottoAnswerView;
import lotto.view.input.LottoBonusView;
import lotto.view.input.LottoPriceView;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Application {

    public static void main(String[] args) {
        LottoPriceInput lottoPrice = new LottoPriceInput(new LottoPriceView());
        LottoAnswerInput lottoAnswer = new LottoAnswerInput(new LottoAnswerView());
        LottoBonusInput lottoBonus = new LottoBonusInput(new LottoBonusView());

        int price = lottoPrice.getValue();

        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = generator.generate(price);

        List<LottoDto> lottoDtos = lottos.stream()
                .map(LottoDto::from)
                .collect(toList());

        Printable lottosOutput = new LottosOutput(lottoDtos);
        lottosOutput.print();

        Number bonus = lottoBonus.getValue();

        Lotto answer = lottoAnswer.getValue();

        LottoPlaceCounter counter = new LottoPlaceCounter(answer);
        counter.countAll(lottos);

        LottoRewardStatistics statistics = new LottoRewardStatistics(counter);

        LottoStatisticsDto statisticsDto = new LottoStatisticsDto(statistics.profit(), LottoPlaceCounterDto.from(counter));
        Printable statisticsOutput = new LottoStatisticsOutput(statisticsDto);
        statisticsOutput.print();
    }
}
