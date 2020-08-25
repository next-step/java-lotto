package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.CommonConstant.NUMBER_ZERO;

public class LottoStore {

    public static final boolean PURCHASING_METHOD_AUTOMATICS = true;
    public static final boolean PURCHASING_METHOD_MANUAL = false;

    private List<LottoTicket> lottoTickets;

    public LottoStore(List<Integer> manualLottoNumbers, int lottoTicketQuantity) {
        this.lottoTickets = new ArrayList<>();
        this.lottoTickets = createManualLottoTicket(manualLottoNumbers, lottoTicketQuantity);
    }

    public LottoStore(int lottoTicketQuantity, List<Integer> lottoAllNumbers) {
        this.lottoTickets = new ArrayList<>();
        this.lottoTickets = createAutomaticLottoTicket(lottoAllNumbers, lottoTicketQuantity);
    }

    private List<LottoTicket> createAutomaticLottoTicket(List<Integer> lottoAllNumbers, int lottoTicketQuantity) {
        createLottoTicket(lottoAllNumbers, lottoTicketQuantity,PURCHASING_METHOD_AUTOMATICS);
        return lottoTickets;
    }

    private List<LottoTicket> createManualLottoTicket(List<Integer> manualLottoNumbers, int lottoTicketQuantity) {
        createLottoTicket(manualLottoNumbers, lottoTicketQuantity, PURCHASING_METHOD_MANUAL);
        return lottoTickets;
    }

    private boolean createLottoTicket(List<Integer> lottoNumbers, int lottoTicketQuantity, boolean purchasingMethod) {
        return lottoTickets.addAll(IntStream.range(NUMBER_ZERO, lottoTicketQuantity)
                .boxed()
                .map(lottoTicket -> new LottoTicket(howToBuyLotto(purchasingMethod, lottoNumbers)))
                .collect(Collectors.toList()));
    }

    private List<Integer> howToBuyLotto(boolean automatics, List<Integer> lottoNumbers) {
        return (automatics) ? LottoNumberGenerator.getAutoLottoNumber(lottoNumbers) : lottoNumbers;
    }

    public LottoTicket getLottoTicket(int index) {
        return lottoTickets.get(index);
    }

    public int size() {
        return lottoTickets.size();
    }

}
