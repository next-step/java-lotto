# 로또(자동)
## 1차 PR 리뷰 요점
 1. 전체적인 구조 개선
 2. 객체는 객체답게, 상태와 행위가 존재해야한다. 
    - 유틸리티성 클래스가 많고, 이런 클래스를 객체처럼 사용하고있음
 3. 일급컬렉션을 사용해볼것
    - winningNumbers의 일급컬렉션화
    + (개인 추가) 컬렉션은 모두 일급컬렉션화 하는 시도를 해보자.!
    
 4. 고정된 값은 상수를 사용할 것
 5. 테스트 코드 작성이 어려울 때 : 구조를 개선할 때 !
    -  각 단위별로 분리해볼것 (일치, 불일치) 두 기능 모두 테스트
 + (개인 추가) 원시값을 포장하는 시도를 해보자
 + (개인 추가) 게터 대신 투스트링을 활용해보자
 
 
## todo
 1. 로또 구매 금액을 입력받는다.
 2. 로또 구매 장수를 계산한다.
 3. 구매 장수 만큼 로또 번호(LottoNumbers)를 생성한다
     - 로또 번호는 1~45 사이의 수
     - shuffle 사용
     - 6자리를 갖는다
     - 정렬
 > 생각 메모. List<LottoNumbers> lottoNumbers = new LottoNumbers<>();
    LottoNumbers == List<Integer>. 값 비교는 equals로 해 볼 것.
    만약에 로또도 일급 컬렉션으로 만들면?
    LottoTicket lotto = new LottoTicket();
    List<LottoNumbers> lotto 번호를 가진 LottoTicket 클래스  
 4. 로또 구매 장수를 출력한다.   
 5. 로또 번호를 출력한다.
 6. 지난 주 당첨 번호(WinningNumbers)를 입력받는다.
 7. 당첨 통계(WinningStatistics) 를 구한다.
    - 몇 개가 일치하는지 구한다 (로또 번호 별 당첨 번호 일치 개수를 구한다.)
    - 금액 별 당첨 수를 구한다 (일치 개수별 당첨 수 를 구한다)
 8. 당첨 통계를 출력한다
 9. 수익율(WinRate)을 계산한다
    - 수익금(Prize)을 계산한다
    - 수익율(Prize?)을 계산한다.
    - 이득과 손해 여부를 따진다
10. 수익율을 출력한다.

## 도메인 분리
## 구현할 기능 목록 (수정 진행중 - 작성 중 )
0. 로또 메인 (LottoApplication)
    - 로또 금액을 입력받는다. todo 1
    - 로또 머신을 실행한다. (return 로또번호)
        + todo 2~5 실행
    - 당첨 번호를 입력받는다. todo 6
    - 로또 분석기를 실행한다.
        + todo 7 ~10 실행

~~번호 Numbers~~
~~- 1~45 범위의 일련 번호를 가지는 컬렉션 객체~~
     
. 로또 번호 LottoNumbers 
    - 로또 번호를 가지는 컬렉션 객체
    - 로또 번호는 1~45 사이의 수
    - shuffle 사용
    - 6자리를 갖는다
    - 정렬
    
. 로또 LottoTicket
    - 구입 장 수만큼 LottoNumbers 가지는 컬렉션 객체
    - 구입 장 수만큼 로또 번호를 생성 한다
     
. 당첨 번호 WinningNumbers
    - 당첨 번호를 가지는 컬렉션 객체
    - 문자열 당첨 번호를 숫자 리스트로 변환한다
    - 당첨 번호가 바른 값인지 확인한다.
    - 로또 번호 일치 개수를 확인 한다. getMatchCount();
        

3. 번호 GenericNumbers

        
---
## 궁금한 점
1. WinningNumbers 의 생성자와 convertWinningNumber 부분
    - String 주입 -> convertWinningNumber() 변환 부분을 외부에서 List<Integer>로 변환 후 값을 넘겨주는 형태가 나았을지?
    - 멤버 변수(List)와 다른 타입(String) 을 받아 가공 후 값을 주입하는 형태가 괜찮은 방법인지 궁금합니다.

2. Scanner의 상수 선언 관련
    - scanner를 각 메서드 안에 선언 : 쓰고  버림 가능, 중복 코드 발생
    - scanner를 상수로 선언 : 어플리케이션 종료 시점까지 자원 할당 
 중복되거나 한 클래스 안이더라도 공유된다면 상수 선언이 좋은지?? 
 
 
 ---
 
 
## 이전 도메인 분리
1. 번호 생성기 (NumberGenerator)
    - 1~45 범위의 숫자를 가진 숫자 
    - 랜덤 번호를 생성한다
    
2. 로또 (Lotto)
    - 로또 번호를 가진다

3. 로또 머신 (LottoMachine)
    - 구매 장수 계산
    - 구매한 장 수 만큼 로또 생성 
                                                        
4. 상금 (Prize)
    - 일치 개수와 당첨금으로 상금 계산

                                                  
6. 로또 분석기 (LottoAnalyzer)
    - 당첨 수 확인 (3개일치 로또 - 1개)
    - 수익율 계산 

    
8. LottoController
    - 로또 어플리케이션
--- 


1. NumberGenerator 를 LottoNumbers로 리팩토링 진행