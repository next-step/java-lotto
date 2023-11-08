# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 학습 목표
## 경험해야할 학습 목표
* TDD 기반으로 프로그래밍하는 경험
* 메소드 분리 + 클래스를 분리하는 리팩토링 경험
점진적으로 리팩토링하는 경험
# 경험할 객체지향 생활 체조 원칙
* 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
* 규칙 2: else 예약어를 쓰지 않는다.
* 규칙 3: 모든 원시값과 문자열을 포장한다.
* 규칙 5: 줄여쓰지 않는다(축약 금지).
* 규칙 8: 일급 콜렉션을 쓴다.

1. merge를 완료했다는 통보를 받으면 브랜치 변경 및 작업 브랜치 삭제(option)한다.
  : git checkout 본인_아이디
2. 통합(merge)한 next-step 저장소와 동기화하기 위해 next-step 저장소 추가(최초 한번만)
  : git remote add upstream https://github.com/next-step/java-lotto.git
3. next-step 저장소에서 자기 브랜치 가져오기(또는 갱신하기)
  :git fetch upstream taegoon 
4. NextStep 원격 저장소 로컬 동기화
  :git rebase upstream/taegoon