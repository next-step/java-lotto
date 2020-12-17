package com.ssabae.nextstep.stringcalculator.view;

import java.util.Scanner;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-14
 */
public class UserInputHelper {

    private static final String INPUT_VALUE = "계산기에 값을 입력해주세요.(ex: 1,2,3 or 1:2:3 or //;\\n1;2;3)";

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(UserInputHelper.INPUT_VALUE);
        return scanner.nextLine();
    }
}
