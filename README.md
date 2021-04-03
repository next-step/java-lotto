# 로또
## 기능 목록
- [X] 구매 금액 입력
    - [X] __ERROR__ : null
    - [X] __ERROR__ : 빈 값
    - [X] __ERROR__ : 문자가 포함될 경우
    - [X] __ERROR__ : 1000원 미만일 경우
- [X] 구매금액 1000원 단위로 나눠 구매 장수 구하기
- [] 수동으로 구매할 로또 장수 입력
    - [] __ERROR__ : null
    - [] __ERROR__ : 빈 값
    - [] __ERROR__ : 문자가 포함될 경우
    - [] __ERROR__ : 구매할 수 있는 장수보다 많을 경우
- [] 수동으로 구매할 로또 번호 입력
    - [] __ERROR__ : null
    - [] __ERROR__ : 빈 값
    - [] __ERROR__ : "," 가 존재하지 않을 경우
    - [] __ERROR__ : "," 가 5개가 아닐 경우
    - [] "," 기준으로 문자열 분리
        - [] __ERROR__ : 분리된 값의 개수가 6개가 아닐 경우
        - [] __ERROR__ : 분리된 값에 문자가 포함되어 있을 경우
        - [] __ERROR__ : 분리된 숫자들의 범위가 1 ~ 45 사이가 아닐 경우
        - [] __ERROR__ : 중복되는 숫자가 있을 경우
- [] 총 구매 장수 - 수동 구매 장수만큼의 자동 로또 번호 생성
    - [X] 로또 생성
        - [X] 자동 로또 번호 생성 
- [] 수동, 자동 구매 장수 출력
    - [X] 구매 장수만큼의 로또 번호 출력
- [X] 지난 주 당첨 번호 입력
    - [X] __ERROR__ : null
    - [X] __ERROR__ : 빈 값
    - [X] __ERROR__ : "," 가 존재하지 않을 경우
    - [X] __ERROR__ : "," 가 5개가 아닐 경우
    - [X] "," 기준으로 문자열 분리
        - [X] __ERROR__ : 분리된 값의 개수가 6개가 아닐 경우
        - [X] __ERROR__ : 분리된 값에 문자가 포함되어 있을 경우
        - [X] __ERROR__ : 분리된 숫자들의 범위가 1 ~ 45 사이가 아닐 경우
        - [X] __ERROR__ : 중복되는 숫자가 있을 경우
    - [X] 당첨 번호 생성
- [X] 보너스 볼 입력
    - [X] __ERROR__ : null
    - [X] __ERROR__ : 빈 값
    - [X] __ERROR__ : 지난 주 당첨 번호와 중복
    - [X] 보너스 볼 생성
- [X] 당첨 통계 출력
    - [X] 3 ~ 6개 일치하는 로또 개수 출력
    - [X] 수익률 출력
        - [X] 수익률 계산

     

## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)