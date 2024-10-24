# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## STEP1: 기능 목록 
* 계산기 기능 추가
  - [x] 덧셈("+") :
  - [x] 뺄셈("-") :
  - [x] 곱셈("*") :
  - [x] 나눗셈("/") :

* 입력한 문자열(산식) 검증 
  - [x] 산식 검증(숫자로시작숫자로종료)
  - [x] 산식 패턴 검증(입력 산식 split 후 홀수자리 token은 연산자, 짝수자리는 피연산자숫자)

## STEP2: 기능 목록 

* 로또 등수 관리 (LottoRankingEnum)
  -[x] : 등수별 당첨금 관리
  -[x] : 등수별 매치갯수 관리
* 로또 객체 (Lotto)
  -[x] : 로또 당첨 등수 조회 (당첨금은 등수Enum에서 조회가능)
  -[x] : 생성된 로또 번호 검증 (6자리 , 1-45 번호 여부, 중복 여부)
* 로또 구매자 (Buyer)
  -[X] : 입력 건수 만큼 로또(Lotto) 생성
  -[x] : 당첨 통계 조회
  -[X] : 수익금액 조회
* 로또 번호 생성 기능 추가
 - [x] : 자동 로또 번호 생성
* InputView
  -[x] : 구매금액 입력
  -[x] : 지난 회차 당첨번호 입력 
* OutputView
  -[x] : 구매 내역 출력 
  -[x] : 통계 출력

## STEP4 : 기능 목록 
* 로또 건수 관리 기능 (입력한 총금액, 자동 로또 건수)  
- [x] : 로또 구매 총 건수 
- [x] : 로또 자동 구매 건수 
- [x] : 로또 구매 총 금액 
- [x] : 건수 검증(수동건수 < 총건수)

* InputView - 수동 로또 번호 입력 반영 
- [x] : 수동 로또 번호 입력 기능  + exception 처리


* ManualLottoNumberGenerator 수동 로또 생성 기능 추가 
- [x] : 입력받은 수동 로또 번호로 로또 생성 
* MixLottoNumberGenerator 수동 로또 생성 기능 추가
- [x] : 자동 & 수동 복합 생성 
