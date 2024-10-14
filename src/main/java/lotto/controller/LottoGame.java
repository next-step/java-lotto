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
        LottoMatcher matcher = new LottoMatcher(lotto);
        List<Integer> matchedLottoList = matcher.matchLottoNumber(lotto.chooseLottoNumber(lotto.purchase()));

        LottoPrint lottoPrint = new LottoPrint();
        lottoPrint.lottoResult(matchedLottoList, Integer.parseInt(purchasedAmount));
    }

}
