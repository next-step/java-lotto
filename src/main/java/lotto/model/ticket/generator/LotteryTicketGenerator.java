package lotto.model.ticket.generator;

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

    public static List<LotteryTicket> generateAutoLotteryTicket(int count) {
        List<LotteryTicket> list = new ArrayList<LotteryTicket>();
        for(int cnt = 0 ; cnt < count ; cnt++) {
            list.add(new LotteryTicket(chooseNumber()));
        }
        return list ;
    }

    public static List<LotteryTicket> generateManualLotteryTicket(int count) {
        List<LotteryTicket> list = new ArrayList<LotteryTicket>();
        for(int cnt = 0 ; cnt < count ; cnt++) {
            list.add(InputView.getTicket(""));
        }
        return list;
    }

    private static List<Lotto> chooseNumber() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(LottoNumber.CHOOSE_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}