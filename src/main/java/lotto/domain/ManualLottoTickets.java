package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class ManualLottoTickets {
    private static final String MANUAL_LOTTO_NUMBER_DELIMITER = ",";

    private final List<LottoTicket> manualLottoTicket;

    public ManualLottoTickets(List<String> manualLottoTicket) {
        this.manualLottoTicket = createManualLottoTickets(manualLottoTicket);
    }

    public static List<LottoTicket> createManualLottoTickets(List<String> manualLottoNumbers) {
        List<LottoTicket> manualTickets = new ArrayList<>();

        for (String manualLottoNumber : manualLottoNumbers) {
            String[] lottoNumbers = manualLottoNumber.split(MANUAL_LOTTO_NUMBER_DELIMITER);
            Set<Integer> numbers = Arrays.stream(lottoNumbers)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
            manualTickets.add(LottoTicket.from(numbers));
        }

        return manualTickets;
    }

    public List<LottoTicket> fetchManualLottoTickets() {
        return Collections.unmodifiableList(manualLottoTicket);
    }
}
