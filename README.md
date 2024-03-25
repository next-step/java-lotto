# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 목록 
- [x] 사용자로부터 로또 구입 금액을 입력받는다.
- [x] 로또를 발급한다.
- [x] 입력받은 구임 금액만큼의 로또를 발급한다. 
- [x] 발급한 로또를 출력한다.
- [x] 사용자로부터 지난 주 당첨 번호를 입력받는다. 
- [x] 3개에서 6개까지 각 일치하는 로또 갯수를 구한다.
- [x] 각 일치하는 로또 갯수를 출력한다.
- [x] 당첨 금액을 구한다.
- [x] 전체 당첨 금액을 구한다.
- [x] 총 수익률을 구한다.
- [x] 총 수익률을 출력한다. 
- [x] 2등을 위한 추가 보너스볼 번호를 입력받는다. 
- [x] 2등 랭킹을 구할 수 있다. 
- [x] 당첨 통계에 2등을 추가하여 출력한다. 
- [x] 수동으로 로또를 생성할 수 있다.
- [x] 수동 갯수를 제외하고 나머지 금액만큼 자동으로 로또를 생성한다.

- 애플리케이션
  - 기능 요구사항 
    - [ ] 입력으로 받은 금액만큼 자동 로또를 발행한다. 
    - [ ] 입력으로 받은 수동 로또와 추가 남은 금액만큼 자동 로또를 더해서 발행한다.
    - [ ] 입력으로 받은 당첨 로또와 비교해 랭킹을 구한다. 
    - [ ] 전체 당첨금을 구한다. 
    - [ ] 수익률을 구한다. 
- Lotto 객체
  - 기능 요구사항 
    - [x] 입력으로 들어온 숫자 리스트를 기반으로 로또를 발행한다.
    - [x] 입력으로 들어온 Lotto 객체와 일치하는 번호의 갯수를 구한다. 
    - [x] 하나의 LottoNumber 가 포함되는지 여부를 확인한다. 
    - [x] 입력으로 들어온 당첨 번호와 보너스 번호를 기반으로 2등인지 확인한다. 
  - 도메인 규칙 요구사항 
    - [x] 로또 번호의 갯수가 6개가 아닌 경우 예외가 발생한다. 
- Lottos 객체 
  - 기능 요구사항 
    - [ ] 전체 로또의 갯수를 구한다. 
    - [ ] 전체 로또 가격을 구한다. 
    - [ ] 입력으로 들어온 로또 갯수를 제외한 나머지 금액만큼의 로또를 생성한다.
- WinningLotto 객체 
  - 기능 요구사항 
    - [ ] 입력으로 들어온 하나의 로또와 비교하여 랭킹을 구한다. 
    - [ ] 입력으로 들어온 여러 개의 로또와 비교하여 전체 랭킹을 구한다. 
- Rank 객체 
  - 기능 요구사항 
    - [ ] 입력으로 들어온 갯수를 기반으로 당첨금을 구한다. 
    - [ ] 일치하는 번호의 갯수를 기반으로 랭킹을 구한다. 
- Ranks 객체 
  - 기능 요구사항 
    - [ ] 특정 랭킹의 갯수를 구한다. 
    - [ ] 전체 당첨금을 구한다. 
    - [ ] 전체 랭킹 갯수를 구한다. 
    - [ ] 수익률을 구한다. 
- LottoNumber 객체 
  - 기능 요구사항 
    - [ ] 1~45 사이 랜덤한 값을 구한다.
  - 도메인 규칙 요구사항 
    - [ ] 1~45 사이의 숫자로만 생성이 가능하다. 