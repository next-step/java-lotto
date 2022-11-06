package lotto.backend.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class WinningLotto {

    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        checkBonusNumber(winningLottoTicket, bonusNumber);
        this.winningLottoTicket = winningLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> mainWinningNumbers, int bonusNumber) {
        return new WinningLotto(LottoTicket.create(mainWinningNumbers), new LottoNumber(bonusNumber));
    }

    private void checkBonusNumber(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        if (winningLottoTicket.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 로또번호와 중복될 수 없습니다");
        }
    }

    public Map<LottoRank, Integer> analysis(LottoTickets lottoTickets) {
        return lottoTickets.getValues().stream()
                .map(this::getRank)
                .collect(groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)));
    }

    private LottoRank getRank(LottoTicket lottoTicket) {
        int countOfMatch = lottoTicket.countOfMatch(winningLottoTicket);
        boolean hasBonus = lottoTicket.hasNumber(bonusNumber);
        return LottoRank.valueOf(new Matching(countOfMatch, hasBonus));
    }
}
