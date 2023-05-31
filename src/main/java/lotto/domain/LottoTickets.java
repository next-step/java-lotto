package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(LottoBuyCount lottoBuyCount) {
        lottoTickets = new ArrayList<>();
        for(int i=0; i < lottoBuyCount.getLottoBuyCount(); i++) {
            lottoTickets.add(new LottoTicket());
        }
    }

    // 테스트용 생성자
    public LottoTickets(String lottoTicketsString) {
        String[] split = lottoTicketsString.split("\n");

        lottoTickets = new ArrayList<>();
        for (String s : split) {
            lottoTickets.add(new LottoTicket(s));
        }
    }

    public Map<Integer, Integer> calculateLottoWinStatistics(LottoWinNumber lottoWinNumber) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            int idx = lottoTicket.getMatchCount(lottoWinNumber);
            resultMap.put(idx, resultMap.getOrDefault(idx, 0) + 1);
        }

        return resultMap;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (LottoTicket lottoTicket : lottoTickets) {
            result.append(lottoTicket.toString()).append("\n");
        }

        return result.toString();
    }
}
