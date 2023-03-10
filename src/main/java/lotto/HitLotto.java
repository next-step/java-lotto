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

public class HitLotto {
    private static final long LOTTO_AMOUNT = 1000;

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        HitLotto hitLotto = new HitLotto();

        // 구입금액 입력
        long purchaseAmount = inputView.PurchaseAmount();

        // 로또 생성
        Lotto lotto = new Lotto(purchaseAmount, hitLotto.getLotto(hitLotto.getPurchaseCount(purchaseAmount)));

        // 구매내역 출력
        resultView.PurchaseHistory(hitLotto.getPurchaseCount(purchaseAmount), lotto);

        // 지난 주 당첨 번호 입력
        String stringWinningNumbers = inputView.InputWinningNumber();
        List<Integer> winningNumbers = hitLotto.convertWinningNumbers(stringWinningNumbers);

        // 보너스 볼 입력
        int bonusNumber = inputView.InputBonusNumber();

        // 로또 당첨 확인
        lotto.confirmWinningNumber(winningNumbers, bonusNumber);

        // 당첨 통계 출력
        resultView.printToWinningStatistics(lotto);
    }

    // 당첨번호 변환: 입력 받은 당첨번호를 숫자 리스트로 변환
    private List<Integer> convertWinningNumbers(String winningNumbers) {

        return Arrays.stream(winningNumbers.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    // 로또 구매 수
    private long getPurchaseCount(long amount) {

        return amount / LOTTO_AMOUNT;
    }

    // 구매한 수만큼 로또 생성
    private List<LottoNumber> getLotto(long purchaseCount) {

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        LongStream.rangeClosed(1, purchaseCount)
                .forEach(it -> lottoNumbers.add(createLottoNumber()));

        return lottoNumbers;
    }

    // 로또 번호 생성
    private LottoNumber createLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45)
                .forEach(numbers::add);

        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);

        return new LottoNumber(lottoNumbers, Level.valueOf(0));
    }
}
