# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 문자열 덧셈 계산기 기능 명세
- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
  - [x] 문자열을 input 으로 반환 -Number
  - [x] input 문자열을 쉼표(,) 또는 콜론(:)으로 분리 -Separator
  - [x] 구분자를 제외하면 나머지 값은 숫자 -Number 
  - [x] 분리한 숫자의 합을 반환 -Number
  - [x] 문자열이 공백 혹은 null 일경우 0으로 반환
- [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있음 -Separator
  - [x] 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용 -Separator
  - [x] 정규표현식 관련 커스텀 구분자인 경우(., 괄호 등) \\(역슬래시 2개) 를 추가한다.
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 


# 로또 기능 명세
- [ ] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
  - [x] 사용자는 로또 구입 금액을 입력한다. - InputView
    - [ ] 금액은 숫자 형태여야 한다. (ex. 14000)
    - [ ] 원하는 형태가 아니면 다시 입력을 받는다.
  - [x] 입력한 금액에 맞게 로또 를 발급한다.(로또 1장 가격 : 1000원) - LottoTickets
  - [x] 구입한 로또 장 수 만큼, 로또 번호를 랜덤으로 발급한다.(번호는 6개이다.) - Lotto, LottoTickets
- [x] 사용자는 '지난주 당첨 번호' 를 입력한다. - InputView
- [x] 사용자는 '보너스 볼' 을 입력한다. - InputView
- [x] 당첨 통계를 출력한다. - ResultView
  - [x] 당첨 개수 별 금액을 계산한다. 
  - [x] 당첨 번호를 3 ~ 6개 맞춘 장 수를 각각 출력한다.
  - [x] 수익률을 계산한다.
  - [x] 수익률을 출력한다.


## 각 Class 마다 역할?

### User
  - 돈, 로또 구입 장 수
  - 당첨 통계
  - 수익률

### InputView  
  - '지난주 당첨 번호' 를 입력받는다.
  - '보너스 볼' 을 입력받는다.


### ResultView 
  - 당첨 통계를 출력한다.
  - 수익률을 출력한다.


### Lotto
  - 사용자 로또 번호(6자리)를 가지고 있음
  - 내가 몇 개 맞췄는지
  - <자동> 6자리 랜덤 숫자 생성
  - 내가 몇 개 맞췄는지
  

### LottoTickets
  - 로또 장 당 가격을 가지고 있음
  - 전체 수익률
  - Lotto Instance 여러 개


#### LottoMachine(토요일 8시 40분)
 - 지난 주 당첨 번호
 - 보너스 볼
 - 사용자 로또 번호와 비교해서 맞춘 갯수를 return
 