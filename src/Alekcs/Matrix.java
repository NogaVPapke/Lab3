package Alekcs;

import java.util.Random;
import java.util.Arrays;
public class Matrix {
    private int size1;
    private int size2;
    private int[][] incAmount;

    public Matrix(int size1)
    {
        this.size1 = size1;
        this.size2 = size1;
        this.incAmount = new int[this.size1][this.size2];
        this.RandomValue();
    }

    public Matrix() {
        this.size1 = 3;
        this.size2 = this.size1;
        this.incAmount = new int[this.size1][this.size2];
        RandomValue();
    }

    public Matrix(int[][] incAmount)
    {
        this.Value(incAmount);
    }

    public void Change() {
        float coef = 1;
        for (int i = 0; i < incAmount.length - 1; i++) {
            for (int j = i + 1; j < incAmount[i].length; j++) {
                coef = (float) incAmount[j][i] / incAmount[i][i];
                for (int z = i; z <incAmount[j].length; z++) {
                    int temp = incAmount[i][z];
                    temp *= coef;
                    incAmount[j][z] -= temp;
                }
            }
        }
    }


    public void Conclusion() {
        for (int ii = 0; ii < incAmount.length; ii++) {
            for (int jj = 0; jj < incAmount.length; jj++) {
                System.out.print(incAmount[ii][jj] + "\t");
            }
            System.out.println();
        }
    }

    public void Sum() {
        System.out.println("с) Найти сумму треугольной матрицы:");
        int sum = 0;
        for (int ii = 0; ii < incAmount.length; ii++) {
            for (int jj = 0; jj < incAmount.length; jj++) {
                if (ii < jj || ii == jj) {
                    sum += incAmount[ii][jj];
                }
                System.out.print(incAmount[ii][jj] + "\t");
            }
        }
        System.out.println();
        System.out.println("Сумма: " + sum);
    }

    public void PositiveArray() {
        System.out.println("d) Сформировать строку из всех положительных элементов треугольной матрицы: ");
        String string = "";
        String str = "";
        int a;
        for (int ii = 0; ii <incAmount.length; ii++) {
            for (int jj = 0; jj < incAmount.length; jj++) {
                if (ii < jj || ii == jj) {
                    a = incAmount[ii][jj];

                    if (a > 0) {
                        string = a + "";
                        System.out.print("   " + string + " ");
                    }
                }
            }
        }
    }
    public int[][] getMatrix()
    {
        return this.incAmount;
    }
    public void RandomValue()
    {
        Random r = new Random();
        for(int i =0; i < this.size1; i++)
        {
            for (int j =0; j< this.size2;j ++) {
                this.incAmount[i][j] = r.nextInt(10) - 5;
            }
        }
    }
    private void Value(int[][] sourceArr)
    {
        this.incAmount = Arrays.copyOf(sourceArr,sourceArr.length);
        this.size1 = sourceArr.length;
        this.size2 = sourceArr.length;
    }
}
