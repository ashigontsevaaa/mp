import java.util.ArrayList;
import java.util.List;

public class SimplexTable {

    private int width;
    private int height;
    private List<Variable> horizontalVariables;
    private List<Variable> verticalVariables;
    private List<List<Double>> data;
    private double[][] recalculatingTable;
    private boolean solved = false;
    private boolean targetSwaped = false;
    private Integer[][] C;


    SimplexTable(Integer l, Integer[] m, Integer[][] M, Integer a, Integer[] Z, Integer[][] C) {

        data = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1., 1., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 1., 0.,0., 0., 0., 0., 0., 0., 0., 0., 2.)),
                new ArrayList<>(List.of(0., 0., 1., 1., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.,0., 1.,0., 0., 0., 0., 0., 0., 0., 0., 3.)),
                new ArrayList<>(List.of(0., 0., 0., 0., 1., 1., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.,0., 0.,1., 0., 0., 0., 0., 0., 0., 0., 2.)),
                new ArrayList<>(List.of(0., 0., 0., 0., 0., 0., 1., 1., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.,0., 0.,0., 1., 0., 0., 0., 0., 0., 0., 1.)),
                new ArrayList<>(List.of(0., 0., 0., 0., 0., 0., 0., 0., 1., 1., 0., 0., 0., 0., 0., 0., 0., 0.,0., 0.,0., 0., 1., 0., 0., 0., 0., 0., 2.)),
                new ArrayList<>(List.of(0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 1., 1., 0., 0., 0., 0., 0., 0.,0., 0.,0., 0., 0., 1., 0., 0., 0., 0., 3.)),
                new ArrayList<>(List.of(0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 1., 1., 0., 0., 0., 0.,0., 0.,0., 0., 0., 0., 1., 0., 0., 0., 1.)),
                new ArrayList<>(List.of(0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 1., 1., 0., 0.,0., 0.,0., 0., 0., 0., 0., 1., 0., 0., 2.)),
                new ArrayList<>(List.of(-1., 0., -1., 0., -1., 0., -1., 0., -1., 0., -1., 0., -1., 0., -1., 0., 0., 0.,0., 0.,0., 0., 0., 0., 0., 0., -1., 0., 4.)),
                new ArrayList<>(List.of(0., -1., 0., -1., 0., -1., 0., -1., 0., -1., 0., -1., 0., -1., 0., -1., 0., 0.,0., 0.,0., 0., 0., 0., 0., 0., 0., -1., 5.)),
                new ArrayList<>(List.of(0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., -1., -1., 25.))

        ));

        horizontalVariables = new ArrayList<>(List.of(
                new Variable('x', 1, 1),
                new Variable('x', 2, 1),
                new Variable('x', 1, 2),
                new Variable('x', 2, 2),
                new Variable('x', 1, 3),
                new Variable('x', 2, 3),
                new Variable('x', 1, 4),
                new Variable('x', 2, 4),
                new Variable('x', 1, 5),
                new Variable('x', 2, 5),
                new Variable('x', 1, 6),
                new Variable('x', 2, 6),
                new Variable('x', 1, 7),
                new Variable('x', 2, 7),
                new Variable('x', 1, 8),
                new Variable('x', 2, 8),
                new Variable('y', 1, 0),
                new Variable('y', 2, 0),
                new Variable('y', 3, 0),
                new Variable('y', 4, 0),
                new Variable('y', 5, 0),
                new Variable('y', 6, 0),
                new Variable('y', 7, 0),
                new Variable('y', 8, 0),
                new Variable('y', 9, 0),
                new Variable('y', 10, 0),
                new Variable('b', 0, 0)
        ));


        verticalVariables = new ArrayList<>(List.of(
                new Variable('V', 1, 0),
                new Variable('V', 2, 0),
                new Variable('V', 3, 0),
                new Variable('V', 4, 0),
                new Variable('V', 5, 0),
                new Variable('V', 6, 0),
                new Variable('V', 7, 0),
                new Variable('V', 8, 0),
                new Variable('V', 9, 0),
                new Variable('V', 10, 0),
                new Variable('L', 0, 0)
        ));






