package com.example.demo.dataStructures;

import java.util.Scanner;

/**
 * @author: hurh
 * @description: 数组模拟队列
 * @date: Create in 2021/9/15 15:56
 * @modified By:
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';// 接收输入的字符
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取数据");
            System.out.println("h(head):查看队列头的数据");
        }

    }
}

// 使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue{
    // 数组的最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 该数组用于存放数据结构，模拟队列
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        // 指向队列头的前一个位置,队列第一个数据的前一个位置
        this.front = -1;
        // 指向队列尾的数据，即队列最后一个数据
        this.rear = -1;
    }

    // 判断队列是否满了
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    // 添加数据到队列  进队列
    public void addQueue(int i){
        if (isFull()){
            System.out.println("队列已满，不能添加数据....");
            return;
        }
        // rear后移 因为它总是指向队列尾
        rear++;
        arr[rear] = i;
    }

    // 取队列数据  出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        // front后移 队列先进先出 先进去的靠近front
        front ++;
        return arr[front];
    }

    // 遍历队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空...");
            return;
        }
        // 遍历数据 出了的队列的数据就不需要遍历了
        int start = front + 1;
        int end = rear + 1;
        for (int i = start; i < end; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列头的数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }

        return arr[front+1];
    }

}