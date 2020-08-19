# 2단계 - 로또(자동)
## 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## feature list
#### 도메인부터 시작
1. LottoNumber Class 작성하기 
2. LottoGame Class 작성하기
3. LottoGameFactory Class 작성하기
4. LottoGames Class 작성하기 (일급 컬렉션)
5. PrizeGrade Class 작성하기
6. ConfirmResult Class 작성하기
7. ConfirmResults Class 작성하기 (일급 컬렉션)
#### UI 시작
8. InputChannel, OutputChannel 인터페이스 및 구현체 (System.in, System.out) 작성
9. OrderHere Class 작성
10. PurchaseRequest Class 작성 (도메인 클래스...)
11. DisplayHere Class 작성
12. Main 및 CustomException 작성

## after review refactoring
1. null 리턴 부분 optional로 변경
2. 게임이 진행되지 않던 버그 수정 (nextline을 해야하는데 next를 함)
3. 로또 게임 출력 시 정렬해서 출력
4. 줄바꿈 문자 System.lineSeparator()로 변경
5. 긴 숫자에 언더스코어 적용해서 가독성 높이기 && 금액 필드 long으로 변경
6. 구매 금액 입력시 최소 1000원 입력해야 함, PurchaseRequest의 이름을 PurchaseStandBy로 변경해 purchase 행위가 어색하지 않게 함
7. 불필요한 ConfirmResult 클래스 삭제
8. DisplayHere <-> ConfirmResults 간 책임이 뒤섞여 있는 코드 정리
9. Input/OutputChannel getDefaultChannel 삭제