//        data = new ArrayList<>(List.of(
//                new ArrayList<>(List.of(1., 0., 0., 1., 0., 0., -1., 0., 0., 0., 0., 11.)),
//                new ArrayList<>(List.of(0., 1., 0., 0., 1., 0., 0., -1., 0., 0., 0., 13.)),
//                new ArrayList<>(List.of(0., 0., 1., 0., 0., 1., 0., 0., -1., 0., 0., 7.)),
//                new ArrayList<>(List.of(1., 1., 1., 0., 0., 0., 0., 0., 0., 1., 0., 11.)),
//                new ArrayList<>(List.of(0., 0., 0., 1., 1., 1., 0., 0., 0., 0., 1., 11.)),
//                new ArrayList<>(List.of(2., 2., 2., 2., 2., 2., -1., -1., -1., 1., 1., 53.))
//        ));
//
//        horizontalVariables = new ArrayList<>(List.of(
//                new Variable('x', 1, 1, 1),
//                new Variable('x', 1, 2, 1),
//                new Variable('x', 1, 3, 1),
//                new Variable('x', 1, 1, 2),
//                new Variable('x', 1, 2, 2),
//                new Variable('x', 1, 3, 2),
//                new Variable('y', 1, 0, 0),
//                new Variable('y', 2, 0, 0),
//                new Variable('y', 3, 0, 0),
//                new Variable('y', 4, 0, 0),
//                new Variable('y', 5, 0, 0),
//                new Variable('b', 0, 0, 0)
//        ));
//
//
//        verticalVariables = new ArrayList<>(List.of(
//                new Variable('V', 1, 0, 0),
//                new Variable('V', 2, 0, 0),
//                new Variable('V', 3, 0, 0),
//                new Variable('V', 4, 0, 0),
//                new Variable('V', 5, 0, 0),
//                new Variable('L', 0, 0, 0)
//        ));

