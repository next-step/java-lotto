# 2단계 - 로또 (자동)

## 요구사항

### 기능 요구사항

* InputView
  - [x] 로또 구입 금액 입력받기
    - [ ] input 값의 유효성 검사
  - [x] 당첨 번호 입력받기
* Lotto
  - [x] 구입 금액에 해당하는 로또 발급 (로또 1장의 가격 : 1000원)
    - [x] 로또 번호는 1-45 사이의 숫자 (Collections.shuffle() 메소드 사용)
  - [x] 당첨 여부 확인   
  - [ ] 당첨 통계
  - [x] 총 수익률 계산
* LottoGame
  - [x] 입력받은 금액 만큼의 로또 생성 후 숫자들 출력
  - [x] 당첨 여부 확인 후 결과 출력
* ResultView
  - [x] 발급받은 로또 출력
  - [x] 3-6개의 번호 일치 여부 출력
  - [x] 총 수익률 출력

### 프로그래밍 요구사항

- 모든 기능을 TDD로 구현 - 모든 단위 테스트가 존재해야 함
  - UI(System.out, System.in) 로직은 제외
  - Domain 로직 코드와 UI를 담당 로직 구분
  - UI 로직 : InputView, ResultView와 같은 클래스를 추가해 분리
- indent(인덴트, 들여쓰기) depth < 2
- 함수의 길이 < 15라인
- 자바 코드 컨벤션을 지키면서 프로그래밍
  - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 사용하지 않을 것
  - switch/case도 허용하지 않음
  
  
  
# 3단계 - 로또 (2등)

## 요구사항

### 기능 요구사항

* InputView
  - [x] 보너스 볼 숫자 입력받기
* Lotto
  - [x] 보너스볼 당첨 여부 확인
* WinningNumber
  - [x] 당첨 번호 객체로 구현
* LottoService
  - [ ] 로또 게임 로직 분리
* ResultView
  - [x] 보너스볼 일치여부 결과 출력

### 프로그래밍 요구사항

- 모든 기능을 TDD로 구현 - 모든 단위 테스트가 존재해야 함
  - UI(System.out, System.in) 로직은 제외
  - Domain 로직 코드와 UI를 담당 로직 구분
  - UI 로직 : InputView, ResultView와 같은 클래스를 추가해 분리
- java enum을 적용해 프로그래밍
- 규칙 8: 일급 컬렉션 사
- indent(인덴트, 들여쓰기) depth < 2
- 함수의 길이 < 15라인
- 자바 코드 컨벤션을 지키면서 프로그래밍
  - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 사용하지 않을 것
  - switch/case도 허용하지 않음