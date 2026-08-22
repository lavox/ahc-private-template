import java.util.ArrayList;
import java.util.Collections;

class State implements ResultCreator, Cloneable {
  final Input in;
  final Main main;

  Action lastAction = null;
  int gen = 0;
  double eval = 0; // 大きい方が良いとする
  long score = 0;
  int id = 0;
  //TODO: 状態を保持する変数

  State(Input in, Main main, Action lastAction) {
    this.in = in;
    this.main = main;
    this.id = main.seq();
    this.lastAction = lastAction;
  }

  @Override
  public State clone() {
    State ret = null;
    try {
      ret = (State)super.clone();
      //TODO: オブジェクトや配列はdeep copyする
    } catch (Exception e) {
    }
    return ret;
  }

  static State createInitialState(Input in, Main main) {
    State s = new State(in, main, null);
    s.initState();
    return s;
  }

  void initState() {
    //TODO: 初期局面の生成

  }

  // この状態が完了状態かどうかを返す
  boolean isFinished() {
    //TODO:
    return false;
  }

  // actionの評価値を計算しactionに設定する。
  void calcActionEval(Action action) {
    //TODO: superではdoAction→評価値計算→undoActionで実装。必要に応じて独自実装に改造する
    doAction(action);
    action.eval = this.eval();
    undoAction(action);
  }

  // actionを適用する
  void doAction(Action action) {
    gen += 1;
    //TODO: 状態変数の変更、評価値の計算
    this.eval = 0;
  }

  void undoAction(Action action) {
    gen -= 1;
    //TODO: Actionのキャンセル。calcActionEval()でundoを使用する場合に必要。使わない場合は消しても良い
    //TODO: evalの変更
  }

  // 候補となるactionのリストを生成する
  ArrayList<Action> getCandidate() {
    ArrayList<Action> cand = new ArrayList<>();
    //TODO:
    return cand;
  }

  double eval() {
    return eval;
  }
  long score() {
    return score;
  }

  // スコアを計算してscoreにセットする
  void calcScore() {
    //TODO:
    this.score = 0;
  }

  void commitAction(Action action) {
    doAction(action);
    this.lastAction = action;
    assert eval == action.eval();
    //TODO: commit後に状態を確定させるための処理等があれば行う
  }

  public Result createResult() {
    return createResult(createActionList());
  }
  Result createResult(ArrayList<Action> actions) {
    Result ret = new Result(in);
    //TODO: 結果をセットする。

    ret.score = score();
    return ret;
  }

  // action列を取り出す
  ArrayList<Action> createActionList() {
    ArrayList<Action> ret = new ArrayList<>();
    State cur = this;
    while ( cur.lastAction != null ) {
      ret.add(cur.lastAction);
      cur = cur.lastAction.baseState;
    }
    Collections.reverse(ret);
    return ret;
  }
}
