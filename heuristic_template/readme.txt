＜貪欲・ビーム・chokudaiサーチ＞
■Action
  パラメータの実装
  必要なコンストラクタの実装
■State
  状態保持用変数の実装
  clone() : deep copyが必要な部分の実装
  initState() : 初期局面のセットアップ
  isFinished() : 完了状態チェック
  calcActionEval() : Actionの評価値計算。doAction→評価値計算→undoActionで良ければ特に実装不要
  doAction() : 状態の変更、評価値の計算
  undoAction() : 状態のキャンセル。calcActionEval()で使用しない場合は不要
  getCandidate() : 候補Actionの生成
  calcScore() : スコア計算
  commitAction() : commit後に状態を確定させるための処理があれば実装
  createResult() : 結果をセットする処理の追加

＜山登り・焼きなまし＞
■Neighbor
  パラメータの実装
  必要なコンストラクタの実装
■Solution
  状態保持用変数の実装
  clone() : deep copyが必要な部分の実装
  initSolution() : 初期局面のセットアップ
  calcNeighborEval() : Neighborの評価値計算。apply→評価値計算→unapplyで良ければ特に実装不要
  apply() : 状態の変更、評価値の計算
  unapply() : 状態のキャンセル。calcNeighborEval()で使用しない場合は不要
  getCandidate() : 候補Neighborの生成
  calcScore() : スコア計算
  commit() : commit後に状態を確定させるための処理があれば実装
  createResult() : 結果をセットする処理の追加
