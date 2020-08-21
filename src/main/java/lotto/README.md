# 4단계 - 로또(수동)
## 기능 요구사항
* 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
* 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

## feature list
1. OrderHere에 수동 구매 로직 추가
2. LottoGameFactory에 수동 생성 추가
3. PurchaseStandBy에 수동 관련 로직 추가
    1. refactoring : LottoNumberFactory에 getNewLottoNumber추가 해서 외부 클래스에서 new LottoNumber 쓰던 부분 이 메소드로 대체
4. 출력 멘트 변경
5. 예외 처리를 통해 예외가 발생하면 처음 시작으로 돌아가게 유도