# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

# Step1 (문자열 덧셈 계산기)
## 기능 요구 사항
- 쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 프로그래밍 요구사항
- indent (들여쓰기) depth를 2단계에서 1단계로 줄여라
    - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

# Step2 (로또 - 자동)
## 기능 요구 사항
- 로또 구입 금액을 입력하면, 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 힌트
- 로또 자동 생성은 `Collections.shuffle()` 메소드를 활용한다.
- `Collections.sort()` 메소드를 활용하여 정렬 가능하다.
- ArrayList의 `contains()` 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 구현할 기능 목록
- 구입 관련
    - 구입 금액에 맞게 발급한 로또 용지 장수가 일치하는지 확인 (구입 금액에 해당하는 로또 용지 장수 반환하는가?)
    - 구입 금액에 맞는 로또 용지 발급 (생성)
    - 로또 묶음 얻기
- 당첨 번호 생성 관련
    - 입력받은 당첨 번호를 split하여 당첨번호 객체 생성
    - 당첨 번호를 6개만 입력하였는지 확인
    - 당첨 번호 range가 1 ~ 45인지 (정상적인 번호인지) 확인
- 당첨 용지 찾기 관련
   - 기존에 생성된 로또에 대해 당첨 결과 얻기
   - 로또 묶음에 대해 당첨 결과 얻기
- 수익률 계산 관련
   - 수익률 계산하기

## 구현할 클래스
1. LottoMain
    - 프로그램의 진입점
2. InputView
    - 구입 금액 입력 받는 UI
    - 지난주 당첨 번호 입력 받는 UI
3. ResultView
    - 만들어진 로또를 출력하는 UI
    - 당첨 통계를 출력하는 UI
4. LottoGame
   - 로또 실행 프로그램
   - 책임 (역할)
       - 로또 구입
       - 당첨 결과를 MatchedResult에 저장
       - 수익률 계산
5. Lottery
   - 각 로또(복권) 정보를 관리
   - 책임 (역할)
       - 하나의 복권의 당첨 번호 매칭 개수를 구함
6. Util
   - 로또 공을 shuffle하여 자동으로 로또 번호를 생성
   - 로또 공을 sort하여 로또 번호를 확정
7. WinningLottery
   - 당첨 번호로 생성된 로또 관리
   - 책임 (역할)
      - 사용자에게 입력받은 당첨 번호가 올바른 범위 내에 있는 지 검사
      - 사용자에게 입력받은 당첨 번호를 split
8. MatchedResult
   - 각 복권들의 당첨 결과를 관리
   - 책임 (역할)
       - 각 등수의 당첨 갯수를 구함
       - 총 당첨 금액의 합계를 구함
8. Money
   - 구매 금액 관리
   - 책임 (역할)
       - 입력된 구매 금액의 유효성 판정
       - 입력된 구매 금액으로 살 수 있는 로또 장수 반환
9. Prize
   - 로또 당첨 개수 - 금액 Enum
10. LottoNumber
   - 로또 번호 관리
   - 책임 (역할)
       - 개별 로또 번호가 올바른 범위에 있는지 검사
       - 현재 복권의 숫자와 당첨 번호가 같은지 비교
11. Exception 관련 클래스 (커스텀 예외를 구현)
   - IsInvalidRangeException : 올바른 유효 범위 내에 있지 않은 경우 예외
   - IsLessThanTheMinimumAmountOfMoneyException : 구매 금액이 최소 범위보다 작은 경우 예외
   - NumberMustBeSixException : 당첨 번호가 6개가 아닌 경우 예외

### TDD로 구현하기
#### 1. 1단계 - Util 성격의 기능이 TDD로 도전하기 좋다. (Input과 Output이 명확하기 때문)
- 구입 금액에 맞게 발급한 로또 용지 장수가 일치하는지 확인 (구입 금액에 해당하는 로또 용지 장수를 반환하는가?)
- 입력 받은 구입 금액이 1000원 이상인지 확인
- 당첨 번호가 6개 입력된 건지 확인
- 당첨 번호의 range가 1~45인지 확인
#### 2. 2단계 - 테스트 가능한 부분에 대해 TDD로 도전한다.
- 당첨 번호를 split하여 당첨 번호 객체?를 생성
- 수익률을 계산
- 로또 당첨 여부를 계산

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

