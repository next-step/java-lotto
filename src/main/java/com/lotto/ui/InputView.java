package com.lotto.ui;

import com.lotto.domain.RequestPurchaseLotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputDataFromConsole() {
        return scanner.nextLine();
    }

    public static RequestPurchaseLotto inputPurchase() {
        RequestPurchaseLotto requestPurchaseLotto = new RequestPurchaseLotto();

        repeatInputTotalPrice(requestPurchaseLotto);
        repeatInputManualLottoCount(requestPurchaseLotto);
        repeatInputManualNumbers(requestPurchaseLotto);

        return requestPurchaseLotto;
    }

    private static String[] inputManualNumbers(RequestPurchaseLotto requestPurchaseLotto) {
        String[] sLottoList = new String[requestPurchaseLotto.getManualLottoCount()];
        for (int i = 0; i< requestPurchaseLotto.getManualLottoCount(); i++) {
            sLottoList[i] = inputDataFromConsole();
        }
        return sLottoList;
    }

    private static void repeatInputManualNumbers(RequestPurchaseLotto requestPurchaseLotto) {
        try {
            OutputView.requireManualNumberList();
            requestPurchaseLotto.setLottoList(inputManualNumbers(requestPurchaseLotto));
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            repeatInputManualNumbers(requestPurchaseLotto);
        }
    }

    private static void repeatInputManualLottoCount(RequestPurchaseLotto requestPurchaseLotto) {
        try {
            OutputView.requireManualLottoCount();
            requestPurchaseLotto.setManualLottoCount(inputDataFromConsole());
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            repeatInputManualLottoCount(requestPurchaseLotto);
        }
    }

    private static void repeatInputTotalPrice(RequestPurchaseLotto requestPurchaseLotto) {
        try {
            OutputView.requireLottoPrice();
            requestPurchaseLotto.setTotalPrice(inputDataFromConsole());
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            repeatInputTotalPrice(requestPurchaseLotto);
        }
    }
}
