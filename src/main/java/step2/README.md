## 기능 목록
- 로또 구입 금액 입력
    - 1000원 단위 입력 가능
- 로또 번호 자동 생성 후 발급
    - 1000원 당 1장 발급
    - 1 ~ 45 중 랜덤하게 6개 숫자 정렬
- 당첨 번호 입력
    - 1 ~ 45의 숫자중 6개 입력 가능
- 당첨 통계 출력
    - 3,4,5,6개 일치된 개수 출력
    - 투자금액 대비 당첨된 금액으로 총 수익률 출력

## 구조
- domain
    - Number
    - Lotto
    - Lottos
    - Money
  
- service
    - LottoService
  
- controller
    - LottoController
    
- generator
    - LottoNumberStrategy
    - NumberGenerator
    - TestLottoNumberStrategy
  
- view
    - InputView
    - ResultView