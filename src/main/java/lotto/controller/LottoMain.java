package lotto.controller;

import lotto.domain.LottoStore;
import lotto.domain.LottoTickets;
import lotto.ui.LottoRequest;
import lotto.ui.LottoResult;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int price = sc.nextInt();

        sc.nextLine();
        System.out.println("구매할 로또 타입을 입력해 주세요.");
        String type = sc.nextLine();

        LottoRequest request = new LottoRequest(price, type);
        System.out.println(request);

        LottoStore store = new LottoStore();
        LottoTickets lottoTickets = store.buyLotto(request);

        System.out.println("지난주 당첨번호를 입력하세요.");
        String numbers = sc.nextLine();

        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = sc.nextInt();

        List<Integer> hitNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LottoResult result = lottoTickets.createLottoResult(hitNumbers, bonusNumber);
        result.printWinningStatistics();
    }
}
