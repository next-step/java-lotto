package com.lotto.view;

import com.lotto.domain.Lotto;

import java.util.List;
import java.util.Scanner;

public class LottoView {

    private static final Integer PRIZE_OF_LOTTO = 1000;

    private static final String PURCHASE_AMOUNT_FOR_LOTTO_MESSAGE = "구매 금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_PER_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private Scanner scanner;

    public LottoView() {
        this.scanner = new Scanner(System.in);
    }

    public Integer inputPurchaseAmountOfLotto() {
        System.out.println(PURCHASE_AMOUNT_FOR_LOTTO_MESSAGE);
        Integer depositMoney = this.scanner.nextInt();
        Integer countOfLotto = getCountOfLotto(depositMoney);
        System.out.println(countOfLotto + LOTTO_COUNT_PER_PURCHASE_AMOUNT_MESSAGE);
        return countOfLotto;
    }

    private Integer getCountOfLotto(Integer depositMoney) {
        return depositMoney / PRIZE_OF_LOTTO;
    }

    public void outputExtractedLotto(List<Lotto> lotto) {
        for (Lotto extracted : lotto) {
            System.out.println(extracted.toString());
        }
    }
    
}
