package calculator;

import java.util.List;
import java.util.Scanner;

/**
 *
 * 기능 요구사항
 * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
 * 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
 * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 *
 * */


public class StringCalculator {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NUM_AND_OPERATOR_DELIMITER = " ";
    
    public int calculate(String input) {
        List<String> inputArrays = validAndSplitInput(input);
        for (int i = 1; i < inputArrays.size(); i = i + 2) {

        }

        return 0;
    }

    private List<String> validAndSplitInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없거나 빈 문자열 입니다");
        }

        String[] inputArrays = input.split(NUM_AND_OPERATOR_DELIMITER);
        if (inputArrays.length < 2) {
            throw new IllegalArgumentException("입력값이 하나이거나 비정상 문자열 입니다");
        }

        return List.of(inputArrays);
    }

    // split 한 문자열을 숫자와 연산자로 따로 나눠서 작업할지, 하나의 리스트로 관리하며 홀수 인덱스 = 연산자, 짝수인덱스=숫자의 공식을 가져갈건지. 후자로 결정.

    public int add(int left, int right) {
        return left + right;
    }

    public int sub(int left, int right) {
        return left - right;
    }

    public int multi(int left, int right) {
        return left * right;
    }

    public int div(int left, int right) {
        return left / right;
    }

    public static void main(String[] args) {
        String input = SCANNER.nextLine();
        
        
    }
}
