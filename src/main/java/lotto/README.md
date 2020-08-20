# 3단계 - 로또(2)
## 기능 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

## feature list
0. step2 복사 및 step2 마지막 리뷰사항 반영
1. OrderHere에 보너스 번호 입력 로직 추가 및 당첨 번호와 보너스 번호를 멤버 변수로 갖는 PrizeInfo 작성
2. 당첨 통계에 2등도 출력하기 위한 DisplayHere 변경 및 PrizeGrade 변경
3. 당첨 금액 계산 로직에서 당첨 횟수를 곱해주지 않아서 생긴 버그 해결

## refactoring list
1. 패키지명 변경 후 중복 소스인 step2 패키지 삭제
2. PrizeGrade의 패키지 domain으로 변경
3. PrizeGrade에 녹아있던 출력 관련 멤버 변수 제거
4. PrizeInfo 클래스명 변경 (PrizeInfo -> GameWinningCondition)
5. LottoGame에서 PrizeGrade를 의존하던 관계 끊기! 당첨 등급의 확인은 GameWinningCondition에 있다.