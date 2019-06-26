# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## step1 - 문자열 덧셈 계산기
1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : "" => 0, null => 0)
2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : "1")
3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : "1,2")
4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : "1,2:3" => 6)
5. "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : "//;\n1;2;3" => 6)
6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : "-1,2,3")

## step2 - 로또

### 로또 구매
#### 구매 가능한 로또 개수 계산
1. 0원 미만을 입력할 경우 IllegalArgumentException 을 발생시킵니다. 
2. 1000원 이상을 입력할 경우 입력한 값을 1000원으로 나눈 몫을 반환합니다.
#### 주어진 개수만큼 로또 구매
1. 음수를 입력할 경우 IllegalArgumentException 을 발생시킵니다.
2. 0을 입력할 경우 0개의 로또를 반환합니다.
3. 양수를 입력할 경우 해당 숫자만큼의 로또를 반환합니다.
#### 로또 생성(자동)
1. 로또를 생성하면, 6개의 숫자로 이루어진 Integer Set 을 반환해야합니다.
2. 생성된 로또의 숫자는 중복되지 않아야 합니다.
3. 생성된 로또의 숫자는 1~45 범위 안에 있어야 합니다.

### 로또 당첨 결과
#### 당첨 로또 생성
1. 6개 미만의 숫자를 입력할 경우 IllegalArgumentException 을 발생시킵니다.
2. 6개 초과의 숫자를 입력할 경우 IllegalArgumentException 을 발생시킵니다.
3. 6개의 숫자를 입력했지만 중복되는 숫자가 존재하는 경우 IllegalArgumentException 을 발생시킵니다. 
4. 6개의 숫자를 입력했지만 1보다 작은 숫자가 존재하는 경우 IllegalArgumentException 을 발생시킵니다.
5. 6개의 숫자를 입력했지만 45보다 큰 숫자가 존재하는 경우 IllegalArgumentException 을 발생시킵니다.
6. 6개의 숫자가 모두 1~45 범위 안에 드는 경우 당첨 로또를 반환합니다.
#### 구매한 로또들의 당첨 결과 계산
##### 구매한 로또와 당첨 로또의 일치하는 숫자 개수 계산
1. 구입한 로또와 당첨 로또가 유효하지 않은 경우 IllegalArgumentException 을 발생시킵니다.
2. 구입한 로또와 당첨 로또의 일치하는 숫자 개수를 반환합니다. 
##### 2등 판별 로직 추가
1. 구입한 로또와 당첨 로또의 숫자가 5개 일치하고, 보너스 숫자가 일치하는 경우 2등으로 판단합니다.
2. 구입한 로또와 당첨 로또의 숫자가 5개 일치하고, 보너스 숫자가 일치하지 않으면 기존처럼 5점으로 판단합니다
##### 구매한 로또의 당첨 금액 계산
1. 입력한 점수가 0보다 작으면 IllegalArgumentException 을 발생시킵니다.
2. 한 개도 일치하지 않는 경우 0원을 반환합니다.
3. 한 개 일치하는 경우 0원을 반환합니다.
4. 두 개 일치하는 경우 0원을 반환합니다.
5. 세 개 일치하는 경우 5000원을 반환합니다.
6. 네 개 일치하는 경우 50000원을 반환합니다.
7. 다섯 개 일치하는 경우 1500000원을 반환합니다.
8. 여섯 개 일치하는 경우 2000000000원을 반환합니다.
#### 수익률 계산
1. 투자원금이 0원 이면 IllegalArgumentException 을 발생시킵니다.
2. 수익금이 0원 미만인 경우 IllegalArgumentException 을 발생시킵니다. 
3. 수익금이 0원 이면 0을 반환합니다.
4. 투자원금과 수익금을 입력하면 수익금 / 투자원금의 값을 반환합니다.
