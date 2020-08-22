# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기
#### 기능 목록
- [x]  기본 구분자(쉼표, 콜론)를 가지는 문자열을 구분자 기준으로 분리한다.
- [x]  문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- [x]  분리한 각 숫자를 더한다.
- [x]  숫자 이외의 값 또는 음수가 들어올 경우 RuntimeException을 throw한다.

## 로또
#### step02 :: 기능 목록 
- [x] 로또 구입 금액을 입력받는다.
- [x] 구입 금액만큼 로또를 발급한다.
- [x] 1~45번 중 여섯 개의 랜덤한 로또 번호를 추출한다.
- [x] 당첨 번호를 입력받는다.
- [x] 당첨 번호와 일치 개수에 따라 당첨 통계를 낸다.
- [x] 구입 금액과 당첨 금액을 비교해 수익률을 낸다.
- [x] 발급한 로또를 출력한다.
- [x] 당첨 통계와 수익률을 출력한다.

#### step03 :: 기능 목록
- [X] 추가 번호를 입력받는다. (보너스볼)
- [X] 2등을 추가한다. (5개 일치, 보너스 볼 일치)
- [X] 당첨 통계에 2등을 추가한다.