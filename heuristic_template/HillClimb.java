// template url : https://github.com/lavox/ahc-private-template/blob/main/heuristic_template/HillClimb.java
class HillClimb extends AbstractSolver<Solution> {
	int TL_CHECK_INTERVAL = 10; // 時間更新の周期

	long timeLimit = 0;

	HillClimb(Input in, Main main, long timeLimit) {
		super(in, main);
		this.timeLimit = timeLimit;
	}

	@Override
	Solution search(Solution initialSolution) {
		iterations = 0;
		Solution s = initialSolution;
		while ( true ) {
			if ( iterations++ % TL_CHECK_INTERVAL == 0 && main.elapsed() >= timeLimit ) {
				break;
			}
			Neighbor nbr = s.getCandidate();
			s.calcNeighborEval(nbr);
			double delta = - nbr.eval() + s.eval();
			if ( delta < 0 ) {
				double old_eval = s.eval();
				s.commit(nbr);
				// main.debug(String.format("[update]%.2f->%.2f", old_eval, s.eval()));
			}
		}
		return s;
	}
}
