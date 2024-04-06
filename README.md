# 로또
## 진행 방법
* Lotto의 숫자를 객체화 및 cache
* 정답지의 정수 리스트를 객체로 변경
* Lotto를 생성역할을 LottoMaker에게 위임
* LottoPrize에서 결과값 print 로직 제거
* 정답지와 Lotto를 통해 결과값을 만드는 calculaotr 클래스 작성
* ui , controller, service 로직 분리