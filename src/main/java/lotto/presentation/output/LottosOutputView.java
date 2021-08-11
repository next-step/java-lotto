package lotto.presentation.output;

import lotto.domain.LottoTicket;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class LottosOutputView {
    public void output(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().stream()
                .map(LottoTicket::getLottoNumbers)
                .map(this::toStrings)
                .map(this::toOutputFormat)
                .forEach(System.out::println);
    }

    private List<String> toStrings(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::getValue)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    private String toOutputFormat(List<String> elements) {
        return "[" + String.join(", ", elements) + "]";
    }
}
