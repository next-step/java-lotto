package lotto.domain;

import lotto.pattern.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGroup {
    private static final int LOTTO_TICKET_PRICE = 1000;

    private final List<LottoTicket> lottoTicketGroup;

    public LottoTicketGroup(int money, NumberGenerator numberGenerator) {
        this(generateLottoTicketGroup(getTicketCount(money), numberGenerator));
    }

    public LottoTicketGroup(List<LottoTicket> lottoTickets) {
        this.lottoTicketGroup = lottoTickets;
    }

    private static int getTicketCount(int money) {
        validatePays(money);
        return money / LOTTO_TICKET_PRICE;
    }

    private static void validatePays(int money) {
        if (money < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("1000원 이하로는 로또를 구매할 수 없습니다.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }

    private static List<LottoTicket> generateLottoTicketGroup(int ticketCount, NumberGenerator numberGenerator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new LottoTicket(numberGenerator.generateLottoNumbers()));
        }

        return lottoTickets;
    }

    public List<LottoTicket> getTickets() {
        return this.lottoTicketGroup;
    }

    public RankGroup getLottoRankings(LottoTicket winningLotto) {
        List<Rank> myRanks = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTicketGroup) {
            myRanks.add(Rank.of(lottoTicket.getMatchResult(winningLotto)));
        }
        return new RankGroup(myRanks);
    }
}