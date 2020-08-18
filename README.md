# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)



## 1단계 문자열 덧셈 계산기
#### 기능 요구사항

- [X] 기본 구분자로 문자열 분리
* 기본 구분자는 쉼표(,) 또는 콜론(:)

- [X] 커스텀 구분자로 문자열 분리
* 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자

- [X] 분리된 문자를 숫자로 변환 (숫자가 아니거나 음수인 경우 RuntimeException 예외를 throw)
- [X] 숫자의 합을 구함

- [X] 빈 문자열 또는 null 값을 입력할 경우 0을 반환
- [X] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
- [X] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있음


## 2단계 로또(자동)
#### 기능 요구사항

- [ ] 로또티켓을 로또가게에서 구입한다.
* 구입금액이 14000이면 14개 구매
* 로또 티켓은 한장의 가격은 1000원
* 구입금액이 0이거나 음수면 IllegalArgumentException 예외 발생
* 구입금액이 1000원으로 나눠지지 않으면 illegalArgumentException 예외 발생

- [X] 로또머신에서 로또번호를 생성
* 로또번호는 1~45 사이의 중복없는 6개 숫자

- [ ] 로또티켓 구입시 머신에서 생성한 로또번호로 로또티켓을 발행
- [ ] 구입한 로또번호를 출력한다.

- [ ] 로또게임에서 당첨번호를 6개 입력 받는다.
* 당첨번호를 6개 입력하지 않았을 경우 IllegalArgumentException 예외가 발생
* 당첨결과에서 3개가 매칭되면 3을 반환
* 당첨결과에서 4개가 매칭되면 전체 상금에 50000원이 추가됨
* 3개-5000원, 4개-50000원, 5개-1500000원 6개-2000000000원

- [ ] 3개가 2번 매칭되었을 때 상금 10000원의 당첨결과를 반환
 
- [ ] 수익률을 계산
* 수익률 = 로또 상금/ 로또 구입 금액
- [ ] 당첨결과와 수익률을 출력한다.
