# STEP 1 : 문자열 계산기

## ✅ 구현 목록

---

### `StringCalculator.class`

- [x] 입력값을 받아(= validate에서 유효성 처리) 
  계산을 한 다음(= Operator에서 연사자에 대한 로직 처리)
  답을 반환하는 클래스

### `Operator.java`

- [x] 연산자를 enum 클래스로 받아 처리
- [x] 유효한 연산자에 대한 계산 로직 처리
- [x] 유효하지 않은 연산자가 들어오는 경우에 대해 처리

### `Validator.java`

- [x] null, 공백 입력값에 대한 유효성 체크
- [x] `0~9`, `+-/*`로만 이루어진 입력값에 대한 유효성 체크
- [x] 문자열 순서에 대한 유효성 체크

### 테스트 코드

- [x] `OperatorTest.java` -> Operator에 대한 테스트 클래스
- [x] `StringCalculator.java` -> StringCalculator에 대한 테스트 클래스
- [x] `ValidatorTest.java` -> Validator에 대한 테스트 클래스

### 컨벤션

- [x] Java : Intellij idea Code Style java 적용
- [x] Commit : AngularJS Commit Message 사용

### 코드 규칙

- [x] else 예약어 사용 X
- [x] indent의 들여쓰기 depth는 1회까지 허용
- [x] 함수(또는 메서드)의 길이가 10라인을 넘지 않도록 작성