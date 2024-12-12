import java.util.*;

public class SimplexMethod {

    // ------------ Затраты
    //
    private Integer[][][] C;
    //
    // ------------ Затраты



    // ------------ Предприятия
    //
    private Integer l; // Кол-во предприятий
    private Integer[] m; // Кол-во линий на k-том предприятии
    private Integer[][] M; // Производительность каждой из линий
    //
    // ------------ Предприятия



    // ------------ Мороженое
    //
    private Integer a; // Кол-во видов мороженого
    private Integer[] Z; // Плановое задание
    //
    // ------------ Мороженое



    public void algorithm() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать! Выберите пример решения:");
        System.out.println("(1) Исходные данные 1. Есть решение.");
        System.out.println("(2) Исходные данные 2. Есть решение.");
        System.out.println("(3) Исходные данные 3. Нет решений.");
        System.out.println("(4) Исходные данные 4. Нет решений.");
        int menu = scanner.nextInt();

        staticStart(menu);
        scanner.close();
    }

    private void staticStart(int menu) {

        switch (menu) {
            case (1): {
                l = 2;
                m = new Integer[]{ 2, 1 };
                M = new Integer[][]{
                        {12, 10},
                        {20, 0}
                };

                a = 3;
                Z = new Integer[]{ 10, 14, 7 };

                C = new Integer[][][]{
                        { { 5, 5 }, { 3, 0 } },
                        { { 3, 2 }, { 2, 0 } },
                        { { 6, 2 }, { 1, 0 } }
                }; }
                break;
            case (2): {
                l = 3;
                m = new Integer[]{2, 1, 1};
                M = new Integer[][]{
                        {20, 9},
                        {17, 0},
                        {15, 0}
                };

                a = 4;
                Z = new Integer[]{12, 18, 17, 9};

                C = new Integer[][][]{
                        {{5, 7}, {3, 0}, {4, 0}},
                        {{3, 3}, {5, 0}, {6, 0}},
                        {{8, 5}, {3, 0}, {3, 0}},
                        {{6, 5}, {4, 0}, {5, 0}}
                };
            }
                break;
            case (3): {
                l = 2;
                m = new Integer[]{2, 1};
                M = new Integer[][]{
                        {5, 2},
                        {3, 0}
                };

                a = 3;
                Z = new Integer[]{10, 14, 7};

                C = new Integer[][][]{
                        {{5}, {5}},
                        {{3}, {2}},
                        {{6}, {2}}
                };
            }
                break;
            case (4): {
                l = 3;
                m = new Integer[]{2, 1, 2};
                M = new Integer[][]{
                        {5, 2},
                        {3, 0},
                        {7, 4},
                };

                a = 2;
                Z = new Integer[]{10, 14};

                C = new Integer[][][]{
                        {{5, 6}, {7, 0}, {9, 2}},
                        {{6, 4}, {8, 0}, {2, 3}},
                        {{8, 3}, {4, 0}, {7, 3}}
                };
            }
                break;
            case (5): {
                l = 3;
                m = new Integer[]{2, 1, 2};
                M = new Integer[][]{
                        {5, 2},
                        {3, 0},
                        {7, 4},
                };

                a = 2;
                Z = new Integer[]{10, 14};

                C = new Integer[][][]{
                        {{5, 4, 3}},
                        {{6, 5, 4}}
                };
            }
                break;
            default:
                System.out.println("Ошибка ввода, повторите еще раз");
        }


        UserIO io = new UserIO();
        System.out.println("Количество предприятий");
        io.printVariable(l);
        System.out.println("Количество линий на каждом из предприятий");
        io.printOneDimensionalArray(m);
        System.out.println("Производительности линий");
        io.printTwoDimensionalArray(M);

        System.out.println("Количество типов мороженого");
        io.printVariable(a);
        System.out.println("Плановые количества типов мороженого");
        io.printOneDimensionalArray(Z);

        System.out.println("Расходы");
        io.printThreeDimensionalArray(C);
        Integer[][] Q = new Integer[][]{
                {-1, -2},
                {-3, -1},
                {-2, -3},
                {-1, -2},
                {-3, -1},
                {-2, -3},
                {-1, -1},
                {-2, -2}

        };
        new SimplexTable(l, m, M, a, Z, Q).algorithm().printResult();
    }


}