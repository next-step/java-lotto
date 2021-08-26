package com.techmoa.view;

import java.util.Scanner;

public class InputView {

    public final Scanner SCANNER = new Scanner(System.in);

    public void read() {
        if(SCANNER.hasNextLine()) {
            parserString("");
        }
    }

    private void parserString(String inputStr) {

    }
}
