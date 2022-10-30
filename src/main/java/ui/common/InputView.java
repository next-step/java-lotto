package ui.common;

import util.SingletonScanner;

public final class InputView {

    private InputView() {
    }


    public static int inputInteger() {
        return Integer.parseInt(SingletonScanner.getInstance().nextLine());
    }

    public static String inputString() {
        return SingletonScanner.getInstance().nextLine();
    }

    public static long inputLong() {
        return Long.parseLong(SingletonScanner.getInstance().nextLine());
    }
}