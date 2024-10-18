# 로또

## 프로젝트 개요

TDD와 클린 코드 원칙을 실습하기 위한 프로젝트 입니다.

## 주요 기능

### 문자열 사칙 연산 계산기

- 계산
    - 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/)을 연산한다.
    - 나눗셈의 결과 값은 정수로 한정한다. (10 / 3 => 3)
    - 사칙연산의 계산 우선순위가 아닌 입력 값의 순서대로 계산한다. (2 + 3 * 4 / 2 => 10)
- 예외처리
    - 입력값이 null이거나 빈 공백 문자일 경우 예외
    - 사칙 연산 기호(+, -, *, /)가 아닌 경우 예외
- 입/출력
    - 숫자와 연산자 사이에 공백이 존재하는 문자열을 입력한다. (2 + 3 * 4 / 2)
    - 문자열 계산결과를 출력한다. (10)
- 개발 원칙
    - 구현하는 코드에 단위 테스트를 추가
    - indent(들여쓰기) 1단계까지만 허용
    - 메소드
        - 크기가 최대 10라인을 넘지 않도록 구현
        - 한 가지 일만 하도록 최대한 작게 구현
    - else 사용금지

### 로또

- 로또
    - 로또는 1이상 45이하인 6개의 정수를 자동으로 발급한다.
    - 로또를 구입 금액에 맞는 개수를 구한다. (로또 가격: 1장당 1000원)
    - 당첨 번호와 보너스 볼이 일치하는 로또의 개수를 구한다.
        - 당첨 기준
            - 1등: 6개 일치
            - 2등: 5개 일치 + 보너스 볼 일치
            - 3등: 5개 일치
            - 4등: 4개 일치
            - 5등: 3개 일치
    - 총 수익률을 구한다. (수익률 = 수익 / 구입 금액)
- 입/출력
    - 구입 금액을 입력한다. (단, 입력값은 정수)
    - 로또 개수를 출력한다.
    - 발급된 로또를 출력한다.
    - ", " 구분자를 이용하여, 당첨 번호를 입력한다.
    - 보너스 번호를 입력한다.
    - 당첨 통계를 출력한다.
        - 3~6개의 번호가 일치하는 개수
        - 총 수익률 (입력 금액과 당첨 금액이 일치하는 경우 => 1)
- 개발 원칙
    - 모든 기능을 TDD로 구현해 단위 테스트가 존재
    - indent(들여쓰기) 1단계까지만 허용
    - 메소드
        - 크기가 최대 15라인을 넘지 않도록 구현
        - 한 가지 일만 하도록 최대한 작게 구현
    - else 사용금지
    - 구글 자바 코드 컨벤션 사용
    - java enum 적용
    - 일급 콜렉션 사용