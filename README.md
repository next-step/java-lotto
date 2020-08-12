# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

### 구현 내용
1. 로또번호(LottoNo)는 1 ~ 45까지 숫자값만 설정될수 있음(Singleton으로 구현)
2. 로또(Lotto)는 로또번호(LottoNo)를 가지며 중복되지 않음
    - b15e4de2
        - Lotto클래스 리펙토링 - 생성자에 ```Collection```활용하여 초기
        - 검증하는 코드가 여러개 생생되어 ```LottoNoValidator```에 기능 위임
    - be094945
        - ```Collection```으로 생성되기 때문에 로또를 다양한 방법으로 생성할 수 있도록 구현(```LottoGenerator```)
        
3. 로또 판매점 기능 구현

    -  ```ImmutableLottoList```를 생성하여 불변 List 생성
    - 로또 통계정보는 ```LottoStatistics```에서 담당하며, ```LottoWinningAndPrizeMoney```enum 객체를 key로 사용함
    
