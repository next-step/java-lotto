package lotto.domain;

import utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 테스트용 Maker */
public class LottoTicketOneSelectMaker implements LottoTicketMaker {
    private static final String DELIMITER = ",";

    private List<Integer> selectedNumber;

    public LottoTicketOneSelectMaker(String selectedLottoNumber) {
        this.selectedNumber = Arrays.stream(selectedLottoNumber.split(DELIMITER))
                .map(String::trim)
                .map(StringUtils::toNumber)
                .collect(Collectors.toList());
    }

    @Override
    public LottoTicket create() {
        List<LottoNumber> lottoNumbers = selectedNumber.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}
