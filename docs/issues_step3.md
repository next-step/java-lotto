# Issues
## 보너스 볼 추가
### 추가에 따른 설계 변경
- 기존에는 당첨 여부 확인을 Lotto에서 담당
  - WinningLotto에서는 List<Integer>에서 일치하는 개수만 확인
  - 그러나 WinningLotto에 BonusBall이 추가되면서 WinningLotto에서 순위를 확인하는 것이 더 자연스러워짐
### WinningLotto / Lotto 변경
- WinningLotto에서 당첨 여부를 확인하도록 변경
  - Lotto에서 WinningLotto와 겹치는 숫자를 반환
  - WinningLotto에서 겹치지 않는 숫자와 보너스 볼을 비교하여 당첨 여부를 확인