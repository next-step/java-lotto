package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.ui.LottoHitInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LottoTicketList {

    private final List<LottoTicket> lottoTickets;

    private LottoTicketList(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTicketList createAutoLottoTicketList(int numberOfLotto) {
        List<LottoTicket> ticketList = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            ticketList.add(LottoTicket.createAutoLotto());
        }

        return new LottoTicketList(ticketList);
    }

    public static LottoTicketList createManualLottoTicketList(final List<String> manualLottoNumbers) {
       List<LottoTicket> manualLottoTickets = new ArrayList<>();

        for (String number : manualLottoNumbers) {
           List<LottoNumber> lottoNumbers = Arrays.stream(number.split(","))
                   .map(Integer::parseInt)
                   .distinct()
                   .map(LottoNumber::new)
                   .collect(Collectors.toList());

           manualLottoTickets.add(LottoTicket.createManualLotto(lottoNumbers));
       }

        return new LottoTicketList(manualLottoTickets);
    }

    public void addLottoTicketList(LottoTicketList lottoTicketList) {
        List<LottoTicket> tickets = lottoTicketList.getLottoTickets();
        this.lottoTickets.addAll(tickets);
    }

    public Map<LottoRank, Integer> findRanks(final LottoHitInfo hitInfo) {
        Map<LottoRank, Integer> ranks = new HashMap<>();

        lottoTickets.forEach(ticket -> {
            LottoRank rank = ticket.getHitCount(hitInfo);
            checkNull(ranks, rank);
        });

        return ranks;
    }

    private void checkNull(Map<LottoRank, Integer> ranks, LottoRank rank) {
        if (rank != null) {
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    public BigDecimal calculateBuyingPrice() {
        return new BigDecimal(this.size() * LottoStore.LOTTO_PRICE);
    }
}
