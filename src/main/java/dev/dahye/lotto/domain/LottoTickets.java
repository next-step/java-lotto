package dev.dahye.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private static final int MIN_COUNT = 0;

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        isNotNullOrEmpty(lottoTickets);

        this.lottoTickets = lottoTickets;
    }

    private void isNotNullOrEmpty(List<LottoTicket> lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("LottoTickets는 null이거나 빈 값으로는 생성할 수 없습니다.");
        }
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

    public static LottoTickets multiIssued(int countOfAutoLotto, List<LottoTicket> manualLottoTickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(manualLottoTickets);
        lottoTickets.addAll(createAutoIssued(countOfAutoLotto));

        return LottoTickets.manualIssued(lottoTickets);
    }

    private static List<LottoTicket> createAutoIssued(int count) {
        return Stream.generate(LottoTicket::autoIssued)
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Rank> rankings(Winning winning) {
        return lottoTickets.stream()
                .map(winning::ranking)
                .collect(Collectors.toList());
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
