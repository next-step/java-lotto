# 1단계 - 학습 테스트 실습
## 1. 요구사항 정의
### 1.1. String 클래스에 대한 학습 테스트
#### 1.1.1. 과제 진행 요구사항
|요구사항|힌트|
|:---|---|
|• "1,2"을 `,`로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.<br>• "1"을 `,`로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.|• 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.<br>• 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.|
|• "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 `()`을 제거하고 "1,2"를 반환하도록 구현한다.| |
|• "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.<br>• String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.<br>• JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.|• **_1.1.2. 참고_** 내용 확인|

#### 1.1.2. 참고
• [AssertJ Exception Assertions](https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion) 문서 참고
```java
import static org.assertj.core.api.Assertions.*;

assertThatThrownBy(() -> {
    // ...
}).isInstanceOf(IndexOutOfBoundsException.class)
  .hasMessageContaining("Index: 2, Size: 2");
```
```java
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

assertThatExceptionOfType(IndexOutOfBoundsException.class)
  .isThrownBy(() -> {
      // ...
}).withMessageMatching("Index: \\d+, Size: \\d+");
```
- 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
    - assertThatIllegalArgumentException()
    - assertThatIllegalStateException()
    - assertThatIOException()
    - assertThatNullPointerException()
      <br><br>

### 1.2. Set Collection에 대한 학습 테스트
#### 1.2.1. 과제 진행 요구사항
- 다음과 같은 Set 데이터가 주어졌을 때 요구사항을 만족해야 한다.
```java
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    // Test Case 구현
}
```
|요구사항|힌트|
|:---|---|
|• Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.| |
|• Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.<br>• 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.<br>• JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.<br>• **_1.2.2.1. 요구사항2 코드_** 확인|• **_1.2.2.2. 요구사항2 힌트_** 확인|
|• 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.<br>• 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.|• **_1.2.2.3. 요구사항3 힌트_** 확인|

#### 1.2.2. 참고
##### 1.2.2.1. 요구사항2 코드
```java
@Test
void contains() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
}
```
##### 1.2.2.2. 요구사항2 힌트
- [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
```java
@ParameterizedTest
@ValueSource(strings = {"", "  "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
```
##### 1.2.2.3. 요구사항3 힌트
- [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5) 문서에서 @CsvCource를 활용한다.
```java
@ParameterizedTest
@CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
    String actualValue = input.toLowerCase();
    assertEquals(expected, actualValue);
}
```
<br>

### 1.3. assertj 활용
#### 1.3.1. 과제 진행 요구사항
|요구사항|힌트|
|:---|---|
|• [Introduction to AssertJ](https://www.baeldung.com/introduction-to-assertj) 문서 참고해 assertj의 다양한 활용법 익힌다.| |

### 1.4. 코드리뷰 요청 및 피드백
- 실습을 끝내면 [코드 리뷰 1단계](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step1.md) 문서의 7단계, 8단계를 참고해 자신의 저장소에 push한다.
- 온라인 코드리뷰 요청 1단계 동영상<br>
[![온라인 코드리뷰 요청 1단계 동영상](https://img.youtube.com/vi/YkgBUt7zG5k/0.jpg)](https://www.youtube.com/watch?v=YkgBUt7zG5k)
  
- 코드 리뷰 2단계 문서를 참고해 코드 리뷰 요청(pull request)을 보내고, NextStep 우측 상단의 Github 아이콘을 클릭해 리뷰 요청을 보낸다.
- 피드백 또는 merge 될 때까지 기다린다.
> PR에 대한 수정 요청을 받아 코드를 수정하는 경우 새로운 PR을 보낼 필요가 없다.<br>
코드를 수정한 후 add/commit/push만 하면 자동으로 해당 PR에 추가된다.

- 온라인 코드리뷰 요청 2단계 동영상<br>
  [![온라인 코드리뷰 요청 2단계 동영상](https://img.youtube.com/vi/HnTdFJd0PtU/0.jpg)](https://www.youtube.com/watch?v=HnTdFJd0PtU)

### 1.5. 다음 단계 미션 진행을 위한 준비
- Slack을 통해 merge가 되는지 확인한 후에 코드 리뷰 3단계 과정으로 다음 단계 미션을 진행한다.
- 온라인 코드리뷰 요청 3단계 동영상<br>
  [![온라인 코드리뷰 요청 3단계 동영상](https://img.youtube.com/vi/fzrT3eoecUw/0.jpg)](https://www.youtube.com/watch?v=fzrT3eoecUw)

## 2. 분석 및 설계
### 2.1. 이번 Step 핵심 목표
- TDD (Test-Driven Developmet) : production code보다 test code를 먼저 작성한다.
> Cycle : Test Fail ---> Test Passes ---> Refactor ---> Test Fail ---> ...

### 2.2. Todo List
- [x] 0.기본 세팅
    - [x] 0-1.git fork/clone
    - [x] 0-2.요구사항 정리
    - [x] 0-3.AngularJS Commit Message Conventions 참고
- [ ] 1.자바 코드 컨벤션을 위한 세팅
    - [ ] 1-1.gradle-editorconfig 적용
    - [ ] 1-2.gradle-checkstyle 적용
    - [ ] 1-3.IntelliJ 적용
    - [ ] 1-4.Github 적용
- [x] 2.학습
    - [x] 2-1.[AssertJ Exception Assertions](https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion) 문서 참고
    - [x] 2-2.[Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
    - [x] 2-3.[Introduction to AssertJ](https://www.baeldung.com/introduction-to-assertj) 문서 참고
    - [x] 2-4.[온라인 코드리뷰 요청 1단계 동영상](https://www.youtube.com/watch?v=YkgBUt7zG5k)
    - [ ] 2-5.[온라인 코드리뷰 요청 2단계 동영상](https://www.youtube.com/watch?v=HnTdFJd0PtU)
    - [ ] 2-6.[온라인 코드리뷰 요청 3단계 동영상](https://www.youtube.com/watch?v=fzrT3eoecUw)
- [x] 3.분석 및 설계
    - [x] 3-1.Step01.md 작성
- [ ] 4.구현
    - [ ] 4-1.String 클래스에 대한 학습 테스트
        - [ ] 4-1-1.split() 
        - [ ] 4-1-2.assertj : contains(), containsExactly() 
        - [ ] 4-1-3.substring() : `()`제거
        - [ ] 4-1-4.charAt()
        - [ ] 4-1-5.StringIndexOutOfBoundsException Test Code
        - [ ] 4-1-6.@DisplayName 활용
    - [ ] 4-2.Set Collection에 대한 학습 테스트
        - [ ] 4-2-1.size()
        - [ ] 4-2-2.contains()
        - [ ] 4-2-3.JUnit : ParameterizedTest
        - [ ] 4-2-4.JUnit : CsvSource
- [ ] 5.테스트
    - [ ] 5-1.Gradle build Success 확인
    - [ ] 5-2.checkstyle 문제없는지 확인
- [ ] 6.인수인계
    - [ ] 6-1.코드리뷰 요청 및 피드백
    - [ ] 6-2.Slack을 통해 merge가 되는지 확인한 후에 코드 리뷰 3단계 과정으로 다음 단계 미션을 진행    