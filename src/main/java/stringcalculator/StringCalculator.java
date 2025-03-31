package stringcalculator;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import stringcalculator.operation.AddOperationImpl;
import stringcalculator.operation.MultiplicationOperationImpl;
import stringcalculator.operation.Operation;
import stringcalculator.operation.SubtractionOperationImpl;

public class StringCalculator {

  private static final String DELIMITER = " ";

  private static List<String> parseValidTokens(String input) {

    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException();
    }

    List<String> tokens = Arrays.asList(input.split(DELIMITER));


    if (tokens.size() < 3) {
      throw new IllegalArgumentException();
    }

    return tokens;
  }

  public int calculateString(String input) {
    List<String> tokens = parseValidTokens(input);
    return calculate(tokens);
  }

  private int calculate(List<String> tokens) {
    return IntStream.range(0, tokens.size())
        .filter(i -> OperationFactory.isOperator(tokens.get(i))) // 연산자 필터링
        .mapToObj(i -> new AbstractMap.SimpleEntry<>(
            OperationFactory.getOperation(tokens.get(i)), // 연산자에 해당하는 Operation 객체 생성
            Integer.parseInt(tokens.get(i + 1)))) // 연산자 바로 뒤의 값을 숫자로 변환
        .reduce(Integer.parseInt(tokens.get(0)), // 초기값: 첫 번째 숫자
            (acc, entry) -> entry.getKey().apply(acc, entry.getValue()), // Operation을 적용하여 누적 연산 진행
            Integer::sum); // 최종 합산
  }

  private static class OperationFactory {
    private static final Map<String, Operation> operations = Map.of(
        "+", new AddOperationImpl(),
        "-", new SubtractionOperationImpl(),
        "*", new MultiplicationOperationImpl()
    );

    public static Operation getOperation(String operator) {
      return Optional.ofNullable(operations.get(operator))
          .orElseThrow(() -> new IllegalArgumentException("Invalid operator: " + operator));
    }

    public static boolean isOperator(String token) {
      return !isNumber(token);
    }

    private static boolean isNumber(String token) {
      try {
        // 숫자로 변환이 가능한지 확인 (정수)
        Integer.parseInt(token);
        return true;
      } catch (NumberFormatException e) {
        return false; // 숫자로 변환할 수 없는 경우
      }
    }

  }
}
