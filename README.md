# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## step1 요구사항 분석
1. 문자열을 받아서 공백으로 split
2. 연산자에 따라 어떤 계산별 메서드 작성
3. 주어진 순서대로 계산 반복

## 🚀 2단계 - 로또(자동)
* [] 로또 구입 금액을 입력 UI 클래스(InputView) 생성
* [] Controller View에서 int만 금액을 입력받을 수 있도록 구현 / catch로 exception 처리
* [] 입력받은 금액을 1000 단위로 나눠서 몫 구하는 클래스 작성 (getPlayRounds) / 테스트 코드 작성
* [] 로또 class 생성하여 생성자를 통해 Set 자료형으로 6개의 랜덤 번호를 갖고있도록 구현 / 테스트 코드 작성
* [] 로또 class에서 중복되는 숫자 없이 총 6개의 번호가 내림차순으로 정렬될 수 있도록 구현 / 테스트 코드 작성
* [] PlayLotto 클래스 작성, 전달된 횟수만큼 로또를 생성하는 메서드 구현 / 테스트 코드 작성
* [] InputView에서 지난 주 당첨 번호를 입력 받는 메서드 작성
* [] 로또 class에서 전달받은 당첨번호와 갖고있는 로또 번호가 일치하는 숫자가 몇개인지 반환하는 메서드 구현 / 테스트 코드 작성
* [] 수익률을 구하는 클래스(ReturnRate) 생성, enum으로 일치하는 숫자에 따른 보상이 얼마인지 작성
* [] 수익률을 구하는 함수 생성 : 당첨된금액/구입한 금액 소수점 2자리까지
* [] 수익률을 출력하는 UI클래스 생성 (ResultView)
* [] ControllerView에서 로또 게임을 실행하고 수익률을 출력하도록 구현
