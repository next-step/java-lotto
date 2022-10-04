package com.calculator.string;

import com.calculator.operator.Operator;

import java.util.Arrays;
import java.util.Iterator;

public class StringCalculator {

    public static final String CALCULATION_FORMULA_SEPARATOR = " ";

    /**
     * 사칙연산 계산식을 수행하는 메소드 (입력 값에 따라 계산 순서가 결정된다)
     *
     * @param calculationFormula 숫자와 사칙 연산 사이에 빈 공백이 포함된 사칙연산 계산식 문자열
     * @return 사칙연산 int 결과값
     */
    public static int calculate(String calculationFormula) {
        isValidCalculationFormula(calculationFormula);
        Iterator<String> splitValues = getIteratorFromCalculationFormula(calculationFormula, CALCULATION_FORMULA_SEPARATOR);
        int result = Integer.parseInt(splitValues.next());
        while (splitValues.hasNext()) {
            String operatorSymbol = splitValues.next();
            int nextNumber = Integer.parseInt(splitValues.next());
            result = Operator.calculateValue(operatorSymbol, result, nextNumber);
        }
        return result;
    }

    private static void isValidCalculationFormula(String calculationFormula) {
        if (calculationFormula == null || calculationFormula.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다!");
        }
    }

    private static Iterator<String> getIteratorFromCalculationFormula(String calculationFormula, String regex) {
        return Arrays.stream(calculationFormula.split(regex))
                .iterator();
    }
}
