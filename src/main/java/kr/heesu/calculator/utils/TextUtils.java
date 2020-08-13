package kr.heesu.calculator.utils;

import kr.heesu.calculator.enums.IllegalCondition;

import java.util.ArrayList;
import java.util.List;

public class TextUtils {
    public static boolean matches(String text) {
        return IllegalCondition.matches(text);
    }

    public static List<Integer> getNumbers() {
        return new ArrayList<>();
    }
}
