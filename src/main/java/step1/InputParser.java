package step1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InputParser {

    private static final String DELIMITER = " ";
    private static final int NUMBER_START_INDEX = 0;
    private static final int OPERATOR_START_INDEX = 1;
    private static final int INDEX_INCREMENT = 2;

    public List<String> splitUserInput(String userInput) {
        validateUserInput(userInput);
        return List.of(userInput.split(DELIMITER));
    }

    private void validateUserInput(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자열입니다.");
        }
    }

    public Queue<Integer> parseFromTokenToNumber(List<String> tokens) {
        Queue<Integer> numbers = new LinkedList<>();
        for (int i = NUMBER_START_INDEX; i < tokens.size(); i = i + INDEX_INCREMENT) {
            numbers.add(Integer.parseInt(tokens.get(i)));
        }
        return numbers;
    }

    public Queue<Operator> parseFromTokenToOperator(List<String> tokens) {
        Queue<Operator> operators = new LinkedList<>();
        for (int i = OPERATOR_START_INDEX; i < tokens.size(); i = i + INDEX_INCREMENT) {
            operators.add(Operator.findOperatorByUserInput(tokens.get(i))); //Operator의 필드를 String으로 바꿀지, 기존로직을 이용할지 고민
        }
        return operators;
    }

}
