package lotto.controller.dto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbersAssembler {

    public static LottoTickets assemblePurchaseTickets(List<LottoNumbersDto> purchaseNumbers) {
        List<LottoTicket> lottoTicketList = assembleLottoNumbersList(purchaseNumbers)
                .stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
        return new LottoTickets(lottoTicketList);
    }

    public static List<LottoNumbers> assembleLottoNumbersList(List<LottoNumbersDto> lottoNumbersDtoList) {
        return lottoNumbersDtoList.stream()
                .map(LottoNumbersAssembler::assembleLottoNumbers)
                .collect(Collectors.toList());
    }

    public static LottoNumbers assembleLottoNumbers(LottoNumbersDto numbers) {
        validateLottoNumbers(numbers);
        Set<LottoNumber> lottoNumberList = numbers.getLottoNumbers().stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        return new LottoNumbers(lottoNumberList);
    }

    private static void validateLottoNumbers(LottoNumbersDto numbers) {
        int distinctCount = (int) numbers.getLottoNumbers().stream()
                .distinct()
                .count();
        if (distinctCount < numbers.getLottoNumbers().size()) {
            throw new IllegalArgumentException("당첨번호에 중복된 숫자가 존재합니다. 입력값을 확인해 주세요.");
        }
    }
}
