package com.lotto.view;

import com.lotto.domain.Lotto;
import com.lotto.helper.LottoViewHelper;

import java.util.List;
import java.util.Scanner;

public class LottoView {

    private static final String PURCHASE_AMOUNT_FOR_LOTTO_MESSAGE = "구매 금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_COUNT_OF_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String OUTPUT_MANUAL_LOTTO_COUNT_PREFIX_MESSAGE = "수동으로 ";
    private static final String OUTPUT_MANUAL_LOTTO_COUNT_POSTFIX_MESSAGE = "장, ";
    private static final String OUTPUT_AUTOMATIC_LOTTO_COUNT_PREFIX_MESSAGE = "자동으로 ";
    private static final String OUTPUT_AUTOMATIC_LOTTO_COUNT_POSTFIX_MESSAGE = "장을 구매하였습니다.";


    public Integer inputPurchaseAmountOfLotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PURCHASE_AMOUNT_FOR_LOTTO_MESSAGE);
        Integer depositMoney = scanner.nextInt();
        Integer countOfLotto = LottoViewHelper.getCountOfLotto(depositMoney);
        System.out.println();
        return countOfLotto;
    }

    public Integer inputCountOfManualLotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_COUNT_OF_MANUAL_LOTTO_MESSAGE);
        Integer count = scanner.nextInt();
        System.out.println();
        return count;
    }

    public void outputManualLottoMessage() {
        System.out.println(INPUT_MANUAL_LOTTO_MESSAGE);
    }

    public String inputManualLotto() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void outputResultOfEachLottoCount(Integer countOfAutomaticLotto, Integer countOfManualLotto) {
        System.out.println();
        StringBuilder builder = new StringBuilder()
                .append(OUTPUT_MANUAL_LOTTO_COUNT_PREFIX_MESSAGE)
                .append(countOfManualLotto)
                .append(OUTPUT_MANUAL_LOTTO_COUNT_POSTFIX_MESSAGE)
                .append(OUTPUT_AUTOMATIC_LOTTO_COUNT_PREFIX_MESSAGE)
                .append(countOfAutomaticLotto)
                .append(OUTPUT_AUTOMATIC_LOTTO_COUNT_POSTFIX_MESSAGE);

        System.out.println(builder);
    }

    public Integer inputBonusBall() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_BONUS_BALL_MESSAGE);
        return scanner.nextInt();
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
