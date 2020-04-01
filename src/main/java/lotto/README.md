# 2단계 - 로또 (자동)

## 요구사항

### 기능 요구사항

* InputView
  - [x] 로또 구입 금액 입력받기
    - [ ] input 값의 유효성 검사
  - [x] 당첨 번호 입력받기
* Lotto
  - [ ] 구입 금액에 해당하는 로또 발급 (로또 1장의 가격 : 1000원)
    - [ ] 로또 번호는 1-45 사이의 숫자 (Collections.shuffle() 메소드 사용)
  - [ ] 당첨 통계
  - [ ] 문자열 계산기의 피연산자 분리
  - [ ] 총 수익률 계산
* ResultView
  - [ ] 발급받은 로또 출력
  - [ ] 3-6개의 번호 일치 여부 출력
  - [ ] 총 수익률 출력

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