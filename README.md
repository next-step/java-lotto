# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기 구현 기능
#### 입력된 문자열 유효성체크 
* [X] null, 빈값 입력 시, 0을 반환한다.
* [X] 숫자 하나 입력 시, 입력한 숫자를 반환한다. 
* [X] 음수 입력 시, RuntimeException이 발생한다. 
* [X] 숫자 아닌 문자열 입력시 IllegalException 발생한다. 

#### 계산 및 로직 
* [X] 문자열 구분자 설정 기능
* [X] 문자열 분리 기능 (설정된 구분자에 따라 분리)
* [X] 문자열 MetaCharacter가 구분자로 입력되어도 분리되도록 구현

* [X] 덧셈 계산 기능

## 실패하는 단위 테스트
* [X] 덧셈 기능 (Integer List를 넘기면 담긴 값들의 합이 반환된다.)
* [X] 입력값이 숫자인지 확인 기능 (util)
* [X] null, 빈값 입력 확인 기능 (util)
* [X] 문자열 -> 숫자 변환 기능 (util)

* [X] 음수 입력 확인 기능 
* [X] null, 빈값 입력 시, 0을 반환한다.
* [X] 숫자 하나 입력 시, 입력한 숫자를 반환한다. 
* [X] 음수 입력 시, RuntimeException이 발생한다. 

* [X] 문자열 구분자 커스텀 구분자 여부 확인
* [X] 문자열 구분자 설정 확인
* [X] 문자열 분리 기능(기본 분리 ",", ":")
* [X] 문자열 분리 기능(커스텀 분리)

## 2단계 로또 (자동)
#### view
* [X] 입력 기능 (구매금액, 지난 당첨번호)
* [X] 출력 기능 (구매개수, 로또 번호, 당첨 통계)

#### 
* [X] 구입 금액 유효성 검사 (로또 1장의 가격 1000원 이상, 숫자)
* [X] 구매 개수만큼 로또 번호 생성 (구매개수 * 로또 번호 6개)
* [X] 당첨 번호 유효성 검사 (번호 개수, 숫자)
* [X] 당첨 번호에 따른 당첨 통계 계산 기능
* [X] 각 로또별 번호 일치 개수 
* [X] 수익률 계산
* [X] 수익률 결과 (손해, 이익)

## 3단계 로또 (2등)
#### view
* [X] 보너스 번호 입력 기능 
* [X] 2등 출력 기능

#### 
* [X] 보너스 번호 유효성 체크(숫자, 범위, 중복)
* [X] 보너스 번호 일치 여부 확인
* [X] 2등 생성

## 4단계 로또 (수동)
#### view
* [X] 수동 구매수 입력 기능 
* [X] 로또 수동 구매 번호 입력 기능
* [ ] 로또 구매수 (자동/수동 동시) 출력 기능 

#### 
* [X] 수동 로또 생성 기능
* [ ] 자동/수동 로또 병합