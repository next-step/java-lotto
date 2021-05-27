# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 3단계

## 프로그램 Flow 정리
1. '구입금액을 입력해 주세요.' 텍스트 출력
2. 구입금액 사용자 입력
3. '14개를 구매했습니다.' 텍스트 출력
4. n개 구매 후 n개에 대한 로또 번호 출력
   - \[8, 21, 23, 41, 42, 43] ...
5. '지난 주 당첨 번호를 입력해 주세요.' 출력
6. '1, 2, 3, 4, 5, 6' 로또 번호 입력
7. 로또 번호에 따른 당첨 갯수 및 당첨금액 계산
8. 통계 출력  
```
당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## Dictionary
| 용어 | Word | 유의어 |
|---|---|---|
| 구입금액 | assets | 예산, 예산금액 |
| 구매한 | purchased | |
| 당첨번호 | winning numbers | |

## 기능정의
- [X] 구입 금액으로 구매할 수 있는 로또 갯수를 계산
- [X] 로또 번호 생성
- [X] 로또 구매 후 정산  
- [X] 당첨번호 입력에 대한 유효성 체크
- [X] 당첨번호와 단일 로또의 일치 갯수
- [X] 보너스 번호 설정. 당첨번호와 중복되지 않고 당첨번호가 이미 설정되어 있어야 한다.