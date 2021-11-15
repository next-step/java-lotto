package com.kakao.stringadder.ui;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static String expression(InputStream inputStream) {
        return new Scanner(inputStream).nextLine();
    }
}
