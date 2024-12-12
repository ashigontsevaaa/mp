public class MathOperation {
    public Integer maximum(Integer[] arr) {
        Integer max = 0;
        for (Integer item : arr) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    public Integer sumArr(Integer[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public Integer sumArrCube(Integer[][][] arr) {
        int sum = 0;
        int depth = arr.length;
        int height = arr[0].length;
        int width = arr[0][0].length;


        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    if (arr[i][j][k] != 0) {
                        ++sum;
                    }
                }
            }
        }
        return sum;
    }
}
