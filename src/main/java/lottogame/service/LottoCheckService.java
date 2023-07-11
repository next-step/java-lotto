package lottogame.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.domain.LottoPrize;
import lottogame.domain.LottoResult;
import lottogame.domain.LottoTicket;

public class LottoCheckService {

    public List<LottoPrize> checkResult(List<LottoTicket> lottoTickets, Set<Integer> selectedLottoNumbers,
        int bonusLottoNumbers) {
        LottoResult lottoResult = new LottoResult(selectedLottoNumbers, bonusLottoNumbers);

        return lottoTickets.stream()
            .map(lottoResult::checkLottoTicket)
            .collect(Collectors.toList());
    }
}
