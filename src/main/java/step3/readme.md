<Class 목록>
- 당첨 숫자 갯수를 저장하는 것에서 등수를 저장하도록 전체적으로 변경하였습니다.

- Lottos 
    - 생성자 : money금액에 따라 로또 생성 
        - param :
            - int money
            - LottoGenerator lottoGenerator : 로또 번호 추출 
    - 함수
        - checkResult : List<Lotto> 당첨 결과 입력
        - buyLotto : 로또 생성 
        - getLottoCnt : 금액에 따른 로또 갯수 계산
        - getLottoCnt : 현재 로또 갯수  
        
- Lotto 
    - 생성자 : 해당 로또 등수 저장 
    - 함수 
        - checkReward : 해당 로또 등수 Statistic에 기록

- LottoNumber 
    - Lotto 숫자 VO

- WinningNumber :
    - 생성자 : 당첨 번호 및 보너스볼 저장
    - checkWinningCnt : 당첨 숫자 갯수 return
    
- LottoGenarator 
    - 생성자 : 로또 숫자 할당 범위 지정 
    - 함수 
        - getLottoNumberts : 로또 번호 할당
        
- Statistic :
    - 함수 
        - recordResult : Lottos의 결과 기록 (호출할 때마다 초기화)     
        - getMargin : 기록된 결과를 바탕으로 수익률 계산
        
- RewardBoard (enum) 
    - 등수에 따른 당첨 금액 return 
    - 함수 
        - getRankByWinningCnt : 당첨 갯수에 따른 등수 return 