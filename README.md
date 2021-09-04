# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH 한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

--- 
## 2단계 - 로또(자동)
### 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### TODO
- LottoApplication
  - ~~구입 금액 입력~~
  - ~~금액(1000원) 기준으로 split~~
  - ~~input value~~
    - ~~in : 금액 / out 갯수~~
  - ~~개수 출력~~ 
  - ~~m: lotto 발행 (int 갯수 / out Lottos ?)~~
- Lotto 객체
  - ~~@toString \`[lottoNumbers]`~~
    - LottoNumbers
      - ~~생성자: 디폴트 -> 자동 숫자 생성~~
        - ~~1~45 숫자 shuffle 로 생성~~
      - ~~생성자: 숫자 배열 -> 수동 생성~~
      - m: 일치하는 숫자 out: 일치하는 갯수? 
      - ~~LottoNumber~~
        - ~~생성시 로또 숫자 조건 (exception)~~
- LottoApplication
  - 지난 주 당첨 번호 입력
    - in: 숫자 목록 / out: split 한 숫자 
- 당첨 객체 
  - 생성자: split 한 숫자 목록
    - LottoNumbers 수동 생성 
  - m: 당첨 통계 (in Lottos / out 통계 객체)
    - LottoNumbers.일치하는 숫자
      - 여기 결과값을 어떻게 3,4,5,6으로 나눌까 ?
  - 통계 객체
    - ... 
    - out 수익 금액 
- LottoApplication
  - 통계 객체 출력
  - 수익률 계산

---

## 1단계 문자열 계산기
### 기능 요구 사항
- ~~입력값 String 을 기본 구분자(, :)로 나누어 받음~~
- ~~커스텀 구분자 지정 가능 (// \n)~~
- ~~숫자 이외 or 음수 전달 시 RuntimeException throw~~
- ~~덧셈 연산~~
- ~~빈문자 > 0 반환~~
- ~~숫자 하나 > 숫자 반환~~ 