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

    public static int getMatchCnt(List<LottoNumber> lottoNumber, WinnerLotto winnerNumbers) {
        return (int) lottoNumber.stream()
            .filter(number -> winnerNumbers.getNumbers().contains(number))
            .count();
    }

    public Map<Prize, Integer> getPrizeBoard() {
        return PrizeBoard;
    }

    public void addPrizeStatus(Prize prize) {
        PrizeBoard.put(prize,PrizeBoard.get(prize)+1);
    }

    public Prize getPrizeForEachLotto(int matchCount) {
        //TODO: 5개+보너스볼1개 인 경우의 분기 처리를 어떻게 할지 구현해야 함.
        for (Prize prize : Prize.values()) {
            if (prize.getMatchedNumber() == matchCount) {
                return prize;
            }
        }
        throw new IllegalArgumentException("해당 맞춘 수에 대한 상이 없습니다.");
    }
}
