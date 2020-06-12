package study.step4.domain;

import study.step4.dto.LottoInputDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int countLottoTickets(){
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }

    public static LottoTickets autoPublish(long autoLottoCounting) {
        return Stream.generate(LottoTicket::auto)
                     .limit(autoLottoCounting)
                     .collect(collectingAndThen(Collectors.toList(), LottoTickets::new));
    }

    public static LottoTickets manualPublish(LottoInputDto lottoInputDto) {
        return lottoInputDto.getInputNumbers()
                .stream()
                .map(LottoTicket::manual)
                .collect(collectingAndThen(toList(), LottoTickets::new));
    }


    public WinningRanks confirmWinningResult(WinningLotto lastWinningNumbers) {
        return checkLottoRank(lastWinningNumbers);
    }

    private WinningRanks checkLottoRank(WinningLotto lastWinningNumbers) {
        return lottoTickets.stream()
                           .map(lottoTicket -> lottoTicket.checkWinningRank(lastWinningNumbers))
                           .collect(collectingAndThen(toList(), WinningRanks::new));
    }

    public LottoTickets merge(LottoTickets manualLottos) {
        this.lottoTickets.addAll(manualLottos.lottoTickets);
        return this;
    }
}