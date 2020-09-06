

#### 단계별 To Do List --------- Utils/Exception 확인

[]      1) 구입금액 입력 받기 --------------------------Budget 0 or Null(CheckMoney)
            (InputView.getBudget() , int값)
    
[V]      2-1) <로또> 와 List<로또> 생성하기 -------------- Lotto .shuffle(1~45), regex, 유일 숫자 6개...
[V]     2-2) List<로또> (numOfLottos = (구입금액 / 1000원) ) -------- 일의 자리 몫 반환 (CheckDivideBy)
            (new Lottos(int numOfLotto))   -------- 0일 경우
    
[]      3) 로또 개수 출력하기 
           (ResultView.printNumOfLotto)
    
[]      4) 지난 주 당첨번호 입력 받기 -----------------------Null Blank 6개, regex 1~45 유일 숫자 확인
            ???(InputView.getBuzzNum(), String -> List<String> add ", "해서????)
   
[]      5) 로또와 해당 번호 일치 boolean 확인하고, <힛>개수 +=1 하기 ---일치개수 0 이상
            List<로또>.forEach() : 로또 6개 숫자 -  m.find() BuzzNum 비교
   
[]      6) 로또 -> <힛>  로 map해서 리스트 만들기 

[]      7) List<힛> 에서 3, 4, 5, 6 숫자 나온 횟수 각 더하기
            Key(일치개수) : value(나온 횟수) 페어링?---------- 해당 변수형의 유효성? 힛 저장소
   
[]      8) 당첨 통계 출력하기
           (ResultView.printKey, printValue)
           Key(==3) +"개 일치 ("+ int 5000+"원)- "+(==3).value+"개"
           Key(==4) +"개 일치 ("+ int 50000+"원)- "+(==4).value+"개"
           Key(==5) +"개 일치 ("+ int 1500000+"원)- "+(==5).value+"개"
           Key(==6) +"개 일치 ("+ int 2000000000+"원)- "+(==6).value+"개"
   
 []     9) 총 수익 계산하기  BuzzMoney = List<Enum(Key,moneyPerHit)> * List<힛>=value 
 
 [V]    10) 수익률 계산하기  Profit = BuzzMoney / Budget -------------------소수 둘째자리 버림(CheckDivideBy)
   
 [V]    11) 손해/이득 (기준 1) 계산하기  1과 비교------- (CheckMoney)

 []     12) 수익률, 손해/이득 출력하기
        (ResultView.printProfit, printBoolean)
   