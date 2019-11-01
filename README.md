# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# Step1

## 문자열 덧셈 계산기

### next-step에서 정해준 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 추가적으로 정의한 요구사항
- 추가 구분자는 숫자가 아니다
- 정수를 받지 않는다
- View에 대한 요구사항이 없으므로 도메인만 TDD로 구현한다

# Step2

## next-step에서 정해준 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 추가적으로 정의한 요구사항
- 로또를 사고 남는 돈이 있는 경우 아래와 같이 출력한다.
> N개를 구매했습니다. OOO원이 남았습니다.
- 잘못된 금액을 입력한 경우 아래의 문구를 포함한 에러 메시지를 출력하며 프로그램을 종료한다.
> 금액을 확인해주세요
- (기준이 1이기 때문에 결과적으로 손해라는 의미임)은 출력하지 않는다

## TDD 적용을 위한 구현 시작 전의 모델링

### Lotto

로또를 표현한 객체 \
6개의 숫자를 가지고 있다.

### LottoCreator

로또를 뽑는 객체 \
로또를 만들어준다.

### LottoPrize

로또의 당첨 정보를 가지고 있는 객체 \

### Person

로또를 사는 객체 \

### Calculator

로또 결과를 계산해주는 객체 \
사람이 계산하기엔 머리에 한계가 있으니 계산기를 쓰자

## TDD 적용을 위한 구체적인 기능 추려보기

> 로또를 사는 기능

(private) person.buyLotto( )를 하면 돈과 로또가 교환되어야 한다 \
person.buyLottoWithAllMoney( )를 하면 가능한 모든 돈이 로또로 교환되어야 한다

> 로또가 생성되는 기능

lottoCreator.create( )를 하면 로또가 생겨야 한다. \
이때 로또는 중첩되지 않은 6자리 숫자여야 한다.

> 결과를 확인하는 기능

lotto.examine(List Integer)를 하면 해당 로또에 대한 LottoPrize가 기록된다

> 총 수익률 계산하기

calculator.calculateReturn(List Lotto)