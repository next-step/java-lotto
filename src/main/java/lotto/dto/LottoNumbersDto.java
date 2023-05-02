package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersDto {

    List<List<Integer>> lottoNumbers;

    public LottoNumbersDto(List<List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    public static LottoNumbersDto of(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoNumbers();
        List<List<Integer>> result = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTicketList) {
            result.add(
                    lottoTicket.getLottoNumber().stream()
                            .map(LottoNumber::getNumber)
                            .collect(Collectors.toList())
            );
        }
        return new LottoNumbersDto(result);
    }
}
