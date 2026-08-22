import java.util.ArrayList;

class Greedy extends AbstractSolver<State> {
  ArrayList<Action> actionList = new ArrayList<>();

  Greedy(Input in, Main main) {
    super(in, main);
  }

  @Override
  public Result solve(State initialState) {
    State best = search(initialState);
    return best.createResult(actionList);
  }

  // greedy searchしてbest解のstateを返す
  @Override
  State search(State initialState) {
    iterations = 0;

    actionList = new ArrayList<>();
    State state = initialState;
    while ( !state.isFinished() ) {
      iterations++;
      ArrayList<Action> cand = state.getCandidate();
      double bestEval = Double.MIN_VALUE;
      Action bestAction = null;
      for ( Action a : cand ) {
        if ( bestAction == null || a.eval > bestEval ) {
          bestEval = a.eval;
          bestAction = a;
        }
      }
      if ( bestAction == null ) break;
      state.commitAction(bestAction);
      actionList.add(bestAction);
    }
    return state;
  }
}
