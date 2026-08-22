// template url : https://github.com/lavox/ahc-private-template/blob/main/heuristic_template/Solution.java
class Solution implements ResultCreator {
	final Input in;
	final Main main;

	int id = 0;
	long eval = 0; // 大きい方が良いとする
	long score = 0;

	//TODO: 状態を保持する変数

	Solution(Input in, Main main) {
		this.in = in;
		this.main = main;
		this.id = main.seq();
	}

	@Override
	public Solution clone() {
		Solution ret = null;
		try {
			ret = (Solution)super.clone();
			//TODO: オブジェクトや配列はdeep copyする
		} catch (CloneNotSupportedException e) {
		}
		return ret;
	}

	static Solution createInitialSolution(Input in, Main main) {
		Solution s = new Solution(in, main);
		s.initSolution();
		return s;
	}

	void initSolution() {
		//TODO: 初期局面の生成

	}

	// neighborの評価値を計算しneighborに設定する。
	void calcNeighborEval(Neighbor neighbor) {
		apply(neighbor);
		neighbor.eval = this.eval();
		unapply(neighbor);
		//TODO: apply→評価値計算→unapplyで実装。必要に応じて独自実装に改造する
	}

	// neighborを適用する
	void apply(Neighbor neighbor) {
		//TODO: 状態変数の変更、評価値の計算
		this.eval = 0;
	}

	void unapply(Neighbor neighbor) {
		//TODO: Actionのキャンセル。calcNeighborEval()でunapplyを使用する場合に必要。使わない場合は消しても良い
		//TODO: evalの変更
	}

	// 候補となるneighborを生成する
	Neighbor getCandidate() {
		//TODO:
		return null;
	}

	// スコアを計算してscoreにセットする
	void calcScore() {
		//TODO:
		this.score = 0;
	}

	double eval() {
		return eval;
	}
	long score() {
		return score;
	}

	void commit(Neighbor neighbor) {
		apply(neighbor);
		assert eval == neighbor.eval();
		//TODO: commit後に状態を確定させるための処理等があれば行う
	}

	public Result createResult() {
		Result ret = new Result(in);
		//TODO: 結果をセットする。
		ret.score = score();
		return ret;
	}
}
