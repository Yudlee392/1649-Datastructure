
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yudlee
 */
public class Main {
        static Stack<String> stack = new Stack<>();
        static Queue<String> queue = new Queue<>();
        static String[] messages;
    private static void inputMessages(){
        System.out.print("Enter messages: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        messages = input.split(",");
    }

    private static void delivery(){
        try {
            Scanner sc = new Scanner(System.in);
            for(int i = 0; i < messages.length; i++){
                if(messages[i].equals("")){
                    throw new IOException();
                }else if(messages[i].length() > 250){
                    throw new ArrayIndexOutOfBoundsException("The message characters must be " +
                            "less than 250 character!!! Please retype");
                } else {
                    queue.offer(messages[i]);
                    System.out.println("Transferring message: \n" + messages[i] + " ...");
                }
            }
        } catch (IndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println(arrayIndexOutOfBoundsException.getMessage());
        } catch (IOException exception){
            System.out.println("You haven't typed anything yet!!! Please retype");
        }
    }

    private static void process(){
        while (!queue.isEmpty()){
            stack.push(queue.poll());
            System.out.println("Message has been sent successfully!!!");
        }
    }

    private static void result(){
        while (!stack.isEmpty()){
            System.out.println("Message receive: \n" + stack.pop());
        }
    }

    public static void main(String[] args){
        inputMessages();
        long startTime = System.nanoTime();
        delivery();
        process();
        result();
        long endTime = System.nanoTime();
        System.out.println("The system took " + (endTime - startTime) + "ms to run...");
    }
}