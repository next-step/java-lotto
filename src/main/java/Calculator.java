import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Calculator {
    private static Character operatorsArr[] = { '+', '-', '*', '/' };
    /**
     * 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     */
    public static int play(String expression) {
        String[] partial = expression.split(" ");
        if (isEmpty(partial)) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백문자 입니다.");
        }
        Queue<Character> queue = getQueue(partial);
        // 초기값 세팅
        int sum = Character.getNumericValue(queue.poll());
        while( !queue.isEmpty() ){
            Character input = queue.poll();
            isValidOperator(input);
            sum = getSumByOperator(queue, sum, input);
        }
        return sum;
    }

    private static boolean isEmpty(String[] partial) {
        return partial.length == 0;
    }

    public static int play(){
        throw new IllegalArgumentException("입력값이 null이거나 빈 공백문자 입니다.");
    }

    private static Queue<Character> getQueue(String[] partial) {
        Queue<Character> queue = new ArrayDeque<>();
        for (String s : partial) {
            queue.add(s.charAt(0));
        }
        return queue;
    }

    private static int getSumByOperator(Queue<Character> queue, int sum, Character input) {
        Character number = queue.poll();

        if ( input == '+' ) {
            sum += Character.getNumericValue(number);
        }
        if ( input == '-' ) {
            sum -= Character.getNumericValue(number);
        }
        if ( input == '*' ) {
            sum *= Character.getNumericValue(number);
        }
        if ( input == '/' ) {
            sum /= Character.getNumericValue(number);
        }
        return sum;
    }

    private static void isValidOperator(Character input) {
        boolean retval = Arrays.asList(operatorsArr).contains(input);
        if( !retval ){
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }
}
