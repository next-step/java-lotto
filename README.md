# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록

[StringCalculator]
[x] , 또는 : 을 구분자로 가지는 문자열을 입력 받는다.
[x] Null이나 빈 문자열을 입력할 경우 0을 반환한다.
[x] 숫자 하나를 입력할 경우 해당 숫자를 반환한다.
[x] // 과 \n 를 모두 가지는 문자열이 들어오면 그 사이 문자를 구분자로 판단해서 입력 받는다.
[ ]// 과 \n 중 하나만 들어올 경우 Illegal Exception을 throw한다. [ERROR]  //, \n
[ ]// 과 \n 을 사용 시 그 사이에 커스텀 문자가 없을 경우 Illegal Exception을 throw 한다.
[ ]// 과 \n 을 사용하여 커스텀 구분자를 생성할 경우 \n 뒤의 문자열에 커스텀 구분자와 숫자 외의 문자열이 있으면 Illegal Exception을 throw한다.
[x] 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

[Lotto]
[x] 구입 금액을 통해 로또 개수 알기
    [x] 구입 금액 입력받기 InputView
    [x] 1000원 미만의 금액일 경우 예외처리
[x] 로또 생성 
    [x] 구입 개수 알기
    [x] 구입 개수 콘솔에 출력하기
    [x] Lotto 클래스 생성
        [x] 중복되지 않고 6개의 랜덤 숫자인지 확인
    [x] 1부터 45까지 범위에 속하는 로또 넘버 List를 생성
    [x] 랜덤으로 shuffle해서 구입 개수만큼 List<Lotto> 생성
    [x] 로또 번호들 sort해서 반환 - 생성된
    
[x] 지난 주 당첨 번호 입력 
    [x] 당첨번호를 의미하는 WinningBall 클래스 생성
    [x] 당첨 번호 6개 입력받기 InputView 
    [x] 보너스 번호도 함께 입력받기
    [x] WinningBall List 생링

[ ] 당첨 통계
    [x] Enum으로 LottoResult 생성 (일치 개수, 보너스 여부, 상금, 설명)
    [ ] WinningBalls(당첨번호)를 순회허면서 contains로 당첨 개수 세기 - WinningCounter
[ ] 상금 / 구매금액 을 통해 수익률 계산 - 소수점 아래 둘째자리까지 남기고 버림
