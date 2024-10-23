* 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
-  로또 1장의 가격은 1000원이다.

## TODO
-[x] 금액이 1000원 이상인지 체크한다. - LottoMachine
-[x] 45개의 로또번호를 미리 생성한다. - LottoNumber  
-[x] 45개의 로또번호를 섞는다. - Lotto
-[x] 6개의 번호를 발급한다. - Lotto
-[x] 로또 번호를 정렬한다. - Lotto
-[x] 로또 1장에 6개의 번호이다. - Lotto
-[x] 로또를 금액만큼 생성한다.(1000원당 1장) - LottoMachine
-[x] 입력한 당첨 번호는 1~45사이의 숫자이다. - LottoWinning
-[x] 입력한 당첨 번호와 몇개가 일치하는지 계산하고 결과를 저장한다. - LottoResult, Lotto
-[x] 수익률을 계산한다. - LottoMargin
      LottoMarginCalculator 매칭수 * 금액 계산식과 실제 계산하는 기능    

## 진행 중 특이사항 
## 전략패턴으로 수정 내용 정리
* as-is 
- Lotto에 로또생성(45개로또생성,45개섞기,6개발급,정렬) 로직이 존재 
* to-be
- 로또생성로직을 AutoLottoStrategy로 옮김 (생성 정책 인터페이스: LottoGeneratorStrategy)
- LottoMachine은 context로 서비스에서 어떤 전략을 사용할지 주입받아 생성 메소드 호출 

## 계산식 분리
* as-is 
- LottoMargin 에 금액 및 마진률 계산, 규칙 등 상수처리
* to-be
- LottoMarginCalculator enum으로 상수 각 규칙 정리, 마진률 계산 (MarginOperation) 함수형 인터페이스 적용, 규칙이 늘어나도 계산 로직이 깨지지 않도록 수정
- WinningPrice 당첨금액 관리 
