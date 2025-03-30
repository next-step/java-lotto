# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## TODO
Lotto
- [x] 로또의 당첨 여부를 확인할 때 성능상 이점을 위해 ImmutableSet을 활용한다.
- [x] 로또는 6개의 로또 숫자를 가진다.
- [x] 6개의 숫자를 입력받아서 로또를 생성할 수 있다.
- [x] 랜덤하게 6개의 숫자를 생성해서 로또를 생성할 수 있다.
     ㄴ 6개의 숫자 생성은 1~45까지의 숫자를 가진 배열에서 Collection.shuffle을 하고 앞의 6개를 가져온 뒤 정렬해서 생성해준다.

LottoNumber
- [x] 로또 숫자는 1에서 45 사이의 숫자를 가진다.

WinningLotto
- [ ] 당첨 로또는 Lotto와 보너스숫자인 LottoNumber 하나를 가진다.
- [ ] 점검할 로또를 받아 로또 등수(LottoRank)를 돌려줄 수 있다.
 

LottoRank
- [ ] LottoRank는 1등부터 6등까지 존재한다. (Enum)
- [ ] LottoRank는 등수의 당첨금을 함께 관리한다.

