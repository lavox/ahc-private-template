// template url : https://github.com/lavox/ahc-private-template/blob/main/heuristic_template/Result.java
class Result {
	final Input in;

	// 統計情報
	int caseNum = 0;
	long elapsed = 0;
	int iterations = 0;
	long score = 0;

	// 結果情報
	// ArrayList<Action> actions = null;

	Result(Input in) {
		this.in = in;
	}

	long score() {
		return score;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		//TODO: 結果出力
		return out.toString();
	}
}
