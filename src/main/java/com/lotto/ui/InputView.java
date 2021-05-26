package com.lotto.ui;

import com.lotto.domain.ReqPurchaseLotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputDataFromConsole() {
        return scanner.nextLine();
    }

    public static ReqPurchaseLotto inputPurchase() {
        ReqPurchaseLotto reqPurchaseLotto = new ReqPurchaseLotto();

        repeatInputTotalPrice(reqPurchaseLotto);
        repeatInputManualLottoCount(reqPurchaseLotto);
        repeatInputManualNumbers(reqPurchaseLotto);

        return reqPurchaseLotto;
    }

    private static String[] inputManualNumbers(ReqPurchaseLotto reqPurchaseLotto) {
        String[] sLottoList = new String[reqPurchaseLotto.getManualLottoCount()];
        for (int i = 0; i< reqPurchaseLotto.getManualLottoCount(); i++) {
            sLottoList[i] = inputDataFromConsole();
        }
        return sLottoList;
    }

    private static void repeatInputManualNumbers(ReqPurchaseLotto reqPurchaseLotto) {
        try {
            OutputView.requireManualNumberList();
            reqPurchaseLotto.setLottoList(inputManualNumbers(reqPurchaseLotto));
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            repeatInputManualNumbers(reqPurchaseLotto);
        }
    }

    private static void repeatInputManualLottoCount(ReqPurchaseLotto reqPurchaseLotto) {
        try {
            OutputView.requireManualLottoCount();
            reqPurchaseLotto.setManualLottoCount(inputDataFromConsole());
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            repeatInputManualLottoCount(reqPurchaseLotto);
        }
    }

    private static void repeatInputTotalPrice(ReqPurchaseLotto reqPurchaseLotto) {
        try {
            OutputView.requireLottoPrice();
            reqPurchaseLotto.setTotalPrice(inputDataFromConsole());
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            repeatInputTotalPrice(reqPurchaseLotto);
        }
    }
}
