# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현 기능 목록

### step 1 - 문자열 덧셈 계산기
- [ ] 빈 문자열 또는 null 값을 입력할 경우 0을 반환
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [ ] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [ ] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [ ] 구분자를 컴마(,) 이외에 콜론(:)을 사용 가능
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [ ] “//”와 “\n” 문자 사이에 커스텀 구분자를 지정 가능
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [ ] 음수를 전달할 경우 RuntimeException 예외가 발생
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [ ] 분할된 각 입력값을 객체(Element)로 분할
    - [x] TEST - 정수로 Element 생성
    - [x] TEST - 문자열로 Element 생성
    - [x] TEST - 음수값 전달될 경우 RuntimeException 발생
    - [x] TEST - 숫자 아닌 값 전달될 경우 RuntimeException 발생
    - [x] REFACTORING
- [ ] Element의 일급 컬렉션(Elements) 생성
    - [x] TEST - Elements를 List로 생성
    - [x] TEST - 요소들의 합을 구하는 메서드 추가
    - [x] REFACTORING
- [ ] 입력값 분할하는 메서드를 객체(StringSplitter)로 분할
    - [x] TEST - StringSplitter 생성
    -