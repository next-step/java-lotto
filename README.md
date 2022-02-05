# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


--------------------------------
### 🔹 로또(자동) 기능 요구사항

1. 구입 금액을 입력받는다 `(input_view)`
2. 1000원 미만의 금액을 입력한다면 종료한다 `(input_view)`
3. 로또 1장당 가격은 1000원이다. `(lottoTickets)`
4. 구입 금액 / 로또 1장당 가격 만큼의 로또가 발급된다. `(lottoTickets)`
5. 로또의 숫자 범위는 1~45 이다 `(lottoGenerator)`
6. 로또의 숫자 범위를 Collections.shuffle( ) 메소드를 통해 섞는다. `(lottoGenerator)`
7. 로또 1장당 총 6개의 숫자를 발급받는다. `(lottoGenerator)`
8. 로또의 숫자들은 Collection.sort( ) 메소드를 통해 정렬시킨다. `(lottoGenerator)`
9. 구매한 로또들을 보여준다 `(print_view)`
10. 지난 주 당첨 번호 숫자를 ',' 기준으로 6개를 String으로 입력받는다 `(input_view)`
11. 입력받은 당첨번호 String을 ','를 기준으로 split 하여 List에 담아둔다. `(input_view)`
12. (**추가기능**) 보너스 볼을 입력받는다.  `(input_view)` 
13. 만약 범위 안의 숫자를 입력하지 않으면 *Exception* 발생 `(lottoAnswer)`
14. (**추가기능**) 보너스 볼의 숫자 범위를 확인하고 아닐 경우 *Exception* 발생 `(lottoAnswer)`
15. 모든 로또를 돌며 1장의 로또에서 당첨 번호가 몇 개가 일치하는지를 확인한다 `(lotto)`
16. (**추가기능**) 5개를 일치하였을 경우, 보너스 볼이 일치 하였는지 확인한다 `(lottoAnswer)`
17. 로또의 당첨 번호 개수를 업데이트 해준다 `(lotto)`
18. 3~6개(+보너스 추가 일치) 일치한 로또들의 개수를 출력한다. `(print_view)`
19. 3~6개(+보너스 추가 일치) 일치한 로또들의 당첨 금액을 계산한다. `(lottoTickets)`
20. 당첨 금액 / 구입 금액 으로 총 수익률을 계산한다. `(lottoTickets)`
21. 총 수익률을 출력한다. `(print_view)`
