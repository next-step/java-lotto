<Class 목록>
- 당첨 숫자 갯수를 저장하는 것에서 등수를 저장하도록 전체적으로 변경하였습니다.

- VO
    - Lottos 
        - parameter : List<Lotto> lottoList
        - function
            - buyAutoLottos : 자동 발권 로직
            - getAutoLottoCnt : 로또 자동 발권 갯수 계산 
            - buyManualLottos : 수동 발권 로직
            - checkResult : 당첨 결과 비교
            - getLottoList 
            - getLottosCnt : lottoList 길이 계산
            
    - Lotto 
        - parameter : List<LottoNumber> numberList
        - function 
            - checkReward : 해당 로또 등수 Statistic에 기록
    
    - LottoNumber
        - parameter 
            - int maxNumber(static): 로또 최대 숫자 
            - int number 
        - function  
            - validate : 숫자 검증 
            
    - ManualLottoCnt
        - parameter
            - int lottoCnt : 수동 로또 갯수 
        - function
            - validate : 검증

    - Money
        - parameter
            - int lottoPrice : 로또 1장 금액 
            - int money 
        - function
            - validate : 검증 
            - getLottoCnt : 금액으로 살 수 있는 로또 갯수 계산 
            - getMarginByMoney : 수익률 계산
            - compareMoney : 금액 비교


- ResultNumber 
    - parameter
        - List<LottoNumber> resultNumberList : 당첨 번호 리스트 
        - int bonusNumber : 보너스 번호
    - function
        - settingLottoResultNumber : 당첨 번호 등록
        - settingLottoBonusNumber : 보너스 번호 등록
        - checkLottoResult : 당첨 갯수 확인 
        - checkNumberContain : 당첨 번호 확인
        - checkBonusResult : 보너스 번호 확인
    
- LottoGenarator 
    - parameter 
        - int lottoSize : 로또 1개당 숫자 갯수 
        - List<Integer> numbers : 로또 번호 Pool 
    - function 
        - getLottoNumbers : 로또 번호 발급
        
- Statistic :
    - parameter 
        - Integer[] results : 1등 ~ 6등 현황
        - Map<Integer, RewardBoard> rankMap : 등수별 당첨 갯수
    - function 
        - getMargin : 현황 기반 마진률 계산
        - getResultByIndex : 해당 등수의 로또 갯수
        - getResultLength : 등수 list length
        - recordLottoResult : 당첨 갯수에 따른 등수 현황 update 
        - getRankByWinningCnt : 당첨 갯수 기반 등수 
        - getWinningCntByRank : 등수 별 당첨 갯수 
        
- RewardBoard (enum) 
    - 등수에 따른 당첨 금액 return 