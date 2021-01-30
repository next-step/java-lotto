package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
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

        List<PlayersLotto> playersLottoTickets = lottoTickets.getLottoTickets();
        for (PlayersLotto lotto : playersLottoTickets) {
            Prize prize = getPrizeForEachLotto(lotto.getNumbers(), winnerNumbers);
            addPrizeStatus(prize);
        }
    }

    public static int getMatchCnt(List<LottoNumber> lottoNumber, WinnerLotto winnerNumbers) {
        // DONE: 5개 적중 시 보너스 볼을 추가 검증해서 적중수가 5+1지(보너스볼)인지, 6인지를 구분짓는 로직이 필요함.
        // 여기에서는 갯수만 카운팅 하고 보너스 볼에 대한 로직은 getPrizeForEachLotto 에서 검증하는 것이 맞는것 같아 수정해 보았습니다.
        int matchCnt = (int) lottoNumber.stream()
            .filter(number -> winnerNumbers.getNumbers().contains(number))
            .count();
        return matchCnt;
    }

    public Map<Prize, Integer> getPrizeBoard() {
        return PrizeBoard;
    }

    public void addPrizeStatus(Prize prize) {
        PrizeBoard.put(prize,PrizeBoard.get(prize)+1);
    }

    public Prize getPrizeForEachLotto(List<LottoNumber> lottoNumber, WinnerLotto winnerNumbers) {
        int matchCnt = getMatchCnt(lottoNumber, winnerNumbers);
        Prize returnPrize = Arrays.stream(Prize.values()).filter(prize -> prize.getMatchedNumber() == matchCnt).findAny().get();
        // DONE : 5개+보너스볼1개 인 경우의 분기 처리 구현
        if(matchCnt == 5 && lottoNumber.stream().anyMatch(num -> num.getLottoNumber() == winnerNumbers.getBonusBall().getLottoNumber())) {
            returnPrize = Prize.FIVE_WITH_BONUS;
        }
        return returnPrize;
    }
}
