/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplolambdas1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author elkin
 */
public class Pruebas {

    public static void main(String[] args) {
      
        System.out.println("a");
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(() -> System.out.println("play"));
        executor.submit(() -> 
        {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
    }

}
