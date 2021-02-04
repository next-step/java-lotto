package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoMatcher {

    private final Map<Prize,Integer> PrizeBoard = new EnumMap<>(Prize.class);
    // DONE: getMatCnt 를 원시타입 포장 클래스인 LottoNumber 와 호환되도록 변경해야 함.

    public LottoMatcher() {
        for (Prize prize : Prize.values()) {
            PrizeBoard.put(prize,0);
        }
    }
    public void checkAllTickets(LottoTickets lottoTickets, WinnerLotto winnerNumbers) {
        // 들어온 모든 티켓의 리스트에 대해 각 티켓별로 맞춘 수를 구하고 해당 수에 맞는
        // Prize 를 꼽는다. 해당 Prize 의 EnumMap의 count 를 1 증가시킨다.
        // 나중에 getPrizeBoard 를 통해 EnumMap 을 리턴하고 OutputView 를 통해 PrizeBoard 를 순회해
        // 3개: 50000원 ... 등을 출력할 수 있도록 한다

        List<Lotto> playersLottoTickets = lottoTickets.getLottoTickets();
        for (Lotto lotto : playersLottoTickets) {
            Prize prize = winnerNumbers.getPrizeForEachLotto(lotto.getNumbers());
            addPrizeStatus(prize);
        }
    }

    public Map<Prize, Integer> getPrizeBoard() {
        return PrizeBoard;
    }

    public void addPrizeStatus(Prize prize) {
        PrizeBoard.put(prize,PrizeBoard.get(prize)+1);
    }

}
