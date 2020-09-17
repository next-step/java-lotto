package step3.controller;

import step3.util.Cast;
import step3.domain.LottoTicket;
import java.util.ArrayList;
import java.util.List;

public class FindMatchNumber {
    public static int[] result = {0, 0, 0, 0};
    private static List<Rank> ranks = new ArrayList<>();

    public static List<Rank> find(List<LottoTicket> lottoTicketList, String numbers, Long bonusNo) {
        Long[] winningNumber = Cast.castToNumber(numbers);
        for(int i = 0; i < lottoTicketList.size(); i++) {
            List<Long> lotto = lottoTicketList.get(i).getLottoNumbers();
            int count = makeMatchCount(winningNumber, lotto);
            rankList(lotto, count, bonusNo);
        }
        return ranks;
    }

    public static int makeMatchCount(Long[] winningNumber, List<Long> lotto) {
        int count = 0;
        for(int j = 0; j < winningNumber.length; j++) {
            count = lotto.contains(winningNumber[j]) ? count + 1 : count;
        }
        return count;
    }

    public static void rankList(List<Long> lotto,int count, Long bonusNo){
        if(count == 5 && lotto.contains(bonusNo)) {
            ranks.add(Rank.valueOf(count , lotto.contains(bonusNo)));
        }
        if(count >= 3) {
            ranks.add(Rank.valueOf(count, lotto.contains(bonusNo)));
        }
        if(count < 3) {
            ranks.add(Rank.valueOf(0, lotto.contains(bonusNo)));
        }
    }
}
