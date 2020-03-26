# 로또
## STEP 1 - 문자열 덧셈 계산기
* 구조 설계
  1. StringAddCalculator
  2. Number
  3. Numbers
  
* 기능 구현 플로우
  1. 입력 값 검증
       * null 일때 return 0
       * empty 일때 return 0
  1. 입력받은 문자열에서 커스텀 구분자를 확인
     * 있을 시 커스텀 문자열로 split
     * 없을 시 기본 구분자로 split
  3. 문자열 배열(컬렉션)을 0을 포함한 자연수로 파싱
     * 숫자 이외의 값일때 RuntimeException
     * 음수 일때 RuntimeException
  4. 합산