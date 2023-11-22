# 📌 핵심 기능: 랜덤 로또 번호와 당첨 번호의 6자리를 비교해 당첨 통계를 구하는 것!

# 👩‍💻프로그램 동작 흐름
- [ ] 구입금액을 입력받는다.
- [ ] 구입금액을 통해 구매한 로또 갯수를 출력한다.
- [ ] 구매한 로또 티켓들을 출력한다.
- [ ] 당첨 번호를 입력받는다.
- [ ] 발행 로또와 당첨 번호를 통해 당첨 통계를 구한다.
- [ ] 당첨 통계를 출력한다.
- [ ] 수익률을 출력한다.

# 📝기능 구현 목록
- [ ] 입력 받은 구입금액을 통해 구입금액을 생성하는 기능
- [ ] 구입금액을 통해 구매한 로또 갯수를 생성하는 기능
- [ ] 로또 갯수를 통해 구매한 로또 티켓들을 생성하는 기능
- [ ] 입력 받은 당첨 번호를 통해 당첨 번호를 생성하는 기능
- [ ] 발행 로또와 당첨 번호를 통해 당첨 통계를 생성하는 기능
- [ ] 수익률을 생성하는 기능


# 🖨️ 입출력 기능

## 입력 기능

- [ ] 구입금액을 입력받는 기능
- [ ] 당첨 번호를 입력받는 기능

## 출력 기능

- [ ] 구매한 로또 갯수 출력하는 기능
- [ ] 구매한 로또 티켓들 출력하는 기능
- [ ] 당첨 통계 출력하는 기능
- [ ] 수익률 출력하는 기능


#  ⚠️ 예외 처리
- [ ] 구입금액 입력 형식의 유효성 검증
  - [ ] 공백이 아닌지
  - [ ] 숫자인지
  - [ ] integer 범위 내의 숫자인지

- [ ] 구입금액의 유효성 검증
  - [ ] 0보다 큰 숫자인지
  - [ ] 1000원 단위의 숫자인지

- [ ] 당첨 번호 입력 형식의 유효성 검증
  - [ ] 공백이 아닌지
  - [ ] ","가 2번이상 연속으로 들어가지 않는지
  - [ ] 맨 앞, 뒤에 ","가 있지 않은지

- [ ] 개별 당첨 번호 입력 형식의 유효성 검증
  - [ ] 숫자인지
  - [ ] integer 범위 내의 숫자인지


- [ ] 당첨 번호의 유효성 검증
  - [ ] 1~45 사이의 숫자인지


# 🛠 리팩토링 목록
- [ ] 원시값 포장 확인
- [ ] 일급 컬렉션 필요 부분 확인
- [ ] 숫자 리터럴 상수화
- [ ] 컨트롤러 메소드 네이밍 정리 및 분리 개선
- [ ] getter 리스트 레퍼런스에 unmodifaible 추가
- [ ] 생성자가 투명한지
- [ ] 부생성자가 있는 경우 부생성자가 합당한지,
- [ ] 부생성자가 있는 경우 생성자의 접근제어자가 private인지
- [ ] 객체 생성이 불필요한 경우 private 생성자가 있는지
- [ ] 각 클래스 점검하기
    - [ ] 불필요한 public 접근제어자
    - [ ] 메소드 순서
- [ ] 각 클래스의 책임 범위 위반한 것 없는지 점검하기
    - [ ] public 메소드가 클래스에 많다면,
    - [ ] getWinnerGroup
- [ ] 이해를 위한 코드 전반의 공백 추가
- [ ] 메서드 길이가 10 넘어가지 않는지 확인 


# 🧐 고민인 지점