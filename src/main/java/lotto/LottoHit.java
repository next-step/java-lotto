package lotto;

import lotto.model.Level;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LottoHit {
    private static final long UNITAMOUNT = 1000;

    public static void main(String[] args) {
        LottoFunction();
    }

    public static long LottoFunction()
    {
        InputView  inputView  = new InputView();
        ResultView resultView = new ResultView();
        LottoHit lottoHit     = new LottoHit();


        long purchaseAmount = inputView.PurchaseAmount();

        Lotto lotto = new Lotto(purchaseAmount,  lottoHit.getLotto(lottoHit.getPurchaseCount(purchaseAmount)));

        resultView.PurchaseHistory(lottoHit.getPurchaseCount(purchaseAmount), lotto);

        String stringWinningNumbers = inputView.InputWinningNumber();
        List<Integer> winningNumbers = lottoHit.convertWinningNumbers(stringWinningNumbers);

        int bonusNumber = inputView.InputBonusNumber();

        lotto.confirmWinningNumber(winningNumbers, bonusNumber);

        resultView.printToWinningStatistics(lotto);
        return purchaseAmount;
    }
    public List<Integer> convertWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static long getPurchaseCount(long amount) {
        return amount / UNITAMOUNT;
    }

    // 구매한 수만큼 로또 생성
    public static List<LottoNumber> getLotto(long purchaseCount) {

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        LongStream.rangeClosed(1, purchaseCount)
                .forEach(it -> lottoNumbers.add(createLottoNumber()));

        return lottoNumbers;
    }

    public static LottoNumber createLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45)
                .forEach(numbers::add);

        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);

        return new LottoNumber(lottoNumbers, Level.valueOf(0));
    }
}