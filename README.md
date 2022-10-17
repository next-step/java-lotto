# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 단계별 진행사항
* Step1 - 문자열 계산기
  * 기능 목록
    * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행하는 계산기를 구현한다.
    * 덧셈
    * 뺄셈
    * 곱셈
    * 나눗셈
    * 입력값 예외 처리(null, 공백 문자)
    * 입출력 클래스 추가
  * 요구 사항
    * 메소드 크기가 최대 10라인을 넘지 않도록
  * 피드백
    * try with resources 를 이용해 Scanner 자원 정리
    * Operator Singleton 관리로 성능 개선
    * try catch 내부에 if 조건으로 숫자와 연산자를 구분
    * 구분자 상수 관리
    * calculate 로직 개선
* Step2 - 로또(자동)
  * 기능 목록
    - [x] 구입금액과 숫자의 입/출력 기능(한 장 1000원)
    - [x] 로또 하나 생성 기능
    - [x] 구매 수만큼의 로또 생성 기능
    - [x] 당첨번호 입/출력(6개)
    - [x] 당첨 통계 출력
    - [x] 금액별 당첨 개수 기능
      - [x] 3개 일치 5000원
      - [x] 4개 일치 50000원
      - [x] 5개 일치 1500000원
      - [x] 6개 일치 2000000000원
    - [x] 수익률 기능
    - [x] 결과 출력
  * 자가점검 리팩토링 목록
    * ENUM 활용을 제대로(ENUM 자체적으로 활용되도록)
    * MVC 구조로 개선
    * LottoResult 로직 개선
    * OutPutView.printDrawResult 개선 -> View가 아니라 도메인 영역에서 계산하도록
    * 네이밍 개선
    * 테스트 코드, 예외처리 좀 더 꼼꼼히
  * 피드백
    - [x] 파일 마지막의 개행, FOSIX 표준
    - [x] 입력을 위한 출력도 InputView 책임으로 이동
    - [x] 메소드 내부 의미 단위로 개행 추가
    - [x] LottoNumber 역할 분리
    - [x] Enum 내부 Abstract Method 활용
    - [x] Shuffle 테스트 가능한 구조로 변경
* Step3 - 로또(2등)
  * Step2 추가 피드백
    - [ ] LottoNumbers 에게 번호가 몇 개 일치하는지 물어보기
    - [ ] LottoNumber 도메인을 통해 항상 1~45 사이의 값을 가지고 있음을 알리기
    - [x] LottoNumber Collection Type 고민하기
    - [x] LottoResult indent 줄이기
    - [x] Prize 당첨이 안됨을 나타내는 값을 추가하기
    - [x] Prize enum 에서 reward 를 값으로 가지기
  * 기능 목록
    - [x] 보너스 번호 입력
    - [x] 2등 추가(5개 일치 + 보너스 볼 일치 - 30000000)
    - [x] 통계 출력(보너스 볼 추가)
