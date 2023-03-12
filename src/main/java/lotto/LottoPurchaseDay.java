package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoPurchaseDay {

    /**
     * 로또 구매를 실행하는 함수
     *
     * @param budget            금액
     * @param winnerPrizeNumber 당첨 번호
     * @param bonusBall         보너스 번호
     */
    void scenario(int budget, String winnerPrizeNumber, int bonusBall) {
        Customer customer = new Customer();
        LottoOrganizer lottoOrganizer = new LottoOrganizer();

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
            .collect(
                Collectors.toList());

        // 시스템 UI 출력 구간
        System.out.println("");
        System.out.println("보너스 볼을 입력해 주세요.");
        System.out.println(bonusBall);
        // 시스템 UI 출력 구간

        lottoOrganizer.allCheckInWallet(customer.getWallet(), winnerNumber, bonusBall);
        TextView.printCustomerLottoResult(customer.getWallet(), budget);
    }
}
