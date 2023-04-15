package lotto.model;

import lotto.constant.LottoRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoTicketList {
    private List<LottoTicket> lottoTickets;

    public LottoTicketList(List<LottoTicket> lottoTicketList) {
        this.lottoTickets = lottoTicketList;
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    public Map<LottoRank, Integer> scratchLottoList(WinningInfo winningInfo) {
        Map<LottoRank, Integer> map = initLottoMap();

        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.getMatchCount(winningInfo.winningLottos);
            boolean bonusBall = lottoTicket.containsBonusBall(winningInfo.bonusNumber);
            LottoRank lottoRank = LottoRank.getRank(matchCount, bonusBall);
            map.put(lottoRank, map.get(lottoRank) + 1);
        }
        return map;
    }

    public Map<LottoRank, Integer> initLottoMap() {
        Map<LottoRank, Integer> map = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            map.put(lottoRank, 0);
        }
        return map;
    }
}
