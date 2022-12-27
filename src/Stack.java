/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yudlee
 */
import interfaces.AbstractStack;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Scanner;

public class Stack<E> implements AbstractStack<E> {
    private static final int MAX = 100;
    private int length;
    private int top;
    private E[] elements;

    public Stack(){
        elements =  (E[])new Object[MAX];
        top = -1;
        length = 0;
    }
    @Override
    public void push(E element) {
        if (length == MAX) throw new IllegalStateException("Stack Overflow!!");
        elements[++top] = element;
        length++;
    }
    public String toString(){
        int current = top;
        StringBuilder result = new StringBuilder();
        while(current>=0){
            result.append(elements[current]+ "\n");
           current--;
        }
        return result.toString();
    }
    @Override
    public E pop() {
        if (length==0) throw new IllegalStateException("Stack Underflow!!");
        E data = elements[top--];
        length --;
        return data;
    }

    @Override
    public E peek() {
        if (length==0) throw new IllegalStateException("Stack Underflow!!");
        return elements[top];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = top;
            @Override
            public boolean hasNext() {
                return index>=0;
            }

            @Override
            public E next() {
                E data = elements[index];
                index--;
                return data;
            }
        };
    }
}
