/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author Yudlee
 */
public interface AbstractQueue<E> extends Iterable<E> {
    void offer(E element);
    E poll();
    E peek();
    int size();
    boolean isEmpty();
}
