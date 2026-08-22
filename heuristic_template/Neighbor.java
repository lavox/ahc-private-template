// template url : https://github.com/lavox/ahc-private-template/blob/main/heuristic_template/Neighbor.java
class Neighbor {
	final Input in;
	final Main main;
	double eval = 0;
	int id = 0;

	// TODO: パラメータ

	//TODO: コンストラクタ(必要なものを作成)
	Neighbor(Input in, Main main) {
		this.in = in;
		this.main = main;
		this.id = main.seq();
	}

	void setEval(double eval) {
		this.eval = eval;
	}
	double eval() {
		return eval;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		// TODO: 出力用文字列

		return str.toString();
	}
}
