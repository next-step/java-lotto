package lotto.model.ticket.generator;

import lotto.model.domain.CountInfo;
import lotto.model.domain.Lotto;
import lotto.model.game.LottoNumber;
import lotto.model.ticket.LotteryTicket;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryTicketGenerator {

    private static final List<Lotto> numbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER,LottoNumber.MAX_NUMBER)
            .boxed().map(Lotto::new)
            .collect(Collectors.toList());

    public static List<LotteryTicket> generate(CountInfo countInfo) {
        List<LotteryTicket> list = new ArrayList<LotteryTicket>();
        for(int idx = 0 ; idx < countInfo.getTotalCount() ; idx++) {
            list.add(newLotteryTicket(countInfo.isManualIdx(idx)));
        }
        return list ;
    }

    private static LotteryTicket newLotteryTicket(boolean isManualIndex) {
        if (isManualIndex) {
            return InputView.getTicket("");
        }
        return new LotteryTicket(chooseNumber());
    }

    private static List<Lotto> chooseNumber() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(LottoNumber.CHOOSE_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}