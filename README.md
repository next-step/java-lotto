# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---
## 기능 정의
1. 구입 금액을 입력 받는다.
    - 구입 금액 입력 가이드를 한다.[x]
    - 장 당 가격은 1,000원 [x]
    - 몇개 구매 했는지 가이드[x]

2. 금액에 맞게 로또를 발급함.
    - 로또 번호는 1~45 [x]
    - 갯수에 맞게 겹치지 않는 로또 번호 6개를 발급 [x]
    - 로또 번호는 오름차순으로 정렬 [x]
    - 로또 번호 출력 ex) [8, 21, 23, 41, 42, 43]

3. 지난 주 당첨 번호를 입력 받음
    - 로또 번호는 1~45[x]
    - 중복 확인 필요[x]
    - 6개를 입력 받음[x]
    - 딜리미터는 ","[x] 

4. 발급 받은 로또 들과 지난 주의 로또 비교
    - 발급 받은 로또을 순차적 으로 비교함 [x]
    - 각 몇개 일치 하는 지 확인 [x]
    - 총 수익률 계산 [x]

4. 당첨 통계 출력
    - 3~6개의 각 일치 하는 갯 수를 출력 [x]
    - 수익률 출력 [x]

### 원본
1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
2. 로또 1장의 가격은 1000원이다.

---
## 기능 정의 추가 사항 (로또 2등)
1. 지난 로또 입력 받은 후 보너스 번호를 추가로 입력 받음
   - 보너스 번호를 추가로 입력 받음[x]
   - LottoNumber 활용(1~45 숫자 범위 확인 가능)[x]
   - 보너스 번호와 지난 로또를 비교하여 보너스 번호가 중복되는지 확인[x]
   
2. 2등 여부 판단 로직 필요
   - 당첨 로또에 보너스 번호 있는지 여부 추가[x]
   - LottoRank 가져오는 로직 추가 또는 수정 필요(보너스 번호 아규먼트 추가)[x]

3. 통계에 2등 출력

### 원본
#### 기능 요구사항
1. 2등을 위해 추가 번호를 하나 더 추첨한다.
2. 당첨 통계에 2등도 추가해야 한다.

#### 프로그래밍 요구사항(필요사항 만 작성)
1. java enum을 적용해 프로그래밍을 구현한다. -> LottoRank와 매칭됨.
2. 규칙 8: 일급 콜렉션을 쓴다. -> Lotto, Lottos 객체와 매칭 됨.

---
## 기능 정의 추가 사항 (로또 수동)
1. Controller, LottoGame에서 로또 구매 가능 갯수 로직 분리
   - 기존 amount validation을 이 로직으로 이동
   - 1000원 이하 에러처리, 구매 가능 갯수 리턴

2. InputView에서 수동 구매 로또 수 및 그 수만큼 번호를 입력 받는다.
   - 구입 금액보다 많은지, 정수인지 먼저 확인
   - Lotto를 활용해 로또 번호 유효성 확인.
   - List<Lotto> 로 리턴

3. LottoGame에서 로또 구매시 수동 로또 List<Lotto> 인자 추가
   - 수동 로또 null 체크 필요
   - 수동 + 자동 로또가 더해진 로또 발급

### 원본
#### 기능 요구사항
1. 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
2. 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

#### 프로그래밍 요구사항(필요사항 만 작성)
1. 규칙 3: 모든 원시값과 문자열을 포장한다.
2. 규칙 5: 줄여쓰지 않는다(축약 금지).
3. 예외 처리를 통해 에러가 발생하지 않도록 한다.