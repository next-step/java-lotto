# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항

* [ ] Step 1. 사용자에게 **로또 구입 금액** 입력을 요청한다.
    * [ ] User 1. **로또 구입 금액**을 입력한다.
        * [x] 로또 구입 금액
            * [x] 숫자
    * [ ] System 1. **로또 대리점**에 **로또 구입 금액**으로 **로또** *구입*을 요청한다.
        * [x] 로또 대리점
            * [x] 구매 (로또 구입 금액) -> 유저 로또
            * [x] 유저 로또
                * [x] 로또 티켓 목록
            * [x] 로또 구매 금액
                * [x] 지불 (로또 가격) -> 로또 개수
            * [x] 로또 단말기
                * [x] 로또 생성 (로또 개수) -> 로또 티켓 목록
                * [x] 로또 티켓
                    * [x] 로또 번호 목록
                        * [x] 로또 번호 오름차순 정렬
                        * [x] 로또 번호 6개
                        * [x] 로또 번호 랜덤 생성
                        * [x] 로또 번호
                            * [x] 숫자
                            * [x] 1 ~ 45 사이
    * [ ] System 2. 사용자에게 **로또 게임**으로 로또 개수와 로또 번호 목록을 보여준다. * [x] 로또 게임 * [x] 로또 개수 * [x] 로또 번호 목록
* [ ] Step 2. 사용자에게 지난 주 **당첨 번호** 입력을 요청한다.
    * [ ] User 1. **당첨 번호**를 입력한다.
        * [ ] 로또 사업자
            * [x] 당첨 번호
                * [x] 로또 티켓
                    * [x] 로또 번호는 중복 불가
                    * [x] 로또 번호
                        * [x] 캐싱
    * [ ] System 1. **로또 사업자**에게 **로또 목록**의 **로또 당첨 결과** *확인*을 요청한다.
        * [ ] 로또 사업자
            * [ ] 결과 확인 (유저 로또) -> 로또 당첨 결과
            * [ ] 로또 티켓
                * [ ] 번호 비교
            * [x] 로또 등수
                * 1등: 6개 일치, 2000000000원
                * 2등: 5개 일치, 1500000원
                * 3등: 4개 일치, 50000원
                * 4등: 3개 일치, 5000원
                * 순위 밖: 0개 일치, 0원
            * [ ] 로또 당첨 결과
                * [ ] 로또 등수 목록
                * [ ] 수익률
    * [ ] System 2. 사용자에게 **로또 당첨 결과**로 로또 등수별 개수와 수익률을 보여준다.
