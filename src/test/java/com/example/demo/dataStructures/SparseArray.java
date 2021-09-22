package com.example.demo.dataStructures;

/**
 * @author: hurh
 * @description: 二维数组--->>>稀疏数组--->>>二维数组
 * @date: Create in 2021/9/15 14:28
 * @modified By:
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] array = createArray();
        int[][] ints = parseSparseArray(array);
        parseArrs(ints);

    }
    /*
      创建二维数组 11 * 11
      0：表示没有棋子，1：表示黑子，2：表示白子
     */
    private static int[][] createArray(){
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][2] = 1;
        System.out.println("原始二维的数组：");
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        System.out.println();
        return chessArr;
    }

    /*
     二维数组转稀疏数组
     */
    private static int[][] parseSparseArray(int[][] chessArr){
        int num = 0;// 棋盘上棋子的个数
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0){
                    num++;
                }
            }
        }

        // 稀疏数组第一列：行数 列数 棋子个数
        int[][] sparseArray = new int[num+1][3];
        sparseArray[0][0] = chessArr.length;
        sparseArray[0][1] = chessArr[0].length;
        sparseArray[0][2] = num;

        int count = 0;// 稀疏数组的行数
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0){
                    count ++; // 因为稀疏数组第一行已经确定，为稀疏数组的基本数据
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }

        System.out.println("稀疏数组的输出：");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();
        return sparseArray;
    }

    /*
      稀疏数组转二维数组
      1.先读取稀疏数组第一行数组，确定二维数组行、列、棋子个数
      2.读取稀疏数组各行数组，赋给二维数组即可
     */
    private static int[][] parseArrs(int[][] sparseArray){
        int chessArr[][] = new int[sparseArray[0][0]][sparseArray[0][1]];

        // 稀疏数组第一行为二维数组基本数据 所以不需要遍历获取
        for (int i = 1; i < sparseArray.length; i++) {
            // 从稀疏数组第二行开始，第一列为二维数组的行下标，第二列为二维数组的列下标，第三列为二维数组的值
            chessArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("恢复的二维数组：");
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        return chessArr;
    }
}
