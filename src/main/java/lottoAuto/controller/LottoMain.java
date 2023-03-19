package lottoAuto.controller;

import lottoAuto.domain.Level;
import lottoAuto.domain.Lotto;
import lottoAuto.domain.LottoNumber;
import lottoAuto.view.InputView;
import lottoAuto.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMain {
    private static final long LOTTO_AMOUNT = 1000;

    public void lottoAuto(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        // 구입금액 입력
        int purchaseAmount = inputView.InputPulchaseAmount();
        // 구매갯수 확인
        int purchaseCount = Long.valueOf(getPurchaseCount(purchaseAmount)).intValue();
        // 로또번호 자동생성 - 구매갯수만큼
        Lotto lotto = new Lotto(purchaseAmount, getLotto(purchaseCount));
        // 구매내역 출력
        resultView.purchaseHistory(purchaseCount, lotto);
        // 당첨번호 입력
        String winningNumber = inputView.InputWinningNumber();
        List<Integer> winningNumbers = winningNumbers(winningNumber);
        // 보너스볼 입력
        int bonusNumber = inputView.InputBonusNumber();
        // 당첨 확인
        lotto.confirmWinningNumber(winningNumbers, bonusNumber);
        // 당첨 통계 출력
        resultView.printToWinningStatistics(lotto);
    }

    private static long getPurchaseCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_AMOUNT;
    }

    private List<LottoNumber> getLotto(long purchaseCount) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) lottoNumbers.add(createLottoNumber());
        return lottoNumbers;
    }

    private LottoNumber createLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) numbers.add(i);
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);
        return new LottoNumber(lottoNumbers, Level.hitCount(0));
    }

    private static List<Integer> winningNumbers(String winningNumber) {
        return Arrays.stream(winningNumber.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
