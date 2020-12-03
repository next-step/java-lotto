package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Scanner {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public Scanner(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        ;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호 6개를 입력해주세요 :)");
        }
    }

    private void scan(LottoTicket lottoTicket, LottoResult lottoResult) {
        long matchingScore = lottoTicket.getLottoNumbers()
                .stream()
                .filter(n -> toIntegerList(winningNumbers)
                        .contains(n.toInt()))
                .count();

        final boolean matchBonus = lottoTicket.getLottoNumbers()
                .stream()
                .anyMatch(n -> n.toInt() == bonusNumber.toInt());


        lottoResult.saveLottoResult(Long.valueOf(matchingScore).intValue(), matchBonus);
    }

    public LottoResult scanAll(List<LottoTicket> lottoTickets) {
        LottoResult lottoResult = new LottoResult(lottoTickets.size());
        lottoTickets.forEach(lottoTicket -> scan(lottoTicket, lottoResult));
        return lottoResult;
    }

    private List<Integer> toIntegerList(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(n -> n.toInt())
                .collect(Collectors.toList());
    }
}
