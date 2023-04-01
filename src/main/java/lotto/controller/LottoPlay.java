package lotto.controller;

import lotto.domain.TotalEqualNumbers;
import lotto.domain.BuyLotto;
import lotto.domain.Lotto;
import lotto.domain.WinOfLotto;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.*;

public class LottoPlay {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        LottoOutput lottoOutput = new LottoOutput();

        BuyLotto buyLotto = lottoInput.getBuyInfo();    // 구입금액 입력
        lottoInput.getPassiveNumbers(buyLotto);         // 수동으로 번호 입력
        lottoOutput.displayCount(buyLotto);             // 수동, 자동 개수 출력

        // 나머지 금액 자동으로 번호 생성
        for (int i = 0; i < buyLotto.getCount().getCount() - buyLotto.getPassiveCount().getCount(); i++) {
            Set<Integer> generateNumbers = generateLottoNumbers();
            buyLotto.putLottos(new Lotto(generateNumbers));
        }

        lottoOutput.displayBuyLottoNumbers(buyLotto);               // 구매한 번호들 일괄 출력

        WinOfLotto winOfLotto = lottoInput.getWinOfLottoNumbers();  // 지난 주 당첨 번호 입력

        new TotalEqualNumbers(buyLotto, winOfLotto);                // 당첨 번호와 구매한 번호들 비교

        lottoOutput.displayWinOfResult();                           // 당첨 결과 출력
        lottoOutput.displayPriceEarningsRatio(buyLotto);            // 수익률 출력
    }

    private static Set<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 6);

        return new HashSet<>(numbers);
    }
}
