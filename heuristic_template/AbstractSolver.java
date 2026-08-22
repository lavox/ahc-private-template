abstract class AbstractSolver<S extends ResultCreator> {
  final Input in;
  final Main main;
  int iterations = 0;

  AbstractSolver(Input in, Main main) {
    this.in = in;
    this.main = main;
  }

  // Resultにして返す
  public Result solve(S initialState) {
    S best = search(initialState);
    return best.createResult();
  }

  // State or Solutionを返す
  abstract S search(S initialState);
}

interface ResultCreator {
  public abstract Result createResult();
}