import java.util.PriorityQueue;

// template url : https://github.com/lavox/ahc-private-template/blob/main/heuristic_template/BeamSearch.java
class BeamSearch extends AbstractSolver<State> {
	int beamCnt = 0;

	BeamSearch(Input in, Main main, int beamCnt) {
		super(in, main);
		this.beamCnt = beamCnt;
	}

	// beam searchしてbest解のstateを返す
	@Override
	State search(State initialState) {
		iterations = 0;

		PriorityQueue<Action> queue = new PriorityQueue<>();
		queue.addAll(initialState.getCandidate());

		State bestState = null;
		while ( queue.size() > 0 && bestState == null ) {
			iterations++;
			PriorityQueue<Action> nqueue = new PriorityQueue<>();
			for ( int b = 0 ; b < beamCnt && queue.size() > 0 ; b++ ) {
				Action a = queue.poll();
				State s = a.baseState;
				State ns = s.clone();
				ns.commitAction(a);
				if ( ns.isFinished() ) {
					if ( bestState == null || ns.eval() > bestState.eval() ) {
						bestState = ns;
						// main.debug(String.format("[update]eval=%d", bestState.eval()));
					}
				} else {
					nqueue.addAll(ns.getCandidate());
				}
			}
			queue = nqueue;
		}
		return bestState;
	}
}
