# 로또
## [1단계 - 문자열 계산기]
1. 기능 구현 사항
   1. 사용자가 문자열을 입력한다.
      1. 입력 값이 null이거나 빈 공백 문자일 경우, IllegalArgumentException throw - 테스트 1
   2. 입력 문자열을 split(" ")을 통해 분리한다.
   3. 문자열을 순회하면서 연산 진행, 계산 - 테스트 7 (입력 값에 따라 계산 진행)
      1. 숫자일 경우 연산 진행 (첫 숫자 제외)
      2. 연산자일 경우 5가지의 경우의 수
         1. 연산 기호가 아닐 경우, IllegalArgumentException throw - 테스트 2
         2. 덧셈 기호일 경우, 덧셈 - 테스트 3
         3. 뺄셈 기호일 경우, 뺄셈 - 테스트 4
         4. 곱셈 기호일 경우, 곱셈 - 테스트 5
         5. 나눗셈 기호일 경우, 나눗셈. 단, 결과 값이 정수로 떨어지도록 하기 - 테스트 6
   4. 정답 출력

2. 기타 구현 사항 (일급 컬렉션 제거, enum 사용): 피드백 반영
   1. IntCalculator interface
   2. Operator enum 사용 (연산 담당 클래스를 정의하여 책임 부여)
   3. 유효성 검사(isValidOperator)를 상태를 가지는 객체 클래스에서 진행

## [2단계 - 로또(자동)]
1. 기능 구현 사항
   1. 사용자가 로또 구입 금액을 입력한다.
   2. 로또 생성 개수를 산출한다.
   3. 로또 생성 전략에 따라 로또를 생성한다. - 테스트 1
   4. 당첨 번호를 입력 받는다. (여기서는 "1, 2, 3, 4, 5, 6"으로 고정되어 있음)
   5. 로또의 당첨 여부를 확인한다. - 테스트 2
   6. 당첨 번호 일치 개수, 당첨금, 수익률을 산출한다. (수익률 = 당첨금/구입 금액,  소숫점 두 자리까지)

2. 피드백 반영 사항
   1. 1부터 45까지의 로또 번호를 보장하는 클래스 추가 (LottoNumber, LottoNumbersGenerator)
   2. Rank의 추가에 따라 UI Layer가 영향을 받는 구조 개선
   3. 정의한 도메인 클래스에 대한 단위 테스트 추가

## [3단계 - 로또(2등)]
1. 2단계 피드백 반영 사항
   1. ForceLottoCreationStrategy를 test package로 이동
   2. Lotto class 내부 유효성 검사 실시
      - 다만, WinningLotto에서 실시하는 유효성 검사와 같아 LottoValidationUtils 생성
   3. LottoNumbersGenerator 삭제
      - LottoCreationStrategy에 1~45 숫자 배열 생성 로직 추가
      - 로또 생성 시마다 매번 배열을 생성하는 로직 변경
   4. WinningLotto 정의
   5. LottoNumber 생성 시 유효성 검증 로직(1~45 숫자 보장)

2. 3단계 기능 요구 사항
   1. 추가 번호 하나 더 추첨
   2. 당첨 통계에 2등 추가

3. 기능 구현 사항
   1. Rank enum에 2등(5개 일치, 보너스 숫자 일치) 추가
   2. WinningLotto 내 findRank 로직 수정
   3. ResultView에서의 멘트 변경
   4. LottoNumber에서의 유효성 검증 로직도 보너스 번호 때 사용되어서 LottoNumberValidationUtilsTest로 뺌

4. 3단계 피드백 반영 사항
   1. Lotto 객체가 생성한 LottoNumber 객체를 가지도록 변경
   2. Util 모두 제거, 상태를 가진 객체가 유효성 검사를 진행하도록 변경
   3. WinningLotto 객체 상태 필드 변경
   4. findRank 접근 제어자 변경
   5. Rank 내 findRank 구현
   6. test 위한 클래스를 test 폴더 하위로 이동
   7. 로또 클래스 Set 컬렉션 이용