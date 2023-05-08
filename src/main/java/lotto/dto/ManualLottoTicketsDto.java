package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoTicketsDto {

    private List<List<Integer>> lottoNumbers;
    private int manualCount;
    private int autoCount;

    private ManualLottoTicketsDto(List<List<Integer>> lottoNumbers, int manualCount, int autoCount) {
        this.lottoNumbers = lottoNumbers;
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public static ManualLottoTicketsDto from(LottoTickets lottoTickets, int manualCount, int autoCount) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoNumbers();
        List<List<Integer>> result = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTicketList) {
            result.add(
                    lottoTicket.getLottoNumber().stream()
                            .map(LottoNumber::getNumber)
                            .collect(Collectors.toList())
            );
        }
        return new ManualLottoTicketsDto(result, manualCount, autoCount);
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
