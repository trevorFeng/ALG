package com.alg.dynamic;

/**
 *
 * 一个机器人位于一个 m x n 网格的左上角
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class Test2 {

    /**
     * 典型的动态规划
     * 动态规划方程：P[i][j] = P[i-1][j] + P[i][j-1]
     * P[i][j]表示走到当前点总共的路径
     * * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0){
            return 0;
        }
        int[][] p = new int[m][n];
        for (int i = 0; i < m ;i++) {
            for (int j = 0 ; i< n ;j++) {
                if (i == 0 || j == 0) {
                    p[i][j] = 0;
                }else {
                    p [i][j] = p[i-1][j] + p[i][j-1];
                }

            }
        }
        return p[m-1][n-1];
    }
}
