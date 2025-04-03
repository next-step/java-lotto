# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## To-Do
### 1단계
- [x] 기본 기능 구현
  - [x] 덧셈 구현
  - [x] 뺄셈 구현
  - [x] 곱셈 구현
  - [x] 나눗셈 구현
- [x] 예외 처리 구현
  - [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
  - [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [x] 여러 개의 연산 처리 구현
- [x] 계산식 검증 구현
- [x] Views 구현
  - [x] InputView 구현
  - [x] ResultView 구현
### 2단계
- [x] 핵심 기능 구현
  - [x] 로또 구입 금액에 해당하는 로또 발급
    - [x] 기능 구현
    - [x] 예외 처리 구현
      - [x] 로또 구입 금액이 1000원 단위가 아닌 경우 IllegalArgumentException throw
      - [x] 로또 구입 금액이 0원 이하인 경우 IllegalArgumentException throw
    - [x] 리팩토링
  - [x] 로또 생성
    - [x] 조건에 맞는 무작위 번호 생성 구현
  - [x] 당첨 번호 구현
    - [x] 당첨 여부 확인 구현
    - [x] 등수 구현
  - [x] 당첨 통계 구현
    - [x] 통합 통계 구현
    - [x] 당첨금 계산
  - [x] 통계 구현
  - [x] 게임 진행 구현
  - [x] 리팩토링
- [x] Views 구현
  - [x] InputView 구현
  - [x] ResultView 구현
- [x] Controller 구현
  - [x] 리팩토링
- [x] 피드백
  - [x] Lotto 생성 시 검증 추가
  - [x] WinningLotto.countMatchedNumbers 파라미터 수정
  - [x] LottoGenerator 이름 변경
  - [x] LottoFactory 제거 후 Lotto에 정적 팩토리 메서드 도입
  - [x] MatchedCount equals 및 hashCode 구현
  - [x] Rank.displayRank 변경
  - [x] toString 대신 String 반환 메소드 생성
  - [x] LottoGameResult에서 winningRate 계산하도록 변경
### 3단계
- [x] 2단계 피드백
  - [x] LottoGameApplication 상수 적용
  - [x] LottoContainerFormatter 패키지 위치 조정
  - [x] Rank 객체가 RankFormatter 객체를 의존하지 않도록 변경
  - [x] LottoGameApplication 에서 ResultView 에게 결과 출력 메시지를 전달
- [x] 보너스 볼 추가
  - [x] 보너스 볼을 포함한 등수 계산
    - [x] 리팩토링
  - [x] 보너스 볼을 입력받아 당첨 통계에 추가
- [x] 피드백
  - [x] '\n' 대신 System.lineSeparator() 사용
  - [x] 로또 번호 정렬
  - [x] 로또 번호 중복 입력 검증
  - [x] 로또 번호와 보너스 번호가 겹치는 상황 검증
  - [x] domain 에서 views 의존성 제거
    - [x] Lotto
    - [x] LottoContainer
### 4단계
- [x] 3단계 피드백
  - [x] LottoGenerator
    - [x] 정렬 책임 분리
    - [x] 번호 캐싱
  - [x] Lotto 정적 팩토리 메소드로 주 생성자 호출
- [ ] 로또 수동 입력 구현
  - [x] LottoContainer 합치기
  - [x] LottoCount 에 manualLottoCount 추가
  - [ ] LottoCount 리팩터링
    - [x] PurchaseAmount 분리
    - 
  - [ ] 사용자에게 수동 입력 받기