import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;

// template url : https://github.com/lavox/ahc-private-template/blob/main/heuristic_template/Main.java
class Main {
	static final long TL = 1650;

	// Input Data
	Input in = null;
	FastScanner sc = null;
	InputStream stdin = null;
	PrintStream stdout = null;

	// Start time
	long startTime = 0;
	// Remaining time till timeLimit
	long timeRemain( long timeLimit ) { return timeLimit - elapsed(); }
	// Elapsed time from start
	long elapsed() { return System.currentTimeMillis() - startTime; }
	long timeLimit() { return TL; }
	boolean isTimeOver() { return elapsed() >= timeLimit(); }

	Random rnd = new Random(41L);
	private int seq = 0;

	static final String LF = "\n";

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.stdin = System.in;
		main.stdout = System.out;
		main.solve();
	}

	Input readInput() throws IOException {
		sc = new FastScanner(stdin);
		Input in = new Input();
		in.readParameter(sc);
		return in;
	}

	public Result solve() throws IOException {
		this.startTime = System.currentTimeMillis();
		// インプットの読み込み
		in = readInput();
		in.preCalc();
		
		//TODO: implement here
		// Greedy sol = new Greedy(in);
		// Result result = sol.solve();
		
		Result result = null;

		printResult(result);
		return result;
	}

	public void printResult(Result result) {
		println(result.toString());
	}
	public void println(String str) {
		stdout.println(str);
	}
	public void print(String str) {
		stdout.print(str);
	}
	int rnd(int bound) {
		return rnd.nextInt(bound);
	}
	int seq() {
		return seq++;
	}
	double rndDouble() {
		return rnd.nextDouble();
	}

	public void debug(String str) {}
}
