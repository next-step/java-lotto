package me.daeho.view;

import me.daeho.calculator.StringAddParser;
import me.daeho.utils.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String DEFAULT_REGEX = ",|:";
    private static final String CUSTOM_REGEX =  "//(.)\n(.*)";

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String input() {
        System.out.println("계산할 값을 입력하세요");
        return new Scanner(System.in).nextLine();
    }

}
