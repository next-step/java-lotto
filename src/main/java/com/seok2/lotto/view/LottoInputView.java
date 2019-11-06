package com.seok2.lotto.view;

import static com.seok2.lotto.domain.Lotto.PRICE;

import com.seok2.lotto.domain.Lotto;
import com.seok2.lotto.domain.LottoNumber;
import com.seok2.lotto.domain.Money;
import com.seok2.lotto.domain.Paper;
import com.seok2.lotto.domain.Papers;
import com.seok2.lotto.domain.WinningLotto;
import com.seok2.lotto.exception.PurchaseAmountException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LottoInputView {

    private static final String PURCHASE_AMOUNT_MSG = "구매금액을 입력해 주세요.";
    private static final String NUMBER_OF_MANUAL_NUMBER_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_NUMBER_MSG = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_LOTTO_MSG = "지난 주 당첨 번호를 입력해주세요.";
    private static final String WINNING_BONUS_NUMBER_MSG = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private LottoInputView() {
    }

    public static Money getInvestment() {
        System.out.println(PURCHASE_AMOUNT_MSG);
        return Money.of(scanner.nextInt());
    }

    public static WinningLotto getWinning() {
        System.out.println(WINNING_LOTTO_MSG);
        Lotto winning = Lotto.generate(scanner.next());
        System.out.println(WINNING_BONUS_NUMBER_MSG);
        return WinningLotto.of(winning, LottoNumber.of(scanner.nextInt()));
    }

    public static Papers getPapers(Money investment) {
        System.out.println(NUMBER_OF_MANUAL_NUMBER_MSG);
        int trials = scanner.nextInt();
        if (trials <= 0) {
            return Papers.empty();
        }
        return getPapers(trials, investment);
    }

    private static Papers getPapers(int trials, Money investment) {
        validate(trials, investment);
        System.out.println(MANUAL_NUMBER_MSG);
        Queue<Paper> papers = new LinkedList<>();
        IntStream.range(0, trials)
            .forEach(i -> papers.offer(Paper.of(scanner.next())));
        return Papers.of(papers);
    }

    private static void validate(int trials, Money investment) {
        if (!isPurchasable(trials, investment)) {
            throw new PurchaseAmountException();
        }
    }

    private static boolean isPurchasable(int trials, Money investment) {
        return investment.moreThanOrEquals(PRICE.multiply(trials));
    }

    public static void main(String[] args) {
        IntStream.of(2).forEach(System.out::println);
    }
}
