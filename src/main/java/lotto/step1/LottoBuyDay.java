package lotto.step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBuyDay {

    //로또 구매를 실행하는 함수
    //budget            금액
    //winnerPrizeNumber 당첨 번호
    //bonusBall         보너스 번호
    void scenario(int budget, String winnerPrizeNumber, int bonusBall) {
        Client customer = new Client();
        LottoOrg lottoOrganizer = new LottoOrg();

        // 시스템 UI 출력 구간
        System.out.println("구입금액을 입력해 주세요.");
        System.out.println(budget);
        // 시스템 UI 출력 구간

        customer.purchase(budget);

        // 시스템 UI 출력 구간
        System.out.println("");
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        System.out.println(winnerPrizeNumber);
        // 시스템 UI 출력 구간

        List<Integer> winnerNumber = Arrays.stream(winnerPrizeNumber.split(","))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());

        // 시스템 UI 출력 구간
        System.out.println("");
        System.out.println("보너스 볼을 입력해 주세요.");
        System.out.println(bonusBall);
        // 시스템 UI 출력 구간

        lottoOrganizer.allCheckInWallet(customer.getWallet(), winnerNumber, bonusBall);
        LottoResultView.printCustomerLottoResult(customer.getWallet(), budget);
    }
}
