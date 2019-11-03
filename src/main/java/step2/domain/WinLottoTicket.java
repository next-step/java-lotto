package step2.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinLottoTicket {
    private List<LottoNumber> winNumbers;

    public WinLottoTicket(List<Integer> winNumbers) {
        this.winNumbers = makeWinNumbers(winNumbers);
    }


    private List<LottoNumber> makeWinNumbers(List<Integer> winNumbers) {
        return winNumbers.stream()
                .map(LottoNumber::new)
                .collect(toList());
    }

    public int getMatchAmount(LottoTicket lottoTicket) {
        return (int) lottoTicket.getNumbers().stream()
                .filter(this::isMatch)
                .count();
    }

    private boolean isMatch(LottoNumber lottoNumber) {
        return winNumbers.stream()
                .anyMatch(winNumber -> winNumber.equals(lottoNumber));
    }
}
