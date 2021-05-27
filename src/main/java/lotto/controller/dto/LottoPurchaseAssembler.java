package lotto.controller.dto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPurchaseAssembler {

    public static LottoPurchaseResponse assemblePurchaseResponse(LottoTickets manualTickets, LottoTickets autoTickets) {
        List<LottoNumbersDto> lottoNumbersDtoList = new ArrayList<>();
        lottoNumbersDtoList.addAll(assembleLottoNumbersDtoList(manualTickets));
        lottoNumbersDtoList.addAll(assembleLottoNumbersDtoList(autoTickets));
        return new LottoPurchaseResponse(manualTickets.count(), autoTickets.count(), lottoNumbersDtoList);
    }

    private static List<LottoNumbersDto> assembleLottoNumbersDtoList(LottoTickets lottoTickets) {
        List<LottoNumbersDto> lottoNumbersDtoList = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoNumbersDtoList.add(new LottoNumbersDto(assembleLottoNumbers(lottoTicket)));
        }
        return lottoNumbersDtoList;
    }

    private static List<Integer> assembleLottoNumbers(LottoTicket lottoTicket) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoTicket.lottoNumbers()) {
            lottoNumbers.add(lottoNumber.number());
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
