package lottery.domain;

import lottery.code.WinPrizeType;
import lottery.domain.vo.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets(Long lottoTicketCount) {
        this(quickPickDispense(lottoTicketCount));
    }
    public LottoTickets(Integer moneyAmount) {
        this(lottoTicketCount(moneyAmount));
    }

    public Map<WinPrizeType, Long> winStatistics(WinningLotto winningLotto) {
        return this.lottoTickets.stream()
                .collect(Collectors.groupingBy(
                        lottoTicket -> WinPrizeType.fromMatchCountWithBonusMatch(
                                lottoTicket.matchNumbersCount(winningLotto.winningNumbers()),
                                lottoTicket.matchNumber(winningLotto.bonusNumbers())),
                        Collectors.counting()));
    }

    public Long lottoTicketCount(){
        return Long.valueOf(this.lottoTickets.size());
    }

    public List<LottoTicket> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public Integer lottoTicketsTotalPrice(){
        return this.lottoTickets.size() * LottoTicket.PRICE;
    }

    public Integer lottoTicketsTotalPrize(Map<WinPrizeType, Long> matchStatistics){
        return matchStatistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().prize() * entry.getValue().intValue())
                .sum();
    }

    private static Long lottoTicketCount(Integer inputMoney){
        validateMoney(inputMoney);
        return Long.valueOf(inputMoney / LottoTicket.PRICE);
    }

    private static void validateMoney(Integer inputMoney){
        if (Objects.isNull(inputMoney))
            throw new IllegalArgumentException("구입 금액은 필수 입니다.");
        if (inputMoney % LottoTicket.PRICE != 0)
            throw new IllegalArgumentException("구입 금액은 1000 단위 입니다.");
    }

    private static List<LottoTicket> quickPickDispense(Long lottoTicketCount) {
        return LongStream.range(0, lottoTicketCount)
                .mapToObj(count -> new LottoTicket())
                .collect(Collectors.toUnmodifiableList());
    }
}
