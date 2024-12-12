import java.util.*;

public class UserIO {

    public Integer fillVariable(Scanner scanner) {
        return scanner.nextInt();
    }

    public Integer[] fillOneDimensionalArray(Scanner scanner, Integer size, String info) {
        
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            System.out.println(info + " " + i);
            array[i] = scanner.nextInt();
            
        }
        
        return array;
    }

    public Integer[][] fillTwoDimensionalArray(Scanner scanner, Integer rows, Integer[] columns, Integer max, String info) {
        Integer[][] array = new Integer[rows][max];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns[i]; j++) {
                System.out.println(info + " " + i + "/" + j);
                array[i][j] = scanner.nextInt();
                
            }
            for (int j = columns[i]; j < max; j++) {
                array[i][j] = 0;
            }
        }
        
        return array;
    }

    public Integer[][][] fillThreeDimensionalArray(Scanner scanner, Integer depth, Integer rows, Integer[] columns, Integer max, String info) {
        Integer[][][] array = new Integer[depth][rows][max];
        for (int d = 0; d < depth; d++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns[i]; j++) {
                    System.out.println(info + " " + d + "/" + i + "/" + j);
                    array[d][i][j] = scanner.nextInt();
                    
                }
                for (int j = columns[i]; j < max; j++) {
                    array[d][i][j] = 0;
                }
            }
        }
        
        return array;
    }


    public void printVariable(Integer var) {
        System.out.println();
        System.out.println(var);
        System.out.println();
    }

    public void printOneDimensionalArray(Integer[] array) {
        System.out.println();
        for (Integer value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println();
    }

    public void printTwoDimensionalArray(Integer[][] array) {
        System.out.println();
        for (Integer[] row : array) {
            for (Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printThreeDimensionalArray(Integer[][][] array) {
        System.out.println();
        for (Integer[][] matrix : array) {
            for (Integer[] row : matrix) {
                for (Integer value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
}
