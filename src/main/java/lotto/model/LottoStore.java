package lotto.model;

import lotto.AutomaticLottoGenerator;
import lotto.model.wrapper.Payment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    private LottoStore() {
    }

    public static LottoTickets sell(final Payment payment, final LottoTickets manualLottoTickets) {
        int automaticLottoCount = countAutomaticLottoTickets(payment.countLottoTicket() - manualLottoTickets.size());

        List<LottoTicket> lottoTickets = IntStream.range(0, automaticLottoCount)
                .mapToObj(i -> LottoTicket.newInstance(new AutomaticLottoGenerator()))
                .collect(Collectors.toList());

        return manualLottoTickets.merge(lottoTickets);
    }

    private static int countAutomaticLottoTickets(final int extraPayment) {
        if (extraPayment < 0) {
            throw new IllegalArgumentException("입력 받은 수동 로또들을 전부 구입하기엔 돈이 모자릅니다.");
        }
        return extraPayment;
    }
}
