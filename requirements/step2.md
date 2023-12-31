# 🚀 2단계 - 로또(자동)
------------

## 기능 요구사항

* 사용자 입력 view
    * [x] 사용자에게 금액을 입력받는다.
    * [x] 입력값이 없는 경우 에러를 던진다.
    * [x] 지난 주 당첨 번호를 입력받는다.

* 로또 생성기
    * [x] 금액에 따라
    * [x] 자동으로 로또를 생성한다.

* 당첨 여부 확인
    * [x] 3개부터 6개까지 일치 여부를 판단한다.
    * [x] 수익률을 계산한다.

* 출력 view
    * [x] 자동으로 생성된 로또 번호들을 출력한다
    * [x] 당첨 통계를 출력한다.

## 프로그래밍 요구사항

* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
    * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다.
      if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    * method가 한 가지 일만 하도록 최대한 작게 만들어라.
* else를 사용하지 마라.
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다.
  단, UI 로직은 제외

## 참고