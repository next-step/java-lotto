package kr.aterilio.nextstep.techcamp.m1.calculator;

public class AddCalculator {

    public static int calculate(Integer[] units) {
        int result = 0;
        for (int unit : units) {
            result += unit;
        }
        return result;
    }
}
