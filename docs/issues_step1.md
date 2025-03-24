# Issues
## 기본 전제조건
- 0 이하의 정수도 입력 가능 (ex. -1 + 3)
## 계산기 구현
### 기본 알고리즘
- 문자열을 입력받아 공백을 기준으로 나눔
- 나눈 배열의 첫 번째 값을 최초의 결과값으로 정하고 그 이후의 값을 연산자와 피연산자로 추출
- 연산자와 피연산자를 순서대로 연산
### 설계
- Calculator
  - 입력받은 문자열을 계산
  - Calculation을 생성하고 Calculation의 결과값을 반환
- Calculation
  - 연산자와 피연산자를 가지고 있음
  - 연산자와 피연산자를 계산
- Operator
  - 연산자 문자열이 정확한 지 검증
  - 연산자에 따라 연산
  - 정수끼리 나눌 경우 결과는 항상 소수점 이하를 버린 정수 (몫) 
- Operand
  - 피연산자를 반환
### OperatorType
- for-if 구문 indent depth 줄이기
  ```java
  public static OperatorType findOperatorByString(String value) {
      for (OperatorType candidateOperatorType : OperatorType.values()) {
        if (operatorType.value.equals(value)) {
        return operatorType;
        }
      }

      throw new IllegalArgumentException("Invalid operator");
  }
  ```

  ```java
  public static OperatorType findOperatorByString(String value) {
      OperatorType operatorType = null;
      for (OperatorType candidateOperatorType : OperatorType.values()) {
          operatorType = matchValue(value, operatorType, candidateOperatorType);
      }

      if (operatorType == null) {
          throw new IllegalArgumentException("Invalid operator");
      }

      return operatorType;
  }

  private static OperatorType matchValue(String value, OperatorType currentOperatorType, OperatorType operatorType) {
      if (currentOperatorType != null) {
          return currentOperatorType;
      }

      if (operatorType.value.equals(value)) {
          return operatorType;
      }
      return null;
  }
  ```
  - 이것이 정말 효율적인가?