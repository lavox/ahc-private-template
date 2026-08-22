import java.util.ArrayList;
import java.util.PriorityQueue;

class ChokudaiSearch extends AbstractSolver<State> {
  ChokudaiSearch(Input in, Main main) {
    super(in, main);
  }

  // chokudai searchしてbest解のstateを返す
  @Override
  State search(State initialState) {
    iterations = 0;

    ArrayList<PriorityQueue<Action>> actionList = new ArrayList<>();
    actionList.add(new PriorityQueue<>());
    actionList.get(0).addAll(initialState.getCandidate());
    State bestState = null;
    while ( !main.isTimeOver() ) {
      for (int gen = 0; gen < actionList.size() && !main.isTimeOver(); gen++) {
        iterations++;
        PriorityQueue<Action> queue = actionList.get(gen);
        if ( queue.size() == 0 ) continue;

        if ( gen + 1 >= actionList.size() ) actionList.add(new PriorityQueue<>());

        PriorityQueue<Action> nqueue = actionList.get(gen + 1);
        boolean flg = false;
        if ( queue.size() > 0 ) {
          Action a = queue.poll();
          State s = a.baseState;
          State ns = s.clone();
          ns.commitAction(a);
          if ( ns.isFinished() ) {
            flg = true;
            if ( bestState == null || ns.eval() > bestState.eval() ) {
              bestState = ns;
              // main.debug(String.format("[update]eval=%d", bestState.eval()));
            }
          } else {
            nqueue.addAll(ns.getCandidate());
          }
        }

        if ( flg || main.isTimeOver() ) break;
      }
    }
    return bestState;
  }
}
