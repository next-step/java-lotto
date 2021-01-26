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

    private List<LottoTicket> getAutoLottoTicket(int ticketCount) {
        return Stream.generate(this::generateLottoTicket)
            .limit(ticketCount)
            .collect(Collectors.toList());
    }

    public List<LottoTicket> buyLottoTicket(int money, List<String> inputManualLottoTicketNumber) {
        int ticketCount = LottoTicket.countPurchasable(money);
        validateManualLottoCount(inputManualLottoTicketNumber, ticketCount);
        int autoTicketCount = calculateAutoLottoTicket(ticketCount, inputManualLottoTicketNumber.size());
        List<LottoTicket> manualLottoTicket = getManualLottoTicket(inputManualLottoTicketNumber);
        List<LottoTicket> autoLottoTicket = getAutoLottoTicket(autoTicketCount);
        return Stream.concat(manualLottoTicket.stream(), autoLottoTicket.stream()).collect(Collectors.toList());
    }

    private List<LottoTicket> getManualLottoTicket(List<String> inputManualLottoTicketNumber) {
        return inputManualLottoTicketNumber.stream()
            .map(manualLottoNumberString -> Arrays.stream(manualLottoNumberString.split(","))
                .map(manualLottoNumber -> {
                    try {
                        return new LottoNumber(manualLottoNumber.trim());
                    } catch (NumberFormatException exception) {
                        throw new IllegalArgumentException("로또 수동 입력값으로 숫자가 아닌 값이 입력되었습니다.");
                    }
                })
                .collect(Collectors.toList()))
            .map(LottoTicket::new)
            .collect(Collectors.toList());
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
