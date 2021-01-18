package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 46;

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoGenerator() {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            this.lottoNumbers.add(new LottoNumber(i));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public LottoTicket generateLottoTicket() {
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(0, LottoTicket.Lotto_NUMBER_COUNT));
    }

    private Stream<LottoTicket> getAutoLottoTicket(int ticketCount) {
        return Stream.generate(this::generateLottoTicket)
            .limit(ticketCount);
    }

    public List<LottoTicket> buyLottoTicket(int money, List<String> inputManualLottoTicketNumber) {
        int ticketCount = LottoTicket.countPurchasable(money);
        validateManualLottoCount(inputManualLottoTicketNumber, ticketCount);
        int autoTicketCount = calculateAutoLottoTicket(ticketCount, inputManualLottoTicketNumber.size());
        Stream<LottoTicket> list = getManualLottoTicket(inputManualLottoTicketNumber);
        Stream<LottoTicket> autoLottoTicket = getAutoLottoTicket(autoTicketCount);
        return Stream.concat(list, autoLottoTicket).collect(Collectors.toList());
    }

    private Stream<LottoTicket> getManualLottoTicket(List<String> inputManualLottoTicketNumber) {
        return generateManualLottoTicket(inputManualLottoTicketNumber);
    }

    private Stream<LottoTicket> generateManualLottoTicket(List<String> inputManualLottoTicketNumber) {
        return inputManualLottoTicketNumber.stream()
            .map(s -> Arrays.stream(s.split(","))
                .map(s1 -> new LottoNumber(s1.trim()))
                .collect(Collectors.toList()))
            .map(LottoTicket::new);
    }

    private int calculateAutoLottoTicket(int ticketCount, int size) {
        return ticketCount - size;
    }

    private void validateManualLottoCount(List<String> inputManualLottoTicketNumber, int ticketCount) {
        if (ticketCount < inputManualLottoTicketNumber.size()) {
            throw new IllegalArgumentException("지불하신 금액으로는 입력하신 개수만큼 구매할 수 없습니다.");
        }
    }

}