//        this.createTable(l, m, M, a, Z, C);
        this.C = C;
        this.width = horizontalVariables.size() - 1;
        this.height = verticalVariables.size();
        recalculatingTable = new double[this.height][this.width + 1];
    }

    public void createTable(Integer l, Integer[] m, Integer[][] M, Integer a, Integer[] Z, Integer[][][] C) {
        horizontalVariables = new ArrayList<>();
        int xCount = 0;
        for (int i = 0; i < m.length; i++) {
            xCount += m[i] * a;
        }
        int index = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < m[i]; j++) {
                for (int k = 0; k < a; k++) {
                    horizontalVariables.add(new Variable('x', j + 1, i + 1));
                }
            }
        }

        int yCount = 0;
        for (int i = 0; i < m.length; i++) {
            yCount += m[i];
        }
        yCount += a;
        for (int i = 1; i <= yCount; i++) {
            horizontalVariables.add(new Variable('y', i, 0));
        }

        horizontalVariables.add(new Variable('b', 0, 0));

        //-------------------------------------------------------------------------------------

        verticalVariables =new ArrayList<>();
        for (int i = 1; i <= yCount; i++) {
            verticalVariables.add(new Variable('V', i, 0));
        }

        verticalVariables.add(new Variable('L', 0, 0));

        //-------------------------------------------------------------------------------------

        data = new ArrayList<>();
        for (int i = 0; i < verticalVariables.size() - 1; i++) {
            data.add(new ArrayList<>());
            for (int j = 0; j < horizontalVariables.size() - 1; j++) {
                data.get(i).add(0.);
            }
        }

        int iceCreamIndex = 1;
        for (int i = 0; i < Z.length; i++) {
            for (int j = 0; j < horizontalVariables.size() - 1; j++) {
                if (iceCreamIndex == horizontalVariables.get(j).j()) {
                    data.get(i).set(j, 1.);
                }
            }
            if (iceCreamIndex < Z.length) {
                ++iceCreamIndex;
            }
            else {
                iceCreamIndex = 1;
            }
        }

        int lineIndexFirst = 0;
        int lineIndexSecond = a;
        for (int i = Z.length; i < verticalVariables.size() - 1; i++) {
            for (int j = 0; j < horizontalVariables.size() - 1; j++) {
                if ((j >= lineIndexFirst) && (j < lineIndexSecond)) {
                    data.get(i).set(j, 1.);
                }
            }
            lineIndexFirst += a;
            lineIndexSecond += a;
        }

        for (int i = 0; i < verticalVariables.size() - 1; i++) {
            for (int j = 0; j < horizontalVariables.size() - 1; j++) {
                if ((horizontalVariables.get(j).letter() == 'y') && (j - xCount == i)) {
                    if (i < a) {
                        data.get(i).set(j, -1.);
                    }
                    else {
                        data.get(i).set(j, 1.);
                    }
                }
            }
        }

        for (int i = 0; i < a; i++) {
            data.get(i).add((double) Z[i]);
        }
        List<Double> tempB = new ArrayList<>();
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] != 0){
                    tempB.add((double) M[i][j]);
                }
            }
        }
        for (int i = a; i < verticalVariables.size() - 1; i++) {
            data.get(i).add(tempB.get(i - a));
        }

        int tempSum = 0;
        List<Double> tempL = new ArrayList<>();
        for (int j = 0; j < horizontalVariables.size(); j++) {
            for (int i = 0; i < verticalVariables.size() - 1; i++) {
                tempSum += data.get(i).get(j);
            }
            tempL.add((double) tempSum);
            tempSum = 0;
        }
        data.add(tempL);


        System.out.print("    ");
        for (int i = 0; i < horizontalVariables.size(); i++) {
            System.out.print(horizontalVariables.get(i).letter());
            System.out.print(horizontalVariables.get(i).i());
            System.out.print(horizontalVariables.get(i).j()+ " ");
        }
        System.out.println();
        for (int i = 0; i < verticalVariables.size(); i++) {
            System.out.print(verticalVariables.get(i).letter());
            System.out.print(verticalVariables.get(i).i());
            System.out.print(verticalVariables.get(i).j()+ " ");
            System.out.println(data.get(i));
        }
        System.out.println();
    }

    public SimplexTable algorithm(){
        while (true){
            double max = 0;
            int maxIndex = 0;
            for (int i = 0; i < width; i++){
                if (data.get(height - 1).get(i) > max){
                    max = data.get(height - 1).get(i);
                    maxIndex = i;
                }
            }
            if (max < 0.000001 || solved) break;
            iteration(maxIndex);
        }

        return this;
    }

    private void iteration(int column) {
        double min = -1;
        int row = -1;
        for (int i = 0; i < height - 1; i++){
            if (data.get(i).get(column) < 0.000001) continue;
            if ((data.get(i).get(width) / data.get(i).get(column) < min) || (row == -1)){
                min = data.get(i).get(width) / data.get(i).get(column);
                row = i;
            }
        }

        if (min == -1) {
            System.out.println("Оптимального решения не существует");
            this.solved = true;
            return;
        }


        double lambda = recalculatingTable[row][column] = 1/data.get(row).get(column);
        for (int i = 0; i < height; i++){
            if (i == row) continue;
            recalculatingTable[i][column] = -data.get(i).get(column)*lambda;
        }
        for (int i = 0; i < horizontalVariables.size(); i++){
            if (i == column) continue;
            recalculatingTable[row][i] = data.get(row).get(i)*lambda;
        }
        for (int i = 0; i < verticalVariables.size(); i++){
            for (int j = 0; j < horizontalVariables.size(); j++){
                if ((i == row) || (j == column)) continue;
                recalculatingTable[i][j] = recalculatingTable[i][column] * data.get(row).get(j);
            }
        }

        for (int i = 0; i < verticalVariables.size(); i++){
            for (int j = 0; j < horizontalVariables.size(); j++){
                if ((i == row) || (j == column)) {
                    data.get(i).set(j, recalculatingTable[i][j]);
                } else data.get(i).set(j, data.get(i).get(j) + recalculatingTable[i][j]);;
            }
        }
        Variable tempVariable = horizontalVariables.get(column);
        horizontalVariables.set(column, verticalVariables.get(row));
        verticalVariables.set(row, tempVariable);
        if (horizontalVariables.get(column).letter() == 'V') {
            horizontalVariables.remove(column);
            --width;
            for (int i = 0; i < height; i++) {
                data.get(i).remove(column);
            }
        }

        System.out.print("    ");
        for (int i = 0; i < horizontalVariables.size(); i++) {
            System.out.print(horizontalVariables.get(i).letter());
            System.out.print(horizontalVariables.get(i).i());
            System.out.print(horizontalVariables.get(i).j() + " ");
        }
        System.out.println();
        for (int i = 0; i < verticalVariables.size(); i++) {
            System.out.print(verticalVariables.get(i).letter());
            System.out.print(verticalVariables.get(i).i());
            System.out.print(verticalVariables.get(i).j()+ " ");
            System.out.println(data.get(i));
        }
        System.out.println();

        for (int i = 0; i < verticalVariables.size() - 1; i++) {
            if ((verticalVariables.get(i).letter() == 'V') || (targetSwaped)) {
                break;
            }
            if (i == verticalVariables.size() - 2) {
                recountTarget();
            }
        }
    }

    public void recountTarget() {
        System.out.println();
        System.out.println();
        System.out.println("===================================================================");
        System.out.println("V-задача решена. Существует как минимум одно действительное решение");
        System.out.println("===================================================================");
        System.out.println();
        System.out.println();
        System.out.println();



        if (targetSwaped) {
            return;
        }
        targetSwaped = true;
        List<Double> swapElem = new ArrayList<>();
        for (int i = 0; i < horizontalVariables.size(); i++) {
            swapElem.add(i, 0.);
        }


        for (int i = 0; i < verticalVariables.size() - 1; i++) {
            for (int j = 0; j < horizontalVariables.size(); j++) {
                Variable variable = verticalVariables.get(i);
                if ((variable.letter() == 'L') || (variable.letter() == 'y')) {
                    continue;
                }
                Double prev = swapElem.get(j);

                Double elem = data.get(i).get(j) * C[variable.j() - 1][variable.i() - 1];
                swapElem.set(j, prev + elem);
            }
        }

        for (int i = 0; i < horizontalVariables.size(); i++) {
            Variable variable = horizontalVariables.get(i);
            if ((variable.letter() == 'b') || (variable.letter() == 'y')) {
                continue;
            }
            Double elem = swapElem.get(i);
            swapElem.set(i, elem - C[variable.j() - 1][variable.i() - 1]);
        }

        data.set(data.size() - 1, swapElem);
    }

    public void printResult(){
        for (int i = 0; i < verticalVariables.size(); i++) {
            if (verticalVariables.get(i).letter() == 'V') {
                System.out.println();
                System.out.println();
                System.out.println("===================================================================");
                System.out.println("V-задача не решена. Нет решений");
                System.out.println("===================================================================");
                System.out.println();
                System.out.println();
                System.out.println();
                return;
            }
        }

        List <Result> results = new ArrayList<>(verticalVariables.size());

        for (int i = 0; i < verticalVariables.size(); i++){
            if (verticalVariables.get(i).letter() == 'x')
                results.add(new Result(verticalVariables.get(i), data.get(i).get(width)));
        }

        for (Result result : results) {
            System.out.println("x" + result.variable().i() + "" + result.variable().j() + "" + " = " + result.value());
        }

        for (Result result : results) {

        }

        System.out.println("L = " + data.get(verticalVariables.size() - 1).get(horizontalVariables.size() - 1));

    }

}