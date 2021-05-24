# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 학습 테스트 실습 요구사항
### String 클래스에 대한 학습 테스트
- [x] 요구사항 1
  - [x] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
  - [x] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
  - 힌트
    - 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
    - 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
- [x] 요구사항 2
  - [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
- [x] 요구사항 3
  - [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
  - [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.

### Set Collection에 대한 학습 테스트
- [x] 요구사항 1
  - [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
- [x] 요구사항 2
  - [x] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
  - [x] 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다. JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
- [x] 요구사항 3
  - [x] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다. 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

### 기타
- [x] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

## 2단계 - 문자열 덧셈 계산기 기능 요구사항
- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
  - [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
  - [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
  - [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
  - [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
- [x] 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
  - [x] “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
- [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
  - [x] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
  - [x] 숫자가 아닌 문자를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “1,ㄱ,3”)
- [x] 원시값에 제약조건이 있으므로 PositiveNumber라는 포장객체로 정의하자
  - [x] 문자열로부터 PositiveNumber 객체를 만드는 정적 메서드 정의
  - [x] 정적 메서드 입력 텍스트가 양수가 아닌 값이 들어올 경우 예외 발생
  - [x] 두 개의 PositiveNumber를 더하는 정적 메서드 정의

## 3단계 - 로또(자동)
- [x] 로또 하나
  - [x] 입력받은 리스트의 숫자 갯수가 6인지 확인
  - [x] 입력받은 리스트의 Distinct 숫자 갯수가 6인지 확인
  - [ ] 당첨 번호와 숫자가 몇 개 일치하는지 확인
- [x] 로또 유틸
  - [x] 1~45가 있는 컬렉션 shuffle
  - [x] 앞에서 0~5번째 원소 가져오기
- [ ] 로또 여러개
  - [ ] 금액만큼 로또 발급
- [ ] 금액 입력
- [ ] 당첨번호 입력
- [ ] 결과 집계
- [ ] 당첨결과 출력
  - [ ] 수익률 계산
