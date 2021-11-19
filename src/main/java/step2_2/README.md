## 기능 명세

    [입력]
    - 구매 금액 입력
        - 예외 : 돈 입력이 음수인 경우 -> 원인 보여주고 재입력
    - 당첨 번호 입력
        - 예외 : 1 ~ 45 사이의 로또번호가 아닌 경우 -> 원인 보여주고 재입력

    [로또]
    - 돈을 입력받으면 개수만큼 자동 생성
        - 번호가 랜덤으로 생성

    [당첨 결과]
    - 로또를 받으면, 결과를 갖는 객체 반환
        - (3,4,5,6) 개 일치하는 로또가 몇 개인지
        - 수익률

    [출력]
    - (3,4,5,6) 개 일치하는 로또가 몇 개인지
    - 수익률

## 설계

    [입력]
    - InputUtil (static)
        - 숫자, 문자 (한줄) 을 읽어들임
    - InputView (static)
        - 입력받기 위한 정보를 제공하는 출력을 담당

    [로또]
    - LottoNumber (non-static)
        - 예외 : 1 ~ 45 사이가 아닌 경우
    - Lotto (LottoNumber의 일급 컬렉션) (non-static)
        - 자동 (랜덤 번호) 생성 기능
        - 입력 (외부 주입) 생성 기능
    - LottoBundle (Lotto의 일급 컬렉션) (non-static)
        - 로또 생성
    - LottoMachine (static)
        - 돈을 입력받아 로또 생성

    [당첨 결과]
    - LottoResult (non-static)
        - (3,4,5,6) 개 일치하는 로또가 몇 개인지 를 입력받아서 결과를 갖는다.

    [출력]
    - OutputView (static)
        - LottoResult를 입력받아서 출력 (toString?)