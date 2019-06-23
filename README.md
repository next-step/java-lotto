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
- [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용 가능
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [x] “//”와 “\n” 문자 사이에 커스텀 구분자를 지정 가능
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [x] 음수를 전달할 경우 RuntimeException 예외가 발생
    - [x] TEST FAIL
    - [x] TEST PASS
    - [x] REFACTORING
- [x] 분할된 각 입력값을 객체(Element)로 분할
    - [x] TEST - 정수로 Element 생성
    - [x] TEST - 문자열로 Element 생성
    - [x] TEST - 음수값 전달될 경우 RuntimeException 발생
    - [x] TEST - 숫자 아닌 값 전달될 경우 RuntimeException 발생
    - [x] REFACTORING
- [x] Element의 일급 컬렉션(Elements) 생성
    - [x] TEST - Elements를 List로 생성
    - [x] TEST - 요소들의 합을 구하는 메서드 추가
    - [x] REFACTORING
- [x] 입력값 분할하는 메서드를 객체(StringSplitter)로 분할
    - [x] TEST - StringSplitter 생성
    - [x] TEST - 입력된 문자열을 규칙에 따라 분할하여 배열로 반환
    - [x] TEST - 규칙에 따라 분할된 배열을 Elements 객체로 반환
    - [x] REFACTORING
- [x] 외부로 위임된 StringCalculator 안의 메서드들 정리

### step1 - 이슈
- Element 객체를 불변 객체로 만들 필요가 있을지


### step2 - 로또(자동)
- [ ] 로또번호(LottoNumber) 객체 생성
    - [ ] TEST - 로또번호의 범위는 1~45의 자연수
    - [ ] REFACTORING
- [ ] 로또복권(LottoTicket) 객체 생성
    - [ ] TEST - 로또번호를 자동으로 생성한다 (Collections.shuffle())
    - [ ] TEST - 생성된 로또번호를 정렬한다 (Collections.sort())
    - [ ] TEST - 로또복권의 로또번호는 중복이 없다
    - [ ] TEST - 당첨번호와 비교해서 일치하는 개수를 반환한다 (ArrayList.contains())
    - [ ] REFACTORING
- [ ] 당첨번호(LuckyNumber) 객체 생성
    - [ ] TEST - 입력받은 당첨번호로 일급 컬렉션을 생성한다
    - [ ] REFACTORING
- [ ] 로또자동판매기(LottoSeller) 객체 생성
    - [ ] TEST - 금액을 입력 받아 구입할 로또 복권 개수를 반환한다
    - [ ] TEST - 구입할 개수만큼 로또복권을 생성한다
    - [ ] TEST - 각 일치 개수 별 당첨된 복권의 개수를 반환한다
    - [ ] TEST - 생성된 로또복권의 수익률을 계산한다
    - [ ] REFACTORING
- [ ] InputView 객체 생성
    - [ ] TEST - 구입 금액을 입력받고, 출력한다
    - [ ] TEST - 구매 개수를 LottoSeller로 부터 반환받아서 출력한다
    - [ ] TEST - 구매 개수만큼 생성된 로또복권들을 출력한다
    - [ ] TEST - 지난주 당첨 번호를 입력 받는다
    - [ ] REFACTORING
- [ ] OutputView 객체 생성
    - [ ] TEST - 각 일치 개수 별 당첨된 복권의 개수를 LottoSeller로 부터 반환받아서 출력한다
    - [ ] TEST - 총 수익률을 LottoSeller로 부터 반환받아서 출력한다.
    - [ ] REFACTORING
