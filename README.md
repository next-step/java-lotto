# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### 문자열 덧셈 계산기

1. ADD - test코드 작성
2. ADD - 비즈니스로직 작성
3. fixed
4. Refactor

### 기능 요구사항

+ 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)

+ 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

+ 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.


### 2단계 - 로또(자동)

#### 기능 요구 사항
+ 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
+ 로또 1장의 가격은 1000원이다.

#### 구현할 기능 목록

1. 구입금액 입력
   - 테스트 구현 X
2. 입력 만큼 객체생성
   - [X] Test fails
   - [X] Test Passes
   - [X] Refactor
3. 생성된 객체 수만큼 로또 발급(중복체크)
   - [ ] Test fails
   - [ ] Test Passes
   - [ ] Refactor
4. 당첨번호입력 / 저장
   - [ ] Test fails
   - [ ] Test Passes
   - [ ] Refactor
5. 지난주 당첨번호 입력
   - [ ] Test fails
   - [ ] Test Passes
   - [ ] Refactor
6. 생성된 로또와 지난주 당첨번호 비교
   - [ ] Test fails
   - [ ] Test Passes
   - [ ] Refactor
7. 당첨 통계로직 (몇개가 맞았는지에 따라 분기)
   - [ ] Test fails
   - [ ] Test Passes
   - [ ] Refactor
8. 당첨 통계 뷰
   - [ ] Test fails
   - [ ] Test Passes
   - [ ] Refactor
9. 수익률 계산로직
   - [ ] Test fails
   - [ ] Test Passes
   - [ ] Refactor
10. 수익률 뷰
   - [ ] Test fails
   - [ ] Test Passes
   - [ ] Refactor
11. 최종 ResultView
   - 테스트 구현 X  
