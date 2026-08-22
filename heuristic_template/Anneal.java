// template url : https://github.com/lavox/ahc-private-template/blob/main/heuristic_template/Anneal.java
class Anneal extends AbstractSolver<Solution> {
	int TL_CHECK_INTERVAL = 10; // 時間更新の周期
	int ROLLBACK_INTERVAL = 20000; // 更新がなかった場合にbestに戻す
	double TEMPERATURE_HIGH = 10000.0; // 温度(高)
	double TEMPERATURE_LOW = 1.0; // 温度(低)

	long timeLimit = 0;
	long startTime = 0;

	Anneal(Input in, Main main, long timeLimit) {
		super(in, main);
		this.timeLimit = timeLimit;
	}

	@Override
	Solution search(Solution initialSolution) {
		startTime = main.elapsed();

		iterations = 0;
		int lastUpdateIter = 0;
		Solution s = initialSolution;
		Solution bestState = (Solution)s.clone();
		long time = startTime;
		double temperature = temperature();
		while ( true ) {
			if ( iterations++ % ROLLBACK_INTERVAL == 0 ) {
				time = main.elapsed();
				if ( time >= timeLimit ) break;
				temperature = temperature();
				if ( iterations - lastUpdateIter > ROLLBACK_INTERVAL ) {
					s = bestState.clone();
				}
			}
			Neighbor nbr = s.getCandidate();
			s.calcNeighborEval(nbr);
			double delta = - nbr.eval() + s.eval();
			if ( eval(time, delta, temperature) ) {
				double old_eval = s.eval();
				s.commit(nbr);
				// main.debug(String.format("[update]%.2f->%.2f", old_eval, s.eval()));
				if ( s.eval() > bestState.eval() ) {
					bestState = s.clone();
					lastUpdateIter = iterations;
				}
			}
		}
		return bestState;
	}
	boolean eval(long time, double delta, double temperature) {
		if ( delta <= 0 ) return true;
		double r = main.rndDouble();
		double e = Math.exp(-delta / temperature);
		return r < e;
	}
	double temperature() {
		double t = ((double)main.elapsed() - startTime) / (timeLimit - startTime);
		return Math.pow(TEMPERATURE_HIGH, 1.0 - t) * Math.pow(TEMPERATURE_LOW, t);
	}
}
