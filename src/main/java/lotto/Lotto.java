package lotto;

import java.util.List;
import java.util.Scanner;

import lotto.dto.LottoResultAggregation;
import lotto.model.LottoNumbers;
import lotto.model.LottoReward;
import lotto.model.WinningNumber;
import lotto.view.LottoNumberResponseView;
import lotto.view.LottoResultAggregationResponseView;

public class Lotto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요.");

        int paymentAmount = scanner.nextInt();
        scanner.nextLine();
        int lottoQuantity = LottoVendingMachine.calculate(paymentAmount);
        System.out.println(String.format("%d개를 구매했습니다.", lottoQuantity));

        // create Lotter numbers
        LottoNumbers lottoNumbers = LottoVendingMachine.buy(lottoQuantity);

        System.out.println(new LottoNumberResponseView(lottoNumbers.getLottoNumbers()).toView());

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        WinningNumber winningNumber = WinningNumber.from(scanner.nextLine());

        System.out.println("당첨통계");
        System.out.println("------------------");
        List<LottoMatchResult> matchResultList = lottoNumbers.guess(winningNumber);
        LottoResultAggregation lottoResultAggregation = new LottoResultAggregation(matchResultList);

        for (LottoReward lottoReward : LottoReward.values()) {
            System.out.println(new LottoResultAggregationResponseView(lottoReward, lottoResultAggregation.getCount(lottoReward)));
        }
    }
}
