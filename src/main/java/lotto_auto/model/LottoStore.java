package lotto_auto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    public static LottoBundle sell(Order order) {
        List<LottoTicket> manualLottoTicket = prepareManualLotto(order);
        List<LottoTicket> autoLottoTicket = prepareAutoLotto(order);

        List<LottoTicket> allTicket = new ArrayList<>();
        allTicket.addAll(manualLottoTicket);
        allTicket.addAll(autoLottoTicket);
        return new LottoBundle(allTicket, autoLottoTicket.size(), manualLottoTicket.size());
    }

    private static List<LottoTicket> prepareManualLotto(Order order) {
        return order.getManualNumbers()
                .stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    private static List<LottoTicket> prepareAutoLotto(Order order) {
        return IntStream.range(0, order.getAuto())
                .boxed()
                .map(item -> new LottoTicket())
                .collect(Collectors.toList());
    }

}
