package lotto.domain;

import lotto.resources.StringResources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int REQUIRED_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final String[] ticketNumbers){
        this.lottoNumbers = convertLottoNumbers(ticketNumbers);
        validateSize(lottoNumbers);
    }

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validateSize(lottoNumbers);
    }

    private void validateSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != REQUIRED_SIZE) {
            throw new RuntimeException(StringResources.LOTTO_NUMBER_AMOUNT_ERROR_MESSAGE);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    private List<LottoNumber> convertLottoNumbers(final String[] winningTicketNumbers){
        return Arrays
                .stream(winningTicketNumbers)
                .map(winningTicketNumber -> new LottoNumber(Integer.parseInt(winningTicketNumber.trim())))
                .collect(Collectors.toList());
    }
}