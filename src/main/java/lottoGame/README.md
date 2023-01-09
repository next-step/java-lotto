
## 기능구현 명세서 -- 로또(자동)


- logic
  - domain
    - Lotto
    - LottoNumber
    - Lottos 
    - Grade 
    - LottoResult
      - 등수 
      - 수익률 

* view 
  * inputView
    * 금액
    * 당첨 번호 
    * 보너스 번호 
    * 수동 입력 
  * inputException 
    * 로또 번호 1개 
      * 숫자 범위 1-45
      * NULL 
    * 로또 번호 6개
      * 숫자 범위 1-45
      * NULL
      * 6개 값 체크 
      * 6개 번호 중복 체크 
    * 보너스 번호, 당첨로또 중복 체크 
  * resultView
    * 일치 카운트 
    * 수익률 
