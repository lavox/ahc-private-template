class Action implements Comparable<Action> {
  final Input in;
  final Main main;
  State baseState;
  double eval = 0;
  int id = 0;

  // TODO: パラメータ

  //TODO: コンストラクタ(必要なものを作成)
  Action(State state, Input in, Main main) {
    this.in = in;
    this.main = main;
    this.baseState = state;
    this.id = main.seq();

    // TODO: 評価値計算
  }
  // private void calcEval() {
  //   baseState.doAction((A)this);
  //   eval = baseState.getEval();
  //   baseState.undoAction((A)this);
  // }
  
  void setEval(double eval) {
    this.eval = eval;
  }
  double eval() {
    return eval;
  }

  @Override
  public int compareTo(Action o) {
    if ( eval != o.eval ) {
      return eval > o.eval ? -1 : 1;
    } else {
      return id - o.id;
    }
  }
  
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    // TODO: 出力用文字列

    return str.toString();
  }
}
