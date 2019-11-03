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

### EarningsRateCalculator

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

calculator.calculate(List Lotto)

# Step3

## next-step에서 정해준 요구사항

- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

## 로또 2등 구현을 위해 고민할 포인트

- 우리가 로또 결과를 확인할 때 '6개의 당첨 번호 + 보너스 번호'를 한번에 확인할까
- 아니면 '6개의 당첨 번호'를 먼저 확인하고 5개가 일치한 로또만 보너스 숫자를 추가로 확인할까 

로또를 한 번도 안사봐서 모르겠지만 로또를 산다면 두 번째 방법으로 확인할 듯 하다


## TDD 적용을 위한 구체적인 기능 추려보기

> 보너스 결과를 확인하는 기능

person.checkBonusLotteries( Integer )를 하면 가지고 있는 5개일치 로또들이 보너스 번호를 가지고 있는지 확인 \ 
테스트 코드는 lotto 로직을 테스트

## 기존의 로직과 달라질 예상 부분
- `LottoPrize`에 SECOND_BONUS가 추가되어야 함
- `LottoPrize`에 새로운 필드가 추가되어야 함 `bonusCount`
- 이렇게 되면 `LottoPrize`에 있는 count 필드 2개를 하나로 묶은 객체를 만드는 편이 좋을듯

## 일급 컬렉션을 적용할 부분

- Person 안의 lotteries에 적용 가능
- Lotto 안의 numbers를 적용 가능 (Lotto의 status가 사라지며 Lotto가 사실상 일급 컬렉션 역할을 하게 됨)