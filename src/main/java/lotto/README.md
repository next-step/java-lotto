# 로또(2등)

## todo 
1. 보너스 볼을 입력 받는다.
    - 보너스 볼은 당첨 번호와 중복되지 않는다
    - 보너스 볼은 로또 번호 범위 내 값이다
2. 일치하는 수를 로또 등수로 변경한다.
    - 보너스 번호 일치, 로또 번호 5개 일치일 경우 2등 반환
    - 기타 나머지는 보너스 번호 여부 상관없이 등수 출력
3. 당첨 결과에 보너스 볼 체크를 추가한다.
    당첨결과Map -> Map(등수, 당첨 수)

4. 보너스 볼 일치도 출력한다

## 지난 리뷰
1. LottoNumber<Integer> 원시값 포장
2. WinningResult의 


---
## 구현할 기능 목록
0. 로또 메인 (LottoApplication)
    
1. 번호 Numbers
    - 1~45 범위의 일련 번호를 가지는 컬렉션 객체
    - 로또 번호를 생성한다
    
2. 로또 번호 LottoNumbers 
    - 로또 번호를 가지는 컬렉션 객체
    
3. 로또 LottoTicket
    - 구입 장 수만큼 LottoNumbers 가지는 컬렉션 객체
    - 구입 장수 유효성 체
    + 당첨 결과를 만든다. 
    
4. 상금 Prize
    - 일치 개수별 상금을 가진다
    - 일치 개수별 상금을 계산한다 (일치 개수별 상금 * 당첨 수)         

5. 당첨 번호 WinningNumbers
    - 당첨 번호를 가지는 컬렉션 객체
    - 로또 번호 일치 개수를 구한다. findMatchCount();

6. 당첨 결과 WinningResult       
    - 일치 수(matchCount) 별 당첨 수 (WinningCount)를 가진 컬렉션(Map) 객체
    - 수익율(WinRate)을 계산한다
          - 수익금(Prize)을 계산한다
    
7. 로또 유틸 LottoUtil
    - 로또 장수를 계산한다
   