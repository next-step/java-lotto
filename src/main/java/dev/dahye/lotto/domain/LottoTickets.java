package dev.dahye.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private static final int MIN_COUNT = 0;

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets autoIssued(int countOfLotto) {
        validateCountOfLotto(countOfLotto);

        return new LottoTickets(createAutoIssued(countOfLotto));
    }

    private static void validateCountOfLotto(int countOfLotto) {
        if (countOfLotto <= MIN_COUNT) {
            throw new IllegalArgumentException("로또 티켓 생성 갯수가 유효하지 않습니다.");
        }
    }

    public static LottoTickets manualIssued(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public static LottoTickets multiIssued(int countOfLotto, List<LottoTicket> manualLottoTickets) {
        LottoTickets lottoTickets = LottoTickets.manualIssued(manualLottoTickets);

        int countOfAutoLotto = countOfLotto - manualLottoTickets.size();
        lottoTickets.addAll(createAutoIssued(countOfAutoLotto));

        return lottoTickets;
    }

    private static List<LottoTicket> createAutoIssued(int count) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoTickets.add(LottoTicket.autoIssued());
        }

        return lottoTickets;
    }

    private void addAll(List<LottoTicket> lottoTickets) {
        lottoTickets.addAll(lottoTickets);
    }

    public List<Rank> rankings(Winning winning) {
        List<Rank> ranks = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            ranks.add(winning.ranking(lottoTicket));
        }

        return ranks;
    }

    public int size() {
        return this.lottoTickets.size();
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
