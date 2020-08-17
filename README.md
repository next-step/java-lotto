# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## STEP01 문자열 덧셈 계산기
### 기능 요구사항
- [x] ',' ':' 로 구분된 숫자 문자열을 받아 숫자들의 합을 구한다. ex) 1:2:3 -> 6
- [x] 커스텀 구분자 사용 가능하다 '//'와 '\n' 사이에 커스텀 구분자 입력가능. ex) //$\n1$2$3 -> 6
- [x] 빈문자열 or null이 들어오면 return 0
- [x] 숫자가 들어와야하는 곳에 숫자 이외의 문자가 들어오면 Runtime Exception.
- [x] 음수가 들어오면 Runtime Exception
- [x] 숫자가 1개면 그 숫자 return

step01 pr : https://github.com/next-step/java-lotto/pull/708

## STEP02 로또(자동)
### Todo
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다. (로또 1장의 가격은 1000원 이다.)
- [x] 로또번호를 생성한다. (로또 번호는 1~45의 중복되지않는 6개의 숫자이다.)
- [x] 당첨 번호를 입력받아 당첨 통계를 구해 출력한다. 
- [x] 수익률을 구해 출력한다.

step02 pr : https://github.com/next-step/java-lotto/pull/724

## STEP03 로또(2등)
### Todo
- [] 2등을 위해 추가 번호를 하나 더 추첨한다.
- [] 당첨 통계에도 추가되어야 한다.
