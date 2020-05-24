package com.lotto.view;

import com.lotto.domain.Lotto;
import com.lotto.helper.LottoViewHelper;

import java.util.List;
import java.util.Scanner;

public class LottoView {

    private static final String PURCHASE_AMOUNT_FOR_LOTTO_MESSAGE = "구매 금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_PER_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public Integer inputPurchaseAmountOfLotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PURCHASE_AMOUNT_FOR_LOTTO_MESSAGE);
        Integer depositMoney = scanner.nextInt();
        Integer countOfLotto = LottoViewHelper.getCountOfLotto(depositMoney);
        System.out.println(countOfLotto + LOTTO_COUNT_PER_PURCHASE_AMOUNT_MESSAGE);
        return countOfLotto;
    }

    public void outputExtractedLotto(List<Lotto> lotto) {
        for (Lotto extracted : lotto) {
            System.out.println(extracted.toString());
        }
        System.out.println();
    }

    public String inputWinningLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WINNING_LOTTO_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
