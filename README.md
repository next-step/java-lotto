# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---
# 1단계 - 문자열 덧셈 계산기
## 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
## 기능 요구사항 분리 및 힌트
- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
- [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
- [x] “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
- [x] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)

---

# 2단계 - 로또(자동)
## 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.
## 프로그래밍 요구사항
- [x] 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- [x] indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- [x] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [x] else 예약어를 쓰지 않는다.
## 구현할 기능 목록
### InputView, ResultView
- 입출력 관련 로직 구현
### LottoBall
- 1 ~ 45번까지 로또 번호 생성 후 캐싱
    - 로또 번호 범위 validation
### LottoBalls
- 로또 공들을 관리하는 일급 컬렉션
- 자동 추첨 방식으로 공 관리
- 입력받은 지난 주 당첨 로또 공 관리
- 로또 공들의 크기를 6개로 제한
- 자동 추첨 공 정렬
### Lotto
- 로또 6개 번들 객체
### Lottos
- 구매한만큼의 로또들을 관리하는 객체
### LottoGenerator, AutoLottoGenerator
- 함수형 인터페이스 활용
### WinningLotto
- 지난 주 당첨 로또 객체
### Money
- 입력한 돈 관리
- 입력한만큼의 로또를 구매
### Prize
- 로또 당첨 금액 Enum
### LottoResult
- 로또 당첨 개수 확인
- 수익률 계산
### LottoMachine
- 로또 전체 작동
### LottoApplication
* Main
