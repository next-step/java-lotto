# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## TODO 기능 요구사항
* [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
* [x] 사칙연산 메소드가 있는 계산기 구현
* [x] 사칙연산 메소드가 있는 계산기 테스트
* [x] 나눗셈 0으로 나눴을 경우 IllegalArgumentException throw 
* [x] 입력 문자열을 공백으로 SPILT 구분 구현
* [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw

## TODO LOTTO(자동) 요구사항
* [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
* [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* [x] 로또 1장의 가격은 1000원이다.
* [x] 발급 장수 만큼 로또 자동생성
* [x] 로또 번호는 1~45까지 임.
* [x] 지난 주 당첨 번호 입력받기
* [x] 입력받은 당첨 번호 비교 하기
* [x] 3개일치 , 4개일치, 5개일치, 6개일치 별로 당첨금액 및 개수 enum class 이용
* [x] 수익률계산하기. 손해 및 이익 문구 
# feedback ^^
* [x] 로또 최소금액 1천원 체크 
* [x] 들여쓰기 1 규칙 지키기 수정
* [x] 로또 숫자는 1~45까지니깐 1번 생성해서 재사용하기.
* [x] 로또와 관련된 validation 은 Lotto 객체에서 관리한다.
* [x] 당첨번호도 Lotto 객체다. + 일치 메소드 만들기.
* [x] rank 숫자에 _ 를 넣어 가독성 높이기
* [x] 테스트코드 for문 제외, LottoTest 완성하기.