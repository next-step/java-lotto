package calculator.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validator {

    private static final Pattern OPERATOR = Pattern.compile("[+\\-*/]");

    public static List<String> checkCount(List<String> operands, List<String> operators) {
        int operandsCount = operands.size();
        int compareCount = operators.size();

        if (operandsCount <= compareCount ) {
            throw new IllegalArgumentException("연산할 숫자가 부족합니다.");
        }

        return Stream.of(operands,operators).flatMap(Collection::stream).collect(Collectors.toList());
    }


    public static String operatorCheck(String splitExpression) {
        Matcher matcher = OPERATOR.matcher(splitExpression);

        if (!matcher.find()) {
            throw new RuntimeException("올바른 연산자를 입력해주세요.");
        }

        return splitExpression;

    }
}
