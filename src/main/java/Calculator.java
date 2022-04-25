import Operator.Operator;

import java.util.ArrayDeque;
import java.util.Queue;

public class Calculator {
    private static final String space = " ";
    /**
     * 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     */
    public static int play(String expression) {
        String[] partial = expression.split(space);
        if (isEmpty(partial)) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백문자 입니다.");
        }
        Queue<Character> queue = getQueue(partial);
        // 초기값 세팅
        int sum = Character.getNumericValue(queue.poll());
        while( !queue.isEmpty() ){
            Character input = queue.poll();
            Operator.isValid(input);
            sum = calculateByOperator(queue, sum, input);
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

    private static int calculateByOperator(Queue<Character> queue, int sum, Character input) {
        Character number = queue.poll();

        if ( Operator.check(input) == Operator.PLUS ) {
            sum += Character.getNumericValue(number);
        }
        if ( Operator.check(input) == Operator.MINUS ) {
            sum -= Character.getNumericValue(number);
        }
        if ( Operator.check(input) == Operator.MULTIPLY ) {
            sum *= Character.getNumericValue(number);
        }
        if ( Operator.check(input) == Operator.DIVIDE && isNotZero(number) ) {
            int intNumber = Character.getNumericValue(number);
            if(isNotZero(intNumber)){
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            sum /= Character.getNumericValue(intNumber);
        }
        return sum;
    }

    private static boolean isNotZero(int number) {
        return number != 0;
    }
}
