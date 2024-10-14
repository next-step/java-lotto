package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.LottoInput;
import lotto.domain.LottoMatcher;
import lotto.view.LottoPrint;

import java.util.List;
import java.util.Scanner;

public class LottoGame {


    public static void main(String[] args) {
        gameStart();
    }

    static private final Scanner scanner = new Scanner(System.in);

    public static void gameStart() {
        LottoInput lottoInput = new LottoInput();

        System.out.println("구매금액을 입력하세요.");

        String purchasedAmount = scanner.nextLine();
        Lotto lotto = new Lotto(lottoInput.purchaseValid(purchasedAmount));

        int purchaseCount = lotto.purchase();
        System.out.println(purchaseCount +"개를 구매했습니다.");

        List<List<Integer>> lottoPurchaseAmounts = lotto.chooseLottoNumber(purchaseCount);
        for(List<Integer> list : lottoPurchaseAmounts) {
            System.out.println(list);
        }

        System.out.println("지난 주 당첨번호를 입력해주세요");
        String winningLottoNumbers = scanner.nextLine();

        List<Integer> winningNumbers = lotto.getLottoNumber(winningLottoNumbers);

        LottoMatcher matcher = new LottoMatcher(lotto, winningNumbers);
        List<Integer> matchedLottoList = matcher.matchLottoNumber(lottoPurchaseAmounts);

        LottoPrint lottoPrint = new LottoPrint();
        lottoPrint.lottoResult(matchedLottoList, Integer.parseInt(purchasedAmount));
    }

}
