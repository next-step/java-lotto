# 로또

## 기능 요구사항

- 로또 구입
    - 로또 1장의 가격은 1,000원이다.
    - 로또 구입 금액에 해당하는 로또를 발급해야 한다.
        - ex) 10,000원 구입하면 로또 10장 발급

- 당첨 번호
    - 당첨 번호는 1부터 45까지의 번호 중 중복없는 숫자 총 6개이다.
    - 당첨 번호는 입력 받는다.
    - 현재는 직접 입력을 받지만 랜덤을 통해 생성될 수도 있다.

- 당첨 통계
    - 구입한 로또와 당첨 번호를 비교해서 당첨금의 갯수와 수익률을 계산한다.
    - 당첨 금액은 다음과 같다.
        ````
        3개 일치 (5000원)
        4개 일치 (50000원)
        5개 일치 (1500000원)
        6개 일치 (2000000000원)
        ````
    - 수익률에 따라 이익/손해를 구분할 수 있다. (기준은 1)

## 기능 목록

- LottoApplication
    - 로또 애플리케이션 수행
- ui
    - InputView
        - 로또 구입금액 입력
        - 지난 주 당첨 번호를 입력
    - ResultView
        - 구매한 로또 번호 출력
        - 당첨 통계 출력
- controller
    - 로또 애플리케이션 컨트롤러
- service
    - domain
        - type
            - Rnak는 당첨 배당표
        - LottoTicketRandomMaker는 로또 번호 난수 생성
        - LottoTicket는 번호 6개로 이루어진 로또 한게임
        - LottoResultMaker는 로또당첨 통계성 데이터 생성
        - WinningLottoNumber는 당첨번호
    - model
        - LottoTickets은 LottoTicket의 일급컬렉션
        - LottoResult는 내가 구매한 복권과 당첨번호 확인 결과
    - value(VO)
        - LottoNumber는 로또 번호 숫자 하나의 규칙을 담은 VO
        - LottoPrice는 로또 구매 가격 정보를 담은 VO
    - LottoService는 실제 로또 관련 비즈니스 로직 수행
- utils
    - Preconditions는 객체를 생성 전, 필수값 체크 유틸
- rule
    - 로또에서 사용되는 공통 상수 정의
- validator
    - 로또 생성 규칙 체크
