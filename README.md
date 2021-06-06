# 로또
## 기능 목록
* 구입 금액을 입력한다.
  * 로또 1장의 가격은 1000원
* 로또 번호를 생성한다.
  * 1~45사이의 랜덤한 숫자 6개 생성
  * 로또 1장 내 중복된 번호를 가지지 않는다.
  * 로또 1장 내 번호는 오름차순 정렬된다.
* 입력된 구입 금액으로 구매 가능한 갯수를 구한다. 
* 구매 가능한 갯수 만큼 로또를 구매한다.
* 지난주 당첨 번호를 입력한다.
* 보너스 볼을 입력한다.
* 구매한 로또와 당첨 번호를 비교한다.
  * 1개 일치
* 당첨 결과, 통계를 보여준다.
  * 3개 일치 (5000원) - 0개
  * 4개 일치 (50000원) - 0개
  * 5개 일치 (1500000원) - 0개
  * 5개 일치, 보너스 볼 일치 (30000000원) - 0개
  * 6개 일치 (2000000000원) - 0개
  * 수익률 표시 = 당첨금/구매금액
  
## 리팩토링
* 패키지 분리하기 (O)
* hashcode, equals 구현 (보류)
* 상수값 제거 하기 (O)
* 테스트 코드를 간결하게 작성가능하도록 구조 변경 (보류)
* input 값의 validate 추가 구현
  * 6개값이 안들어왔을 때
  * 45보다 큰 값이 들어왔을 때
  * 중복된 값이 들어왔을 때
* 로또객체에서 get으로 꺼내지말고, 메시지를 보내는 방식으로 바꿔봐라. 
  * ex) get해서 비교 X -> isMatch로 구현 / int matchCount = userLotto.match(winningLotto)
* 테스트 케이스 추가
  * 등수별 테스트
* LottoNumbers.contains indent depth 수정

## 재설계
* LottoNo : 로또 번호 1개
  * int 원시값포장
  * 번호 하나에 대한 validation
    * 1~45사이, 숫자만 들어가고

* LottoNumbers : 6개번호 묶음  
  * List<LottoNo>  
  * 수동생성생성자: LottoNumber(1,2,3,4,5,6)
  * 자동생성생성자: LottoNumber(LottoNumberGeneratorStrategy)
  * 6개 번호 묶음에 대한 validation
    * 중복번호 존재하면 안됨

* LottoNumbersList : 구매한 전체 로또
  * List<LottoNumbers>
  
* WiningLottoNumbers : 당첨번호
  * LottoNumbers
  * int bonusNumber
  * 구입한 번호(LottoNumbers)와 당첨번호(WinningLottoNumbers) 비교해서 결과값 저장
    * matchLottoNumbers(LottoNumbers) : ResultScore

* LottoGame : 로또 번호 생성
  * 자동번호 생성
  * 수동번호 생성
  * WiningLottoNumbers.matchLottoNumbers를 LottoNumberList만큼 반복해서 실행
  
* ResultView
  * 로또 당첨 결과값 출력

## TO-DO
* 로또번호 생성 정적 팩토리 매소드로 변경해보기

