package lotto;

import lotto.domain.LottoMachine;

import java.util.ArrayList;
import java.util.List;

public class LottoMatchingService {
    //todo: refactoring
    private long matchTimes;

    private int matchThreeTimes = 0;
    private int matchFourTimes = 0;
    private int matchFiveTimes = 0;
    private int matchSixTimes = 0;

    public List<Integer> matchWinningNumber(LottoMachine lottoMachine, List<Integer> winningNumbers) {
        // 로또를 입력한 갯수에 구입금액에 맞춰 만든다
        lottoMachine.makeLottos();
        // 당첨 번호와 로또들의 번호를 각각 비교한다
        for (int i = 0; i < lottoMachine.showNumberOfLottos(); i++) { // 로또 수만큼 순회
            matchTimes = lottoMachine.showLottoTicketNumbers(i).stream()
                    .filter(winningNumbers::contains)
                    .count();

            // 3개,4개,5개,6개 일치하는 갯수를 구한다
            if (matchTimes == 3) {
                matchThreeTimes++;
            }
            if (matchTimes == 4) {
                matchFourTimes++;
            }
            if (matchTimes == 5) {
                matchFiveTimes++;
            }
            if (matchTimes == 6) {
                matchSixTimes++;
            }
        }
        // 리스트에 그 갯수들을 넣는다
        List<Integer> matchTimesList = new ArrayList<>();
        matchTimesList.add(matchThreeTimes);
        matchTimesList.add(matchFourTimes);
        matchTimesList.add(matchFiveTimes);
        matchTimesList.add(matchSixTimes);
        return matchTimesList;
    }

}